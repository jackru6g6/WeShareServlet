package teach.spring._03;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class Employee {
	private int empNo;
	private int salary;
	private double weight;
	private String name;
	private Date birthday;
	private Timestamp loginTime;
	private java.util.Date employedDate;
	private Person[] children;
	private List<Pet> pets;
	private Map<String, Pet> petMap;

	public Employee() {
	}

	public Employee(int empNo, int salary, double weight, String name, Date birthday, Timestamp loginTime,
			java.util.Date employedDate, Person[] children, List<Pet> pets, Map<String, Pet> petMap) {
		super();
		this.empNo = empNo;
		this.salary = salary;
		this.weight = weight;
		this.name = name;
		this.birthday = birthday;
		this.loginTime = loginTime;
		this.employedDate = employedDate;
		this.children = children;
		this.pets = pets;
		this.petMap = petMap;
	}

	public int getEmpNo() {
		return empNo;
	}

	public Person[] getChildren() {
		return children;
	}

	public void setChildren(Person[] children) {
		this.children = children;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Map<String, Pet> getPetMap() {
		return petMap;
	}

	public void setPetMap(Map<String, Pet> petMap) {
		this.petMap = petMap;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public java.util.Date getEmployedDate() {
		return employedDate;
	}

	public void setEmployedDate(java.util.Date employedDate) {
		this.employedDate = employedDate;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", salary=" + salary + ", weight=" + weight + ", name=" + name
				+ ", birthday=" + birthday + ", loginTime=" + loginTime + ", employedDate=" + employedDate
				+ ", children=" + Arrays.toString(children) + ", pets=" + pets + ", petMap=" + petMap + "]";
	}

	public void m1() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d = sdf.parse("2016-5-30 12:30:11");
	}

}
