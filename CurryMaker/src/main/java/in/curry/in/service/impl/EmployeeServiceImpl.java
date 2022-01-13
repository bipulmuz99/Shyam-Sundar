package in.curry.in.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.curry.in.exception.EmployeeNotFoundException;
import in.curry.in.model.Employee;
import in.curry.in.repo.EmployeeRepository;
import in.curry.in.service.IEmployeeService;

@Service // = @Component + Logics/cal + TxManagement
public class EmployeeServiceImpl
implements IEmployeeService
{

	@Autowired
	private EmployeeRepository repo; //HAS-A

	public Integer saveEmployee(Employee e) {
		//JDK 10# Local Variable Type Inference
		//the best datatype is selected at compile time
		//---calculations--
		e = repo.save(e);

		//PK
		Integer empId = e.getEmpId();

		return empId;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		return list;
	}

	public void deleteEmployee(Integer id) {
		//repo.deleteById(id);
		repo.delete(getOneEmployee(id));
	}

	/*public Optional<Employee> getOneEmployee(Integer id) {
		return repo.findById(id);
	}*/
	public Employee getOneEmployee(Integer id) {
		/*Optional<Employee> opt = repo.findById(id);
		if(opt.isEmpty()) {
			throw new EmployeeNotFoundException("Employee '"+id+"' Not exist");
		} else {
			return opt.get();
		}*/
		return repo.findById(id)
				.orElseThrow(
						()-> new EmployeeNotFoundException(
								"Employee '"+id+"' Not exist")
						);
	}

	public void updateEmployee(Employee e) {
		
		if(repo.existsById(e.getEmpId())) {			
			repo.save(e);
		}
	}
	
	@Override
	public boolean isEmployeeEmailExist(String empMail) {
		/*
		Integer count = repo.getEmployeeEmailCount(empMail);
		boolean isExist = count > 0 ? true:false;
		return isExist;
		*/
		return repo.getEmployeeEmailCount(empMail)>0;
	}
	
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
