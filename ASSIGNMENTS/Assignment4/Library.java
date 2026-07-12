package Chap4;

//Assignment 4
//Modeling Book and Libraries– class Book {} – class Library{} 
//Books can be – Borrowed – Returned 
//Library – Keeps track of books – Hint: use Book[] 

public class Library {

	// Add the missing implementation to this class
	String libraryAddress;
	String openingHours = "Undefined";
	Book[] books;
	int nBooks = 0;

	public Library(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	void changeBookArraySize(int newSize) {
		if ((this.books == null)) {
			this.books = new Book[newSize];
		} else if (books.length < newSize) {
			Book[] newBooks = new Book[newSize];
			for (int i = 0; i < books.length; i++) {
				newBooks[i] = this.books[i];
			}
			this.books = newBooks;
		}
	}

	void addBook(Book book) {
		if (this.books == null) {
			changeBookArraySize(1);
		} else if (this.nBooks == books.length) {
			changeBookArraySize(2 * books.length);
		}
		this.books[this.nBooks] = book;
		this.nBooks++;
	}

	void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	void printOpeningHours() {
		System.out.println(this.openingHours);
	}

	void printAddress() {
		System.out.println(this.libraryAddress);
	}

	void borrowBook(String bookTitle) {
		if (books == null) {
			return;
		}
		for (int i = 0; i < books.length; i++) {
			if (books[i].title == bookTitle) {
				books[i].borrowed();
			}
		}
	}

	void printAvailableBooks() {
		if (this.books == null) {
			System.out.println("[]");
			return;
		}
		System.out.print("[");
		for (int i = 0; i < books.length; i++) {
			if ((i != books.length - 1) && !(books[i].isBorrowed())) {
				System.out.print(books[i].title + ", ");
			}
		}
		if (!books[books.length - 1].isBorrowed()) {
			System.out.println(books[books.length - 1].title + "]\n");
		}
		else {
			System.out.println("]\n");
		}
	}

	void returnBook(String bookTitle) {
		for (int i = 0; i < books.length; i++) {
			if (books[i].title == bookTitle) {
				this.books[i].returned();
			}
		}
	}

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Set the opening hours.
		String firstLibOpen = "Mon - Fri (08:00AM - 05:00PM PDT).";
		String secondLibOpen = "Mon - Fri (08:00AM - 05:00PM PDT), Sat (09:00 AM - 01:00PM).";

		firstLibrary.setOpeningHours(firstLibOpen);
		secondLibrary.setOpeningHours(secondLibOpen);

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		firstLibrary.printOpeningHours();
		secondLibrary.printOpeningHours();
		System.out.println();

		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}

}
