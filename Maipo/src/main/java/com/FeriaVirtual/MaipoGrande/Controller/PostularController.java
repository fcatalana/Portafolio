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

import com.FeriaVirtual.MaipoGrande.Entidad.PedidoProductor;
import com.FeriaVirtual.MaipoGrande.Entidad.SubastaTransporte;
import com.FeriaVirtual.MaipoGrande.Repository.PedidoProductorRepository;
import com.FeriaVirtual.MaipoGrande.Repository.PedidosRepository;
import com.FeriaVirtual.MaipoGrande.Repository.SubastaTransporteRepository;
import com.FeriaVirtual.MaipoGrande.Entidad.Pedido;
import com.FeriaVirtual.MaipoGrande.service.Impl.SendMailService;
import com.FeriaVirtual.MaipoGrande.service.api.CalidadFrutaServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.PedidoProductorServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.PedidoServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.ProductorServiceAPI;
import com.FeriaVirtual.MaipoGrande.service.api.TransporteServiceAPI;

@Controller
public class PostularController {
	
	@Autowired
	private PedidoServiceAPI pedidoServiceAPI; 
	
	@Autowired
	private PedidoProductorServiceAPI pedidoProductorServiceAPI; 
	
	@Autowired
	private CalidadFrutaServiceAPI calidadFrutaServiceAPI;	
	
	@Autowired
	private ProductorServiceAPI productorServiceAPI;
	
	@Autowired
	private TransporteServiceAPI transporteServiceAPI;
	
	@Autowired
    PedidosRepository pedidosRepository;
	
	@Autowired
    PedidoProductorRepository pedidoProductorRepository;
	
	@Autowired
    SubastaTransporteRepository subastaTransporteRepository;
	
	@Autowired
    private SendMailService sendMailService;
	
	 @GetMapping("/verPostulacion/{id}")
		public String showSave(@PathVariable("id") Long id , Model model, Model model1, Model model2, Model model3, 
				Model model4, PedidoProductor pedidoProductor) {
			if(id !=null && id != 0) {				
				model.addAttribute("pedido", pedidoServiceAPI.get(id));
				model1.addAttribute("listCalidadFruta", calidadFrutaServiceAPI.getAll());				
				model3.addAttribute("listProductor", productorServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());								
			}else {
				model.addAttribute("pedido", new Pedido());
				model1.addAttribute("listCalidadFruta", calidadFrutaServiceAPI.getAll());				
				model3.addAttribute("listProductor", productorServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());
			}
			return "postular";	
		}
	 //postulación productor dice pedidoProductor y no pedido pro el envio del object
	 @PostMapping("/addPostulacion")
	    public String addPostulacion(@Validated PedidoProductor pedidoProductor, BindingResult result, Model model, @RequestParam("from") String from, 
	    		@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body) {
	       // if (result.hasErrors()) {
	       //    return "postular";
	       // }
		 sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Postulación Pedido", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su Postulación de Pedido se ha ingresado exitosamente. Si resulta adjudicado, nos contactaremos con usted."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
		 pedidoProductorRepository.save(pedidoProductor);
		//enviamos la notificación	        	        
	        return "redirect:/";
	    }
	 
	 @GetMapping(value = "/subastas")
	    public String mostrarPedidos(Model model, Model model1) {	        
	        model.addAttribute("pedidos", pedidosRepository.findAll());
	        model1.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
	        return "ver_adjudicacion";
	    }
	 
	 @GetMapping("/verSubasta/{id}")
		public String showSave(@PathVariable("id") Long id , Model model, Model model1, Model model2) {
			if(id !=null && id != 0) {
				model.addAttribute("pedido", pedidoServiceAPI.get(id));				
				model1.addAttribute("pedidos", pedidosRepository.findAll());
				model2.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
			}else {
				model.addAttribute("pedido", new Pedido());				
				model1.addAttribute("pedidos", pedidosRepository.findAll());
				model2.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
			}
			return "subastaPedido";	
		}
	 
	 @PostMapping("/updSubasta")
	    public String updCliente(@Validated Pedido pedido, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
	        if (result.hasErrors()) {
	            return "subastaPedido";
	        }
	        
	        pedidoServiceAPI.save(pedido);
	        redirectAttrs
				.addFlashAttribute("mensaje", "Subasta publicada correctamente")
				.addFlashAttribute("clase", "success");
	        return "redirect:/subastas";
	    }
	 
	 @GetMapping(value = "/subastar")
	    public String mostrarPostulaciones(Model model, Model model1) {
	        model.addAttribute("pedidos", pedidosRepository.findAll());
	        model1.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
	        return "ver_subastas";
	    }
	 
	 
	 @GetMapping("/postularSubasta/{id}")
		public String showSubasta(@PathVariable("id") Long id , Model model, Model model1, Model model2, Model model3, 
				Model model4, Model model5, SubastaTransporte subastaTransporte) {
			if(id !=null && id != 0) {				
				model.addAttribute("pedido", pedidoProductorServiceAPI.get(id));		
				model1.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
				model2.addAttribute("listPedido", pedidoServiceAPI.getAll());
				model3.addAttribute("listTransporte", transporteServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());				
				model5.addAttribute("listPedidoProductor", pedidoProductorServiceAPI.getAll());
			}else {
				model.addAttribute("pedido", new Pedido());
				model1.addAttribute("pedidoProductor", pedidoProductorRepository.findAll());
				model2.addAttribute("listPedido", pedidoServiceAPI.getAll());
				model3.addAttribute("listTransporte", transporteServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());
				model5.addAttribute("listPedidoProductor", pedidoProductorServiceAPI.getAll());
			}
			return "subastar";	
		}
	 
