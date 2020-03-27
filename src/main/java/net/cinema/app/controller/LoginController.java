package net.cinema.app.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.GenericPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
//	@GetMapping(value = "/index")
//	public String mostrarPrincipalAdmin(Authentication authentication) {
//		System.out.println("Username : " + authentication.getName());
//		for (GrantedAuthority rol: authentication.getAuthorities()) {
//			System.out.println("Rol: " + rol.getAuthority());
//		}
//		return "admin";
//	}
	
	@GetMapping(value = "/index")
	public String mostrarPrincipal(HttpSession session, Principal principal) {
		//GenericPrincipal generic =(GenericPrincipal) principal;
		//System.out.println("Roles: " + generic.getRoles());
		//System.out.print("el usuario tiene rol: " + generic.hasRole("editor")) ;
		String usuario =principal.getName();
		session.setAttribute("usuario", usuario);
		return "admin";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/formLogin";
	}
}
