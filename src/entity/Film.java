package entity;

public class Film {
	private Integer id;
	private String originalName;
	private String chsName;
	private String director;
	private String writer;
	private String actor;
	private String region;
	private String language;
	private Integer year;
	private Integer length;
	private String imdbnum;
	private String posterUrl;
	private String intro;
	private String genre;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getChsName() {
		return chsName;
	}
	public void setChsName(String chsName) {
		this.chsName = chsName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getImdbnum() {
		return imdbnum;
	}
	public void setImdbnum(String imdbnum) {
		this.imdbnum = imdbnum;
	}
	public String getPosterUrl() {
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
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
		return "Film [id=" + id + ", originalName=" + originalName
				+ ", chsName=" + chsName + ", director=" + director
				+ ", writer=" + writer + ", actor=" + actor + ", region="
				+ region + ", language=" + language + ", year=" + year
				+ ", length=" + length + ", imdbnum=" + imdbnum
				+ ", posterUrl=" + posterUrl + ", intro=" + intro + ", genre="
				+ genre + ", status=" + status + "]";
	}

}
