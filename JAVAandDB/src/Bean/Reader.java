package Bean;

public class Reader {
	private String name;
	private Integer id;
	private String sex;
	private String Classes;
	private String major;
	public String getClasses() {
		return Classes;
	}
	public Integer getId() {
		return id;
	}
	public String getMajor() {
		return major;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public void setClasses(String classes) {
		Classes = classes;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
