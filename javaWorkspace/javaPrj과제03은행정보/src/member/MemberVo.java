package member;

public class MemberVo {

	private String no;
	private String id;
	private String pwd;
	private String name;
	private String birth;
	private String registNum;
	
	public String getRegistNum() {
		return registNum;
	}
	public void setRegistNum(String registNum) {
		this.registNum = registNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public MemberVo(String no, String id, String pwd, String name, String birth, String registNum) {
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.registNum = registNum;
	}
	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", birth=" + birth
				+ "]";
	}

}
