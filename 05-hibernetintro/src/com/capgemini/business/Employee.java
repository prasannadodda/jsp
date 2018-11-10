package com.capgemini.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
	@Id
	@Column(name = "emp_id")
	private int emp_Id;
	@Column(name = "emp_name")
	private String emp_Name;
	@Column(name = "emp_sal")
	private double basic_salary;
	@Column(name = "emp_gender")
	private char emp_Gender;
	@Column(name = "emp_grade")
	private char emp_Grade;
  
	
	public int getEmp_Id() {

		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public double getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}

	public char getEmp_Gender() {
		return emp_Gender;
	}

	public void setEmp_Gender(char emp_Gender) {
		this.emp_Gender = emp_Gender;
	}

	public char getEmp_Grade() {
		return emp_Grade;
	}

	public void setEmp_Grade(char emp_Grade) {
		this.emp_Grade = emp_Grade;
	}
@Override
public String toString() {
	return "Employee [emp_Id=" + emp_Id + ", emp_Name=" + emp_Name
			+ ", basic_salary=" + basic_salary + ", emp_Gender=" + emp_Gender
			+ ", emp_Grade=" + emp_Grade + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + emp_Id;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (emp_Id != other.emp_Id)
		return false;
	return true;
}


}
