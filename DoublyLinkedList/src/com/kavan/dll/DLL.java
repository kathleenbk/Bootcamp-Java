package com.kavan.dll;

public class DLL {
	public DLLNode head;
	public DLLNode tail;
	
	public DLL() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(int value) {	
		DLLNode newNode = new DLLNode(value);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
	}
	
	public void addFirst(int value) {
		DLLNode newNode = new DLLNode(value);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
	}
	
	public void addAt(int value, int indexVal) {
		DLLNode newNode = new DLLNode(value);
		
		if(indexVal==0) {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}else {
			DLLNode runner = head;
			
			for(int i=0; i<indexVal-1; i++) {
				if(runner!=null) {
					runner = runner.next;
				}
			}
			
			newNode.next = runner.next;
			newNode.previous = runner;
			runner.next = newNode;
			if(newNode.next!=null) {
				newNode.next.previous = newNode;
			}
			
		}
	}
	
	public void printValues() {
		if(head == null) {
			System.out.println("Nothing here");
		}else {
			DLLNode runner = head;
			while(runner.next != null) {
				System.out.println("Node Value: " + runner.value);
				System.out.println("NextInt Value: " + runner.next.value);
				runner = runner.next;
			}
		}
		System.out.println("***********************************");
	}
	
	public void printValuesReverse() {
		if(tail == null) {
			System.out.println("Nothing here");
		}else {
			DLLNode runner = tail;
			while(runner.previous != null) {
				System.out.println("Node Value:  " + runner.value);
				System.out.println("NextInt Value: " + runner.previous.value);
				runner = runner.previous;
			}
		}
		System.out.println("***********************************");
	}
	
	public boolean isPalindrome() {
		if(size()>1) {
			int half = (int)size()/2;
			String left = "";
			String right = "";
			DLLNode runner = head;
			for(int i=0; i<half; i++) {
				left += runner.value;
				runner = runner.next;
			}
			
			runner = tail;
			for(int i=0; i<half; i++) {
				String runnerString = runner.value.toString();
				for(int j=runnerString.length()-1; j>=0; j--) {
					right+=runnerString.charAt(j);
				}
				runner = runner.previous;
			}
			
			if(left.equals(right)) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		int count = 0;
		if(head == null) {
			return count;
		}else {
			DLLNode runner = head;
			while(runner.next != null) {
				count++;
				runner = runner.next;
			}
		}
		return count + 1;
	}
	
	public boolean contains(int number) {
		if(head != null) {
			DLLNode runner = head;
			while(runner.next != null) {
				if(runner.value==number) {
					return true;
				}
				runner = runner.next;
			}
		}
		return false;
	}
	
	public void removeLast() {
		if(tail != null) {
			DLLNode runner = tail.previous;
			tail = runner;
			tail.next = null;
		}
	}
	
	public void removeFirst() {
		if(head != null) {
			DLLNode runner = head;
			if(runner.next != null) {
				head = runner.next;
			}
		}
	}
	
	public void removeAt(int indexVal) {
		if(indexVal > 0) {
			DLLNode runner = head;
			int count = 0;
			while(runner != null) {
				if(count==indexVal-2) {
					runner.next = runner.next.next;
					break;
				}else {
					runner = runner.next;
				}
				count++;
			}
		}else if(indexVal == 0) {
			removeFirst();
		}
	}
}