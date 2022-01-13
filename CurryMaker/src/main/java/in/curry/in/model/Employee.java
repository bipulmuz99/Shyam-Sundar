package in.curry.in.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_curry")
public class Employee {
	@Id
	@Column(name="emp_id_col")
	@GeneratedValue
	private Integer empId;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpDal() {
		return empDal;
	}

	public void setEmpDal(String empDal) {
		this.empDal = empDal;
	}

	public String getEmpMashala() {
		return empMashala;
	}

	public void setEmpMashala(String empMashala) {
		this.empMashala = empMashala;
	}

	public String getEmpPatato() {
		return empPatato;
	}

	public void setEmpPatato(String empPatato) {
		this.empPatato = empPatato;
	}

	public String getEmpSalt() {
		return empSalt;
	}

	public void setEmpSalt(String empSalt) {
		this.empSalt = empSalt;
	}

	public String getEmpWater() {
		return empWater;
	}

	public void setEmpWater(String empWater) {
		this.empWater = empWater;
	}

	@Column(name="emp_dal_col")
	private String empDal;
	
	@Column(name="emp_mashala_col")
	private String empMashala;
	
	@Column(name="emp_patato_col")
	private String empPatato;
	
	@Column(name="emp_salt_col")
	private String empSalt;
	
	@Column(name="emp_water_col")
	private String empWater;
	
}
