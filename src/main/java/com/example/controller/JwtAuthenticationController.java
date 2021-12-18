package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.example.config.JwtTokenUtil;
import com.example.model.JwtRequest;
import com.example.model.JwtResponse;
import com.example.model.UserDao;
import com.example.model.UserDto;
import com.example.service.JwtUserDetailService;




@Controller

public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	public String jwtToken;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailService userDetailsService;

	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	
	public   String createAuthenticationToken(@ModelAttribute("jwt") JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		JwtResponse jwtResponse= new JwtResponse(token);
		   jwtToken=jwtResponse.getToken();
		   
		  
		 jwtToken ="Bearer " +jwtResponse.getToken();

		
		 System.out.println(jwtToken);
	
	return "redirect:/readuser";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("adduser") UserDto user) throws Exception {
		userDetailsService.save(user);
		
		return "redirect:/login";
		
	}
	  @RequestMapping(value = "/delete/{id}")
	    public  String deleteContact(@PathVariable long id) {
  
	        userDetailsService.deleteById(id);
	 
	        return "redirect:/readuser";
	    }
	  @RequestMapping(value = "/login")
	    public  String login(Model model) {
	       model.addAttribute("command",new JwtRequest());
	    
	        return "login";
	    }
	 
	
		
	
	    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	    public  String updateContact(@PathVariable long id, @ModelAttribute("adduser") UserDto userDto,HttpServletResponse response) throws ClientProtocolException, IOException {
	        userDetailsService.updateContact(id, userDto);
	       // response.addHeader("Authorization", jwtToken);
	      
	        return "redirect:/readuser";
	    }
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	
	
}
