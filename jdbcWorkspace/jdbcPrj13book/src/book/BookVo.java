package book;

public class BookVo {

	private String no;
	private String title;
	private String genre;
	private String author;
	private String price;
	private String rentalYn;
	private String publicationDate;
	private String modifyDate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRentalYn() {
		return rentalYn;
	}
	public void setRentalYn(String rentalYn) {
		this.rentalYn = rentalYn;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public BookVo(String no, String title, String genre, String author, String price, String rentalYn,
			String publicationDate, String modifyDate) {
		super();
		this.no = no;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.price = price;
		this.rentalYn = rentalYn;
		this.publicationDate = publicationDate;
		this.modifyDate = modifyDate;
	}
	
	public BookVo() {}
	
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", genre=" + genre + ", author=" + author + ", price=" + price
				+ ", rentalYn=" + rentalYn + ", publicationDate=" + publicationDate + ", modifyDate=" + modifyDate
				+ "]";
	}
	
	
}
