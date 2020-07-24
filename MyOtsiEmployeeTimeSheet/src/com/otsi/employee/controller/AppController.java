package com.otsi.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.otsi.employee.model.Address_details;
import com.otsi.employee.model.Employee;
import com.otsi.employee.model.Employee_task;
import com.otsi.employee.model.Project;
import com.otsi.employee.model.Project_timesheet;
import com.otsi.employee.model.Tasks;
import com.otsi.employee.service.EmployeeService;



@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	EmployeeService service;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allemployees";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);

		Map<String, String> status = new HashMap<String, String>();
		status.put("active", "ACTIVE");
		status.put("inactive", "INACTIVE");

		model.addAttribute("address", status);

		return "registration";
	}

	@RequestMapping(value = { "/new" }, method = { RequestMethod.POST })
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			Map<String, String> status = new HashMap<String, String>();
			status.put("active", "ACTIVE");
			status.put("inactive", "INACTIVE");

			model.addAttribute("address", status);
			return "registration";
		}

		service.saveEmployee(employee);

		model.addAttribute("success", "enter address details of employee with generated addressed id :"
				+ employee.getEmp_id() + " of employee :" + employee.getFname());
		Address_details addressdetails = new Address_details();
		model.addAttribute("empid", employee.getEmp_id());
		model.addAttribute("addressdetails", addressdetails);
		return "addressdetails";

	}

	@RequestMapping(value = { "/addreg" }, method = RequestMethod.GET)
	public String newAddress(ModelMap model) {
		Address_details addressdetails = new Address_details();

		model.addAttribute("addressdetails", addressdetails);

		model.addAttribute("edit", false);
		return "addressdetails";
	}

	@RequestMapping(value = { "/addreg" }, method = { RequestMethod.POST })
	public String saveAddress(@Valid @ModelAttribute("addressdetails") Address_details addressdetails,
			BindingResult result, ModelMap model) throws InterruptedException {
		if (result.hasErrors()) {

			model.addAttribute("krish", "please enter correct details");
			model.addAttribute("addressdetails", addressdetails);
			return "addressdetails";
		}

		service.saveAddress(addressdetails);
		model.addAttribute("success", "REGISTERED SUCCESSFULLY");
		return "success";

	}

	@RequestMapping(value = { "/taskdescreg" }, method = RequestMethod.GET)
	public String newTask(ModelMap model) {
		Tasks tasks = new Tasks();
		model.addAttribute("taskdescreg", tasks);
		model.addAttribute("edit", false);

		return "taskdescription";
	}

	@RequestMapping(value = { "/taskdescreg" }, method = { RequestMethod.POST })
	public String saveTasks(@Valid @ModelAttribute("taskdescreg") Tasks tasks, BindingResult result, ModelMap model){
		if (result.hasErrors()) {
			return "taskdescription";
		}

		service.saveTasks(tasks);
		model.addAttribute("success", "REGISTERED SUCCESSFULLY");
		return "success";

	}

	@RequestMapping(value = { "/employeetask" }, method = RequestMethod.GET)
	public String newEmployeetask(ModelMap model) {
		Employee_task employeetask = new Employee_task();
		model.addAttribute("employeetask", employeetask);
		model.addAttribute("edit", false);

		return "employeetask";
	}

	@RequestMapping(value = { "/employeetask" }, method = { RequestMethod.POST })
	public String saveEmployeetask(@Valid  @ModelAttribute("employeetask")Employee_task employeetask, BindingResult result, ModelMap model)
			throws InterruptedException {
		if (result.hasErrors()) {
			return "employeetask";
		}

		service.saveEmployeetask(employeetask);
		model.addAttribute("success", "REGISTERED SUCCESSFULLY");
		return "success";

	}

	@RequestMapping(value = { "/project" }, method = RequestMethod.GET)
	public String newProject(ModelMap model) {
		Project project = new Project();
		model.addAttribute("project", project);
		model.addAttribute("edit", true);

		Map<String, String> status = new HashMap<String, String>();
		status.put("active", "ACTIVE");
		status.put("inactive", "INACTIVE");

		model.addAttribute("address", status);

		return "project";
	}

	@RequestMapping(value = { "/project" }, method = { RequestMethod.POST })
	public String saveProject(@Valid @ModelAttribute("project") Project project, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			Map<String, String> status = new HashMap<String, String>();
			status.put("active", "ACTIVE");
			status.put("inactive", "INACTIVE");
			model.addAttribute("address", status);
			return "project";
		}

		service.saveProject(project);

		model.addAttribute("success",
				"YOUR PROJECT IS SUCCESSFULLY REGISTERED WITH PROJECT ID:" + project.getProject_id());

		return "success";

	}

	@RequestMapping(value = { "/projecttimesheet" }, method = RequestMethod.GET)
	public String newProjecttimesheet(ModelMap model) {

		Project_timesheet projecttimesheet = new Project_timesheet();
		model.addAttribute("projecttimesheet", projecttimesheet);
		model.addAttribute("edit", false);

		return "projecttimesheet";
	}

	@RequestMapping(value = { "/projecttimesheet" }, method = { RequestMethod.POST })
	public String saveProjecttimesheet(@Valid @ModelAttribute("projecttimesheet") Project_timesheet projecttimesheet,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "projecttimesheet";
		}

		service.saveProjecttimesheet(projecttimesheet);

		model.addAttribute("success", "YOUR PROJECT IS SUCCESSFULLY REGISTERED");

		return "success";

	}

	@RequestMapping(value = { "/edit-{emp_id}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String emp_id, ModelMap model) {
		Employee employee = service.findEmployeeByemp_id(Integer.parseInt(emp_id));
		model.addAttribute("employee", employee);

		Map<String, String> status = new HashMap<String, String>();
		status.put("active", "ACTIVE");
		status.put("inactive", "INACTIVE");

		model.addAttribute("address", status);
		model.addAttribute("edit", true);
		return "updateemployee";
	}

	@RequestMapping(value = { "/edit-{emp_id}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			ModelMap model, @PathVariable String emp_id) {

		if (result.hasErrors()) {
			return "updateemployee";
		}

		service.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getFname() + " updated successfully");
		return "success";
	}

	@RequestMapping(value = { "/delete-{emp_id}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String emp_id) {
		service.deleteEmployeeByemp_id(Integer.parseInt(emp_id));
		return "redirect:/list";
	}

}
