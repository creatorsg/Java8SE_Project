package mylab.library.entity;
public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;

	public Book() {
		super();
		this.isAvailable = true;
	}

	public Book(
			String title,
			String author,
			String isbn,
			int publishYear)
	{
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// 대출 처리 (대출 가능하면 false로 바꾸고 true 반환, 이미 대출 중이면 false 반환)
	public boolean checkOut() {
		if (!isAvailable) {
			return false;
		}
		this.isAvailable = false;
		return true;
	}

	// 반납 처리 (대출 중이면 true로 바꾸고 true 반환, 이미 반납된 상태면 false 반환)
	public boolean returnBook() {
		if (isAvailable) {
			return false;
		}
		this.isAvailable = true;
		return true;
	}

	@Override
	public String toString() {
		String status = isAvailable ? "가능" : "대출 중";
		return String.format("책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %s\t대출 가능 여부: %s",
				title, author, isbn, publishYear, status);
	}

}