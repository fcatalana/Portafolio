package com.FeriaVirtual.MaipoGrande.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.FeriaVirtual.MaipoGrande.Entidad.Pedido;
import com.FeriaVirtual.MaipoGrande.Repository.PedidosRepository;
import com.FeriaVirtual.MaipoGrande.Repository.SubastaTransporteRepository;
import com.FeriaVirtual.MaipoGrande.Repository.VentasRepository;
import com.FeriaVirtual.MaipoGrande.service.api.PedidoServiceAPI;

@Controller
//@RequestMapping(path = "/ventas")
public class VentasController {    

    @Autowired
    SubastaTransporteRepository subastaTransporteRepository;
    
    @Autowired
    PedidosRepository pedidosRepository;
    
    @Autowired
	private PedidoServiceAPI pedidoServiceAPI; 
    
    @GetMapping(value = "/ventas")
    public String mostrarVentas(Model model, Model model1) {
    	 model.addAttribute("pedidos", pedidosRepository.findAll());
	     model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
        return "ver_ventas";
    }
    
    @GetMapping("/ventaPedido/{id}")
	public String showRecepcion(@PathVariable("id") Long id , Model model, Model model1, Model model2, Model model3, 
			Model model4, Model model5) {
		if(id !=null && id != 0) {				
			model.addAttribute("pedido", pedidoServiceAPI.get(id));		
			model1.addAttribute("pedidos", pedidosRepository.findAll());
		    model2.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
		}else {
			model.addAttribute("pedido", new Pedido());
			model1.addAttribute("pedidos", pedidosRepository.findAll());
		    model2.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
		}
		return "ventas";	
	}
}
