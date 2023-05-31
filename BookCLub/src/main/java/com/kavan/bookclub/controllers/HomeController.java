package com.kavan.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kavan.bookclub.models.Book;
import com.kavan.bookclub.models.LoginUser;
import com.kavan.bookclub.models.User;
import com.kavan.bookclub.services.BookService;
import com.kavan.bookclub.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.register(newUser, result);

		if (result.hasErrors()) {

			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		session.setAttribute("userId", user.getId());

		return "redirect:/books";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		session.setAttribute("userId", user.getId());

		return "redirect:/books";
	}

	@GetMapping("/books")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findUser(userId));

		List<Book> books = bookService.allBooks();

		model.addAttribute("books", books);

		return "home.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}

	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		}
		return "new.jsp";
	}

	@PostMapping("/books/new")
	public String newBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		}
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			bookService.createBook(
					new Book(book.getTitle(), book.getAuthor(), book.getThoughts(), userService.findUser(userId)));
			return "redirect:/books";
		}
	}

	@GetMapping("/books/{id}")
	public String book(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userService.findUser(userId));
		Book book = bookService.oneBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}

	@GetMapping("/books/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		if (userId == null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userService.findUser(userId));
		Book book = bookService.oneBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}

	@PutMapping("/books/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("book") Book book,
			BindingResult result, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		}
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		}
		bookService.deleteBook(bookService.oneBook(id));
		return "redirect:/books";

	}

}