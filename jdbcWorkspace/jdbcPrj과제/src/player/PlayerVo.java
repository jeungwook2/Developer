package player;

public class PlayerVo {

	private String no;
	private String position;
	private String name;
	private String age;
	private String enrollDate;
	private String contractPeriod;
	private String weeklySalary;
	private String salarySum;
	
	@Override
	public String toString() {
		return "PlayerVo [no=" + no + ", postion=" + position + ", name=" + name + ", age=" + age + ", enrollDate="
				+ enrollDate + ", contractPeriod=" + contractPeriod + ", weeklySalary=" + weeklySalary + "]";
	}
	
	public PlayerVo() {}

	public PlayerVo(String salarySum) {
		super();
		this.salarySum = salarySum;
	}
	
	public PlayerVo(String no, String postion, String name, String age, String enrollDate, String contractPeriod,
			String weeklySalary) {
		super();
		this.no = no;
		this.position = postion;
		this.name = name;
		this.age = age;
		this.enrollDate = enrollDate;
		this.contractPeriod = contractPeriod;
		this.weeklySalary = weeklySalary;
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPostion() {
		return position;
	}

	public void setPostion(String postion) {
		this.position = postion;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(String weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	public String getSalarySum() {
		return salarySum;
	}

	public void setSalarySum(String salarySum) {
		this.salarySum = salarySum;
	}
	
}
