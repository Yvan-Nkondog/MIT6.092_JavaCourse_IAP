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

	// Doubles the array size when nBooks = arraySize.
	void changeBookArraySize(int newSize) {
		if ((this.books == null)) {
			this.books = new Book[newSize];
		} else if (books.length < newSize) {
			Book[] newBooks = new Book[newSize];
			for (int i = 0; i < this.nBooks; i++) {
				newBooks[i] = this.books[i];
			}
			this.books = newBooks;
		}
	}

	// Adds a book to the array. When the array is full, doubles the
	// size of the array, then adds the new book.
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
		if (this.books == null) {
			System.out.println("Sorry, the library located at <<" + this.libraryAddress
					+ ">> is still empty. No book has been added.");
			return;
		}
		for (int i = 0; i < this.nBooks; i++) {
			if (books[i].title == bookTitle) {
				if (!books[i].isBorrowed()) {
					books[i].borrowed();
					System.out.println("The book <<" + books[i].title + 
							">> is borrowed from the library located at <<" 
							+ this.libraryAddress + ">>.");
					break;
				}
				else {
					System.out.println("Sorry, this copy of the book <<"
							+ books[i].title + ">> has already been borrowed"
									+ " from the library located at <<" + this.libraryAddress + ">>.");
				}
			}
		}
	}

	// Prints only the list of available books (books
	// that have not been borrowed). This function does
	// not print the entire list of books in the library.
	void printAvailableBooks() {
		if (this.books == null) {
			System.out.println("[]");
			return;
		}
		String availableBooks = "[";
		for (int i = 0; i < this.nBooks; i++) {
			if (!books[i].isBorrowed()) {
				availableBooks += books[i].title + ", ";
			}
		}
		availableBooks = availableBooks.substring(0, availableBooks.length() - 2);
		availableBooks += "]";
		System.out.println(availableBooks);
	}

	void returnBook(String bookTitle) {
		for (int i = 0; i < this.nBooks; i++) {
			if ((books[i].title == bookTitle) && (books[i].isBorrowed())) {
				this.books[i].returned();
				break;
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
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Set the opening hours.
		String firstLibOpen = "Mon - Fri (08:00AM - 05:00PM PDT).";
		String secondLibOpen = "Mon - Fri (09:00AM - 04:30PM PDT), Sat (09:00 AM - 01:00PM).";

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
		
		// Return the second copy of the book the "The Lords of the Rings".
		// Then print the list of books.
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}

}
