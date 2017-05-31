package entity;

public class Book {
	private Integer id;
	private String chsName;
	private String originalName;
	private String coverUrl;
	private String author;
	private String press;
	private String translator;
	private String year;
	private String page;
	private String price;
	private String isbn;
	private String intro;
	private String catalog;
	private String genre;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChsName() {
		return chsName;
	}
	public void setChsName(String chsName) {
		this.chsName = chsName;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", chsName=" + chsName + ", originalName="
				+ originalName + ", coverUrl=" + coverUrl + ", author="
				+ author + ", press=" + press + ", translator=" + translator
				+ ", year=" + year + ", page=" + page + ", price=" + price
				+ ", isbn=" + isbn + ", intro=" + intro + ", catalog="
				+ catalog + ", genre=" + genre + ", status=" + status + "]";
	}
	
	
}
