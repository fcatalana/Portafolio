package com.FeriaVirtual.MaipoGrande.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FeriaVirtual.MaipoGrande.Entidad.Usuario;
//import com.FeriaVirtual.MaipoGrande.service.api.RolServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.UsuarioServiceAPI;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceAPI usuarioServiceAPI;
	
	//@Autowired
	//private RolServiceAPI rolServiceAPI;

	@RequestMapping("/listaUsuario")
	public String indexUsuario(Model model) {
		model.addAttribute("list", usuarioServiceAPI.getAll());
		return "listaUsuario";
}
	
	@GetMapping("/deleteUsuario/{id}")
	public String deleteUsuario(@PathVariable Long id, Model model) {
		usuarioServiceAPI.delete(id);
		
		return "redirect:/listaUsuario";
	}
	
	@GetMapping("/agregarUsuario")
    public String showUsuarioForm(Usuario usuario, Model model) {
		//model.addAttribute("listRol", rolServiceAPI.getAll());
        return "saveUsuario";
    }
	
	@PostMapping("/addUsuario")
    public String addUsuario(@Validated Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "saveUsuario";
        }
        
        usuarioServiceAPI.save(usuario);
        return "redirect:/listaUsuario";
    }
	
	@GetMapping("/saveUsuario/{id}")
	public String showSaveUsuario(@PathVariable("id") Long id , Model model, Model model1) {
		if(id !=null && id != 0) {
			model.addAttribute("usuario", usuarioServiceAPI.get(id));
			//model1.addAttribute("listRol", rolServiceAPI.getAll());
		}else {
			model.addAttribute("usuario", new Usuario());			
			//model1.addAttribute("listRol", rolServiceAPI.getAll());
		}
		return "actualizaUsuario";	
	}
	
	@PostMapping("/updUsuario")
    public String updUsuario(@Validated Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "actualizaUsuario";
        }
        
        usuarioServiceAPI.save(usuario);
        return "redirect:/listaUsuario";
    }
	
}
