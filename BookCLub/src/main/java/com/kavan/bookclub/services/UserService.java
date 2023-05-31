package com.kavan.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kavan.bookclub.models.LoginUser;
import com.kavan.bookclub.models.User;
import com.kavan.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		// TO-DO: Additional validations!
// TO-DO - Reject values or register if no errors:

		// Reject if email is taken (present in database)
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "taken", "That email is already taken!");
		}
		// Reject if password doesn't match confirmation
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords must match!");
		}
		// Return null if result has errors
		if (result.hasErrors())
			return null;

		// Hash and set password, save user to database
		String hashedPass = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPass);
		return userRepo.save(newUser);
	}

	public User login(LoginUser newLoginObject, BindingResult result) {
		// TO-DO: Additional validations!
		// TO-DO - Reject values:
		Optional<User> optionalUser = userRepo.findByEmail(newLoginObject.getEmail());

		// Find user in the DB by email
		// Reject if NOT present
		if (!optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "Can not find a user registered to that email!");
			return null;
		}

//    	If present
		User user = optionalUser.get();

		// Reject if BCrypt password match fails
		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Incorrect password!");
		}

		// Return null if result has errors
		if (result.hasErrors())
			return null;
		// Otherwise, return the user object
		return user;
	}

	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
}
