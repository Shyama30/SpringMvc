package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.model.Employee;
import com.service.EmployeeService;

@Controller
public class LoginController {
	@Autowired
	EmployeeService employeeservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginUser(HttpServletRequest req) {
		String message = req.getParameter("message");
		req.setAttribute("message", message);
		return "login";
	}

	@RequestMapping(value = "authentication", method = RequestMethod.POST)
	public String authMethod(@ModelAttribute("command") Employee employee, HttpServletRequest req,
			HttpSession session) {
		Employee employee1 = employeeservice.getEmployee(employee.getEmail());
		if(employee1==null){
			return "redirect:login.html?message=" + "You don't have access";
		}
		else if (employee1.getEmail().equals(employee.getEmail())
				&& employee1.getPassword().equals(employee.getPassword()) && employee1.getUsertype().equals("Admin")
				&& session.getAttribute("user1") == null) {

				System.out.println("inside session");
				session.setAttribute("user1", employee1.getEmpName());
				return "redirect:employees.html?message=" + "you have successfully logged in.";
			

		} else if (employee1.getEmail().equals(employee.getEmail())
				&& employee1.getPassword().equals(employee.getPassword())
				&& employee1.getUsertype().equals("Employee") && session.getAttribute("user1") == null) {
				session.setAttribute("user1", employee1.getEmpName());
				return "redirect:index.html?message=" + "you have successfully logged in.";
			}
		return "redirect:login.html?message=" + "You don't have access";
	}

	@RequestMapping(value = "/logout")
	public String logoutMethod(HttpSession session) {
		String message = "You have logged out successfully";
		session.removeAttribute("user1");
		return "redirect:login.html?message=" + message;
	}
	

}
