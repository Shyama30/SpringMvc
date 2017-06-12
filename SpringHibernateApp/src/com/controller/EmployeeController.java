package com.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.model.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String welcome() {
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(@ModelAttribute("command")Employee employee) {

		return "addEmployee";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String newEmployee(@ModelAttribute("command")Employee employee) {

		return "registration";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") Employee employee) {
		employeeService.addEmployee(employee);
		String message="record added successfully";
		return new ModelAndView("redirect:employees.html?message="+message);

	}

	@RequestMapping(value = "/employees")
	public ModelAndView listEmployees(HttpServletRequest req, HttpServletResponse res) {
		String msg=req.getParameter("message");
		req.setAttribute("message", msg);
	    Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",employeeService.listEmployeess());
		return new ModelAndView("employeesList", model);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command") Employee employee) {
		employeeService.deleteEmployee(employee);
		String message="record deleted successfully";
		return new ModelAndView("redirect:employees.html?message="+message);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("cmd")Employee employee, HttpServletRequest req) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", employeeService.getEmployee(employee.getEmail()));
		return new ModelAndView("addEmployee", model);




	}
}
