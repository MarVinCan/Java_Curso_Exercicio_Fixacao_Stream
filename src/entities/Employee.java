package entities;

public class Employee {
	
	private String name;
	private String eMail;
	private Double salary;
	public Employee(String name, String eMail, Double salary) {
		this.name = name;
		this.eMail = eMail;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eMail=" + eMail + ", salary=" + salary + "]";
	}
	
	

}
