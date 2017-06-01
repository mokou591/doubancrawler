package entity;

public class Celebrity {
	private Integer id;
	private String allName;
	private String gender;
	private String work;
	private String birthplace;
	private String birthdate;
	private String intro;
	private String imdbnum;
	private String coverUrl;

	@Override
	public String toString() {
		return "Celebrity [id=" + id + ", allName=" + allName + ", gender="
				+ gender + ", work=" + work + ", birthplace=" + birthplace
				+ ", birthdate=" + birthdate + ", intro=" + intro
				+ ", imdbnum=" + imdbnum + ", coverUrl=" + coverUrl + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAllName() {
		return allName;
	}

	public void setAllName(String allName) {
		this.allName = allName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getImdbnum() {
		return imdbnum;
	}

	public void setImdbnum(String imdbnum) {
		this.imdbnum = imdbnum;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	
}
