package com.example.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserDao;
import com.example.service.JwtUserDetailService;
@Controller

public class UserController {
	@Autowired
	private JwtUserDetailService userDetailsService;
	@Autowired
	private JwtAuthenticationController jwtAuthenticationController;
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public @ResponseBody String getEmployees() {
        return "Welcome!";
    }
    @GetMapping("/")
    public String showIndexPage() {
    	return "redirect:/index";
    }
    @GetMapping("/index")
    public String index(Model model) {
    	model.addAttribute("command",new UserDao());
    	return "index";
    }
    @RequestMapping(value = "/updateuser/{id}"  )
    public String showUpdateContactPage(@PathVariable long id,Model model,HttpServletResponse response) {
        model.addAttribute("id", id);
      
       model.addAttribute("command", userDetailsService.findById(id).orElse(null));
    //  response.addHeader("Authorization", jwtAuthenticationController.jwtToken);
      
        return "updateuser";
    }
   
   /* @RequestMapping(value = "/updateuser")
    public String showUpdateContactPage(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
       model.addAttribute("command", userDetailsService.findById(id).orElse(null));
        return "updateuser";
    }*/

    @RequestMapping("/readuser")
    public String showReadContactPage(Model model) {
        model.addAttribute("users", userDetailsService.findAll());
        return "readuser";
    }
}
