package practice;

public class BookDTO {
	private int isbn, price; 
	private String title, author, publisher, desc;
	
	public BookDTO(int isbn, String title, String author, String publisher, int price, String desc) {
		
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();	
		sb.append(isbn+"\t|");
		sb.append(title+"\t|");
		sb.append(author+"\t|");
		sb.append(publisher+"\t|");
		sb.append(price+"\t|");
		sb.append(desc);
		return sb.toString();
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
