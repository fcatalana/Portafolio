package com.FeriaVirtual.MaipoGrande.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.FeriaVirtual.MaipoGrande.Entidad.Contrato;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.FeriaVirtual.MaipoGrande.service.api.ContratoServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.estadoContratoServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.tipoContratoServiceAPI;

@Controller
//@RestController
//@RequestMapping("/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoServiceAPI contratoServiceAPI;
	
	@Autowired
	private tipoContratoServiceAPI tipocontratoServiceAPI;
	
	@Autowired
	private estadoContratoServiceAPI estadocontratoServiceAPI;
	
	@RequestMapping("/listaContrato")
	public String indexContrato(Model model) {
		model.addAttribute("list", contratoServiceAPI.getAll());
		return "listaContrato";
}
	
	@GetMapping("/deleteContrato/{id}")
	public String deleteContrato(@PathVariable Long id, Model model) {
		contratoServiceAPI.delete(id);
		
		return "redirect:/listaContrato";
	}
	
	@GetMapping("/agregarContrato")
    public String showContratoForm(Contrato contrato, Model model,  Model model1) {
		model.addAttribute("listTipoContrato", tipocontratoServiceAPI.getAll());
		model1.addAttribute("listEstadoContrato", estadocontratoServiceAPI.getAll());
        return "saveContrato";
    }

	
	@PostMapping("/addContrato")
    public String addContrato(@Validated Contrato contrato, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "saveContrato";
        }
        contratoServiceAPI.save(contrato);
        return "redirect:/listaContrato";
    }
	
	@GetMapping("/saveContrato/{id}")
	public String showSaveContrato(@PathVariable("id") Long id , Model model,  Model model1, Model model2) {
		if(id !=null && id != 0) {
			model.addAttribute("contrato", contratoServiceAPI.get(id));			
			model1.addAttribute("listTipoContrato", tipocontratoServiceAPI.getAll());
			model2.addAttribute("listEstadoContrato", estadocontratoServiceAPI.getAll());
		}else {
			model.addAttribute("contrato", new Contrato());
			model1.addAttribute("listTipoContrato", tipocontratoServiceAPI.getAll());
			model2.addAttribute("listEstadoContrato", estadocontratoServiceAPI.getAll());
		}
		return "actualizaContrato";	
	}
	
	@PostMapping("/updContrato")
    public String updContrato(@Validated Contrato contrato, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "actualizaContrato";
        }
        
        contratoServiceAPI.save(contrato);
        return "redirect:/listaContrato";
    }

	/*
	@PostMapping("/saveContrato")
	public String saveContrato(Contrato contrato, Model model) {
		contratoServiceAPI.save(contrato);
		return "redirect:/listaContrato";
	}*/
	
	
	

}
