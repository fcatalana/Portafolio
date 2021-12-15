package com.FeriaVirtual.MaipoGrande.Controller;

//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {		
	
	//****************
	//Este fue agregada para el index
	@RequestMapping("/")
	public String mainPage() {
		return "/index";
	}

	//se cambia de post a get, agregando los demas roles
	@PostMapping("/inicio")
	public String login(User user, @PathVariable("username") String usuario) {
		
		String url="";
		String rol=user.getAuthorities().toString();
				
		if(rol.contains("ROLE_ADMINISTRADOR")) {
			url = "/index";			
		}else if(rol.contains("PRODUCTOR")) {		
			url="/index";
		}else if(rol.contains("CLIENTE_INTERNO")) {
			url="/index";			
		}else if(rol.contains("CLIENTE_EXTERNO")) {
			url="/index";		
		}else if(rol.contains("TRANSPORTISTA")) {
			url="/index";			
		}else if(rol.contains("COMERCIANTE")) {
			url="/index";					
		}return url;		 
	}
}