	 @PostMapping("/addSubasta")
	    public String addSubasta(@Validated SubastaTransporte subastaTransporte, BindingResult result, Model model, @RequestParam("from") String from, 
	    		@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body) {
	       // if (result.hasErrors()) {
	       //    return "postular";
	       // }
		 sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Postulación Subasta", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su Postulación de Subasta se ha ingresado exitosamente. Si resulta adjudicado, nos contactaremos con usted."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
		 subastaTransporteRepository.save(subastaTransporte);
	        return "redirect:/";
	    }
	 	 
	 @GetMapping(value = "/entregar")
	    public String entregar(Model model, Model model1) {
	        model.addAttribute("pedidos", pedidosRepository.findAll());
	        model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
	        return "ver_entregas";
	    }
	 
	 
	 @GetMapping("/entregarPedido/{id}")
		public String showEntrega(@PathVariable("id") Long id , Model model, Model model1, Model model2, Model model3, 
				Model model4, Model model5) {
			if(id !=null && id != 0) {				
				model.addAttribute("pedido", pedidoServiceAPI.get(id));		
				model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
				model2.addAttribute("listPedido", pedidoServiceAPI.getAll());
				model3.addAttribute("listTransporte", transporteServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());				
				model5.addAttribute("listPedidoProductor", pedidoProductorServiceAPI.getAll());
			}else {
				model.addAttribute("pedido", new Pedido());
				model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
				model2.addAttribute("listPedido", pedidoServiceAPI.getAll());
				model3.addAttribute("listTransporte", transporteServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());
				model5.addAttribute("listPedidoProductor", pedidoProductorServiceAPI.getAll());
			}
			return "entregar";	
		}
	 
	 @PostMapping("/updPedidoEntregado")
		public String updPedidoEntregado(@Validated Pedido pedido, BindingResult result, Model model, RedirectAttributes redirectAttrs, @RequestParam("from") String from, 
	    		@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body) {
			if (result.hasErrors()) {
				return "entregar";
			}
			
			sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Pedido Entregado", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su Pedido a sido entregado, favor indique la recepción de los productos para continuar con el proceso."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");						
			
			pedidoServiceAPI.save(pedido);
			redirectAttrs
				.addFlashAttribute("mensaje", "Pedido Entregado a Cliente")
				.addFlashAttribute("clase", "success");
			return "redirect:/entregar";
		}
	 
	 
	 @GetMapping(value = "/recepcionar")
	    public String recepcionar(Model model, Model model1) {
	        model.addAttribute("pedidos", pedidosRepository.findAll());
	        model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
	        return "ver_recepcion";
	    }
	 
	 
	 @GetMapping("/recepcionarPedido/{id}")
		public String showRecepcion(@PathVariable("id") Long id , Model model, Model model1, Model model2, Model model3, 
				Model model4, Model model5) {
			if(id !=null && id != 0) {				
				model.addAttribute("pedido", pedidoServiceAPI.get(id));		
				model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
				model2.addAttribute("listPedido", pedidoServiceAPI.getAll());
				model3.addAttribute("listTransporte", transporteServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());				
				model5.addAttribute("listPedidoProductor", pedidoProductorServiceAPI.getAll());
			}else {
				model.addAttribute("pedido", new Pedido());
				model1.addAttribute("subastaTransporte", subastaTransporteRepository.findAll());
				model2.addAttribute("listPedido", pedidoServiceAPI.getAll());
				model3.addAttribute("listTransporte", transporteServiceAPI.getAll());
				model4.addAttribute("pedidos", pedidosRepository.findAll());
				model5.addAttribute("listPedidoProductor", pedidoProductorServiceAPI.getAll());
			}
			return "recepcionar";	
		}
	 
	 @PostMapping("/updPedidoEntrega")
		public String updPedidoEntrega(@Validated Pedido pedido, BindingResult result, Model model, RedirectAttributes redirectAttrs, @RequestParam("from") String from, 
	    		@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body) {
			if (result.hasErrors()) {
				return "recepcionar";
			}
			
			sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Recepción Pedido", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Un Pedido a sido entregado y recepcionado exitosamente. Revise el detalle de la venta en la sección de informes."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
			
			sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Venta Generada", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Con la aceptación de los productos, se ha generado los cobros asociados. Se le enviara un resumen de estos a su correo, ademas se esperara en un plazo de 15 días el abono del total. Favor cumpla los plazos de pagos para no incurrir en multas."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
			
			sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Recepción Pedido", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Un pedido ha sido recepcionado exitosamente por uno de nuestros clientes. Dentro de un plazo de 20 días se le enviara resumen de ganancias y recibira el abono de su pago."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
			
			sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Recepción Pedido", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Sus productos han sido recepcionados exitosamente por uno de nuestros clientes. Dentro de un plazo de 20 días se le enviara resumen de ganancias y recibira el abono de su pago."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
			
			pedidoServiceAPI.save(pedido);
			redirectAttrs
				.addFlashAttribute("mensaje", "Pedido recepcionado correctamente")
				.addFlashAttribute("clase", "success");
			return "redirect:/recepcionar";
		}
}