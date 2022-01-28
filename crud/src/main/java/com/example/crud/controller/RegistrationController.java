package com.example.crud.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud.dto.EmployeeDTO;
import com.example.crud.service.EmployeeService;

@Controller
public class RegistrationController {
	
	 @InitBinder
	    public void initBinder(WebDataBinder dataBinder) {

	        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

	        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	    }
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/registration")
	public String reg(Map<String, Object> model) {
		model.put("employee", new EmployeeDTO());
		return "registratioon";
	}

	@PostMapping("/home")
	public String createEmployee(@Validated @ModelAttribute("employee") EmployeeDTO empDto) {
		employeeService.createOrUpdateEmployee(empDto);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String listOfEmployee(Model model) {
		List<EmployeeDTO> employeeList = employeeService.getAllEmployee();
		model.addAttribute("empList", employeeList);
		return "employeeList";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("id") String id) {
		employeeService.deleteEmployee(Long.parseLong(id));
		return "redirect:/list";
	}

	@GetMapping("/edit")
	public String editEmployee(@RequestParam("id") String id, Map<String, Object> model) {
		EmployeeDTO empDTO = employeeService.editEmployee(Long.parseLong(id));
		model.put("employee", empDTO);
		return "registratioon";
	}

	@PostMapping("/date")
	public void date(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yy") Date date) {
		// ...
	}

}
