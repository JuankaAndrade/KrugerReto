package com.innovativecorp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innovativecorp.interfaceService.IempleadoService;
import com.innovativecorp.model.Empleado;
import com.innovativecorp.model.Employee;
import com.innovativecorp.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

	
	private List<Employee> employees = createList();
	
	@Autowired
	private static IempleadoService service;
	//private static List<Employee> employees = crearLista();

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		return employees;
	}
	
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") int id) {
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId()== id) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
	}
	
	//Metodos controlador
	@GetMapping("/listar")
	public String Listar(Model model) {
		List<Empleado> empleados = service.listar();
		model.addAttribute("empleados", empleados);
		return "index";
	}
	
	@GetMapping("/new")
	public String Agregar(@Validated Model model, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		model.addAttribute("empleado", new Empleado());
		return "form";
	}
	
	@PostMapping("/save")
	public String Save(@Validated Empleado e, Model model) {
		service.save(e);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Empleado> empleado = service.listarId(id);
		model.addAttribute("empleado",empleado);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	
	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setName("Juan Carlos");
		emp1.setApellidos("Andrade Chavez");
		emp1.setCedula("1716587116");
		emp1.setCorreo("juanka.andrade@gmail.com");
		emp1.setDesignation("Admin");
		emp1.setBorn("17/01/1987");
		emp1.setHouse("Cipreses 3");
		emp1.setMovile("0995652832");
		emp1.setVaccinated(false);
		emp1.setEmpId(1);
		emp1.setSalary(3000);
		Employee emp2 = new Employee();
		emp2.setName("Pedro Alberto");
		emp2.setApellidos("Arana Izurieta");
		emp2.setDesignation("user");
		emp2.setCorreo("pedrito@gmail.com");
		emp2.setEmpId(2);
		emp2.setSalary(3000);
		emp2.setBorn("01/01/1985");
		emp2.setHouse("Cipreses 2");
		emp2.setMovile("0987654320");
		emp2.setVaccinated(false);
		emp2.setSalary(5000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}
	
	private static List<Employee> crearLista(){
		List<Employee> tempEmployees = new ArrayList<Employee>();
		List<Empleado> empleados = service.listar();
		
		for (int i=0;i<empleados.size();i++) {
			Employee emp1 = new Employee();
			emp1.setEmpId(empleados.get(i).getId());
			emp1.setName(empleados.get(i).getNombres());
			emp1.setCedula(empleados.get(i).getCedula());
			emp1.setApellidos(empleados.get(i).getApellidos());
			emp1.setCorreo(empleados.get(i).getCorreo());
			emp1.setApellidos(empleados.get(i).getApellidos());
			emp1.setDesignation("empleado");
			emp1.setSalary(3000);
			tempEmployees.add(emp1);
		}
		
		return tempEmployees;
	}	

}
