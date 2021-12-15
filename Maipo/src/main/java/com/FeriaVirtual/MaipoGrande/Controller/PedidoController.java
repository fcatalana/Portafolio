package com.FeriaVirtual.MaipoGrande.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FeriaVirtual.MaipoGrande.Entidad.Pedido;
import com.FeriaVirtual.MaipoGrande.Repository.PedidoProductorRepository;
import com.FeriaVirtual.MaipoGrande.Repository.PedidosRepository;
import com.FeriaVirtual.MaipoGrande.Repository.SubastaTransporteRepository;
import com.FeriaVirtual.MaipoGrande.service.Impl.SendMailService;
import com.FeriaVirtual.MaipoGrande.service.api.EstadoPedidoServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.PedidoServiceAPI;

@Controller
public class PedidoController {

	@Autowired
	PedidosRepository pedidosRepository;

	@Autowired
	private EstadoPedidoServiceAPI estadoPedidoServiceAPI;

	@Autowired
	private PedidoServiceAPI pedidoServiceAPI;

	@Autowired
	PedidoProductorRepository pedidoProductorRepository;
	
	@Autowired
    SubastaTransporteRepository subastaTransporteRepository;
	
	@Autowired
    private SendMailService sendMailService;
	
	@GetMapping(value = "/pedidos")
	public String mostrarPedidos(Model model) {
		model.addAttribute("pedidos", pedidosRepository.findAll());		
		return "ver_pedidos";
	}

	// asi debe quedar detalles
	@GetMapping(value = "/postulaciones")
	public String mostrarPostulaciones(Model model) {
		model.addAttribute("pedidos", pedidosRepository.findAll());
		return "ver_postulaciones";
	}

	// llegar detalles
	@GetMapping("/verPedido/{id}")
	public String showSave(@PathVariable("id") Long id, Model model, Model model1, Model model2) {
		if (id != null && id != 0) {
			model.addAttribute("pedido", pedidoServiceAPI.get(id));
			model1.addAttribute("listEstadoPedido", estadoPedidoServiceAPI.getAll());
			model2.addAttribute("pedidos", pedidosRepository.findAll());			
		} else {
			model.addAttribute("pedido", new Pedido());
			model1.addAttribute("listEstadoPedido", estadoPedidoServiceAPI.getAll());
			model2.addAttribute("pedidos", pedidosRepository.findAll());			
		}
		return "actualizaPedido";
	}

	@PostMapping("/updPedido")
	public String updCliente(@Validated Pedido pedido, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return "actualizaPedido";
		}

		pedidoServiceAPI.save(pedido);
		redirectAttrs
			.addFlashAttribute("mensaje", "Pedido publicado correctamente")
			.addFlashAttribute("clase", "success");
		return "redirect:/pedidos";
	}

	@GetMapping(value = "/adjudicacion")
	public String mostrar(Model model, Model model1) {
		model.addAttribute("pedidos", pedidosRepository.findAll());
		model1.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
		return "adjudicar";
	}

	@GetMapping("/adjudicaProductor/{id}")
	public String showAdjudica(@PathVariable("id") Long id, Model model, Model model1, Model model2, Model model3) {
		if (id != null && id != 0) {
			model.addAttribute("pedido", pedidoServiceAPI.get(id));
			model1.addAttribute("pedidos", pedidosRepository.findAll());
			model2.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
			model3.addAttribute("listEstadoPedido", estadoPedidoServiceAPI.getAll());
		} else {
			model.addAttribute("pedido", new Pedido());
			model1.addAttribute("pedidos", pedidosRepository.findAll());
			model2.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
			model3.addAttribute("listEstadoPedido", estadoPedidoServiceAPI.getAll());
		}		
		return "adjudicaPedido";
	}
	
	@PostMapping("/updAdjudicacion")
	public String updAdjudica(@Validated Pedido pedido, BindingResult result, Model model, RedirectAttributes redirectAttrs, @RequestParam("from") String from, 
    		@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body) {
		//if (result.hasErrors()) {
			//return "actualizaPedido";
		//}
		sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Pedido Adjudicado", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su Pedido ya cuenta con un productor para el abastecimiento de los productos solicitados. Queda esperar la subasta del Transporte, para realizar el envío de los productos. Nos comunicaremos con usted a la brevedad."
				+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
		
		sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Postulación Adjudicada", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su Postulación de Pedido ha sido seleccionada para uno de nuestros clientes. Queda esperar la subasta del Transporte, para realizar el retiro y envío de los productos. Nos comunicaremos con usted a la brevedad."
		+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
		pedidoServiceAPI.save(pedido);
		redirectAttrs
			.addFlashAttribute("mensaje", "Pedido adjudicado a Roberto Ugalde, se le ha notificado por correo.")
			.addFlashAttribute("clase", "success");
		return "redirect:/adjudicacion";
	}

	@GetMapping("/adjudicacionTransporte")
	public String showAdjudicaTransporte(Model model1, Model model2) {
		model1.addAttribute("pedidos", pedidosRepository.findAll());
		model2.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
		return "adjudicaTransporte";
	}
	
	@GetMapping("/adjudicaTransporte/{id}")
	public String showadjudicaTransporte(@PathVariable("id") Long id, Model model, Model model1, Model model2) {
		if (id != null && id != 0) {
			model.addAttribute("pedido", pedidoServiceAPI.get(id));
			model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
			model2.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
		} else {
			model.addAttribute("pedido", new Pedido());
			model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
			model2.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
		}
		return "adjudicaSubasta";
	}
	
	@PostMapping("/updAdjudicaSubasta")
	public String updAdjudicaSubasta(@Validated Pedido pedido, BindingResult result, Model model, RedirectAttributes redirectAttrs, @RequestParam("from") String from, 
    		@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body) {
		//if (result.hasErrors()) {
			//return "actualizaPedido";
		//}
		sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Transporte Adjudicado", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su Pedido ya cuenta con Transporte para el retiro y entrega de los productos solicitados. En un plazo de 30 días habiles recibira su pedido."
				+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
		
		sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Retiro Productos", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Sus productos ya cuentan con transporte para el retiro y envío al cliente. El transportista se contactara con usted para el retiro de los productos."
				+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
				
		sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Subasta Adjudicada", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su Postulación de Subasta ha sido seleccionada para una de nuestras entregas. Contactese con el productor, quien ya sabe de esta resolución."
		+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
		pedidoServiceAPI.save(pedido);
		redirectAttrs
			.addFlashAttribute("mensaje", "Pedido adjudicado a Transportes Centro, se le ha notificado por correo.")
			.addFlashAttribute("clase", "success");
		return "redirect:/adjudicacion";
	}
}
