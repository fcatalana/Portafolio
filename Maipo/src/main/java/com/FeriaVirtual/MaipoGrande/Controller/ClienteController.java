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

import com.FeriaVirtual.MaipoGrande.Entidad.Cliente;
import com.FeriaVirtual.MaipoGrande.service.api.ClienteServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.tipoClienteServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.ContratoServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.PaisServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.UsuarioServiceAPI;

@Controller
public class ClienteController {

	@Autowired
	private ClienteServiceAPI clienteServiceAPI; 
	
	@Autowired
	private tipoClienteServiceAPI tipoClienteServiceAPI; 
	
	@Autowired
	private ContratoServiceAPI contratoServiceAPI; 
	
	@Autowired
	private PaisServiceAPI paisServiceAPI; 
	
	@Autowired
	private UsuarioServiceAPI usuarioServiceAPI; 
	
	@RequestMapping("/listaCliente")
	public String index(Model model) {
		model.addAttribute("list", clienteServiceAPI.getAll());
		return "listaCliente";
	}
	
	@GetMapping("/agregarCliente")
    public String showClienteForm(Cliente cliente, Model model, Model model1, Model model2, Model model3) {
		//List<tipoCliente> listTipoCliente = tipoClienteServiceAPI.
		model.addAttribute("listTipoCliente", tipoClienteServiceAPI.getAll());
		model1.addAttribute("listContrato", contratoServiceAPI.getAll());
		model2.addAttribute("listPais", paisServiceAPI.getAll());
		model3.addAttribute("listUsuario", usuarioServiceAPI.getAll());
        return "saveCliente";
    }
	
	@PostMapping("/addCliente")
    public String addCliente(@Validated Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "saveCliente";
        }
        
        clienteServiceAPI.save(cliente);
        return "redirect:/listaCliente";
    }
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		clienteServiceAPI.delete(id);
		
		return "redirect:/listaCliente";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id , Model model, Model model1, Model model2, Model model3, Model model4) {
		if(id !=null && id != 0) {
			model.addAttribute("cliente", clienteServiceAPI.get(id));
			model1.addAttribute("listTipoCliente", tipoClienteServiceAPI.getAll());
			model2.addAttribute("listContrato", contratoServiceAPI.getAll());
			model3.addAttribute("listPais", paisServiceAPI.getAll());
			model4.addAttribute("listUsuario", usuarioServiceAPI.getAll());
		}else {
			model.addAttribute("cliente", new Cliente());
			model1.addAttribute("listTipoCliente", tipoClienteServiceAPI.getAll());
			model2.addAttribute("listContrato", contratoServiceAPI.getAll());
			model3.addAttribute("listPais", paisServiceAPI.getAll());
			model4.addAttribute("listUsuario", usuarioServiceAPI.getAll());
		}
		return "actualizaCliente";	
	}
	
	@PostMapping("/updCliente")
    public String updCliente(@Validated Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "actualizaCliente";
        }
        
        clienteServiceAPI.save(cliente);
        return "redirect:/listaCliente";
    }
	
	/*
	@PostMapping("/save")
	public String save(Cliente cliente, Model model) {
		clienteServiceAPI.save(cliente);
		return "redirect:/listaCliente";
	}*/
	
}

