package mylab.library.entity;
import java.util.ArrayList;
import java.util.List;
public class Library {
	private String name;
	private List<Book> books;

	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}

	// 도서관 이름을 반환하는 메서드
	public String getName() {
		return name;
	}

	//도서를 추가하는 메서드
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}


	//제목으로 도서를 검색하는 메서드입니다. (제목에 검색어가 포함된 첫 번째 도서를 반환, 없으면 null)
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().contains(title)) {
				return book;
			}
		}
		return null;
	}

	// 저자로 도서를 검색하는 메서드 (일치하는 도서를 전부 리스트로 반환)
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(author)) {
				result.add(book);
			}
		}
		return result;
	}

	// ISBN으로 도서를 검색하는 메서드
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	// ISBN으로 도서를 대출하는 메서드
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book == null) {
			return false;
		}
		return book.checkOut();
	}

	// ISBN으로 도서를 반납하는 메서드
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book == null) {
			return false;
		}
		return book.returnBook(); // Book 내부의 반납 로직 실행
	}

	// 대출 가능한 도서 목록을 반환하는 메서드
	public List<Book> getAvailableBooks() {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.isAvailable()) {
				result.add(book);
			}
		}
		return result;
	}

	// 전체 도서 목록을 반환하는 메서드
	public List<Book> getAllBooks() {
		return books;
	}

	// 도서 총 수량을 반환하는 메서드
	public int getTotalBooks() {
		return books.size();
	}

	// 대출 가능한 도서 수량을 반환하는 메서드
	public int getAvailableBooksCount() {
		int availableCount = 0;
		for (Book book : books) {
			if (book.isAvailable()) {
				availableCount++;
			}
		}
		return availableCount;
	}

	// 대출 중인 도서 수량을 반환하는 메서드
	public int getBorrowedBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}
}