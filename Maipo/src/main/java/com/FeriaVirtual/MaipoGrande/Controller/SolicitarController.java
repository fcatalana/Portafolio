package com.FeriaVirtual.MaipoGrande.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.FeriaVirtual.MaipoGrande.Repository.ProductosRepository;
import com.FeriaVirtual.MaipoGrande.service.Impl.SendMailService;
import com.FeriaVirtual.MaipoGrande.service.api.ProductoServiceAPI;
import com.FeriaVirtual.MaipoGrande.Repository.PedidosSolicitadosRepository;
import com.FeriaVirtual.MaipoGrande.Entidad.Producto;
import com.FeriaVirtual.MaipoGrande.Entidad.ProductoParaSolicitar;
import com.FeriaVirtual.MaipoGrande.Entidad.ProductoSolicitado;
import com.FeriaVirtual.MaipoGrande.Entidad.Pedido;
import com.FeriaVirtual.MaipoGrande.Repository.PedidosRepository;

@Controller
@RequestMapping(path = "/solicitar")
public class SolicitarController {

	 @Autowired
	    private ProductosRepository productosRepository;
	    @Autowired
	    private PedidosRepository pedidosRepository;
	    @Autowired
	    private PedidosSolicitadosRepository pedidosSolicitadosRepository;
	    
	    @Autowired
		private ProductoServiceAPI productoServiceAPI; 
	    
	    @Autowired
	    private SendMailService sendMailService;
	    
	    
	    @PostMapping(value = "/quitarPedido/{indice}")
	    public String quitarDelCarrito(@PathVariable int indice, HttpServletRequest request) {
	        ArrayList<ProductoParaSolicitar> carrito = this.obtenerCarrito(request);
	        if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
	            carrito.remove(indice);
	            this.guardarCarrito(carrito, request);
	        }
	        return "redirect:/solicitar/";
	    }

	    private void limpiarCarrito(HttpServletRequest request) {
	        this.guardarCarrito(new ArrayList<>(), request);
	    }

	    @GetMapping(value = "/limpiarPedido")
	    public String cancelarPedido(HttpServletRequest request, RedirectAttributes redirectAttrs) {
	        this.limpiarCarrito(request);
	        redirectAttrs
	                .addFlashAttribute("mensaje", "Pedido cancelada")
	                .addFlashAttribute("clase", "info");
	        return "redirect:/solicitar/";
	    }

	    @PostMapping(value = "/terminarPedido")
	    public String terminarPedido(HttpServletRequest request, RedirectAttributes redirectAttrs, @RequestParam("from") String from, 
	    		@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("body") String body)
	    {
	        ArrayList<ProductoParaSolicitar> carrito = this.obtenerCarrito(request);
	        // Si no hay carrito o está vacío, regresamos inmediatamente
	        if (carrito == null || carrito.size() <= 0) {
	            return "redirect:/solicitar/";
	        }
	        Pedido v = pedidosRepository.save(new Pedido());
	        // Recorrer el carrito
	        for (ProductoParaSolicitar productoParaSolicitar : carrito) {
	            // Obtener el producto fresco desde la base de datos
	            Producto p = productosRepository.findById(productoParaSolicitar.getId_producto()).orElse(null);
	            if (p == null) continue; // Si es nulo o no existe, ignoramos el siguiente código con continue
	            // Le restamos existencia
	            p.restarExistencia(productoParaSolicitar.getCantidad());
	            // Lo guardamos con la existencia ya restada
	            productosRepository.save(p);
	            // Creamos un nuevo producto que será el que se guarda junto con la venta
	            ProductoSolicitado productoSolicitado = new ProductoSolicitado(productoParaSolicitar.getCantidad(), productoParaSolicitar.getNombre_producto(), productoParaSolicitar.getCodigo(), v);
	            // Y lo guardamos
	            pedidosSolicitadosRepository.save(productoSolicitado);
	        }
	        //enviamos la notificación
	        sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Solicitud de Pedido", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Su pedido ha sido ingresado al Sistema exitosamente, Ahora, se realizara la publicación de este. Le mantendremos informado su avance."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
	        sendMailService.sendMail(from="maipo.grande123@gmail.com", to="f.catalana@duocuc.cl", subject="Solicitud de Pedido", body="Maipo Grande, le informa lo siguiente:"+"\n"+"\n"+"Se ha ingresado una solicitud de Pedido al Sistema, revise su bandeja de Pedidos para publicar dicha petición."+"\n"+"\n"+"\n"+"Atte."+"\n"+"Maipo Grande");
	        // Al final limpiamos el carrito
	        this.limpiarCarrito(request);
	        // e indicamos una venta exitosa
	        redirectAttrs
	                .addFlashAttribute("mensaje", "Pedido realizado correctamente")
	                .addFlashAttribute("clase", "success");
	        return "redirect:/solicitar/";
	    }

	    @GetMapping(value = "/")
	    public String interfazSolicitar(Model model, Model model1, HttpServletRequest request) {
	        model.addAttribute("producto", new Producto());
	        model1.addAttribute("listProducto", productoServiceAPI.getAll());
	        //float total = 0;
	        //ArrayList<ProductoParaSolicitar> carrito = this.obtenerCarrito(request);
	        //for (ProductoParaSolicitar p: carrito) total += p.getTotal();
	        //model.addAttribute("total", total);
	        return "solicitar";
	    }

	    private ArrayList<ProductoParaSolicitar> obtenerCarrito(HttpServletRequest request) {
	        ArrayList<ProductoParaSolicitar> carrito = (ArrayList<ProductoParaSolicitar>) request.getSession().getAttribute("carrito");
	        if (carrito == null) {
	            carrito = new ArrayList<>();
	        }
	        return carrito;
	    }

	    private void guardarCarrito(ArrayList<ProductoParaSolicitar> carrito, HttpServletRequest request) {
	        request.getSession().setAttribute("carrito", carrito);
	    }

	    @PostMapping(value = "/agregarPedido")
	    public String agregarAlCarrito(@ModelAttribute Producto producto, HttpServletRequest request, RedirectAttributes redirectAttrs) {
	        ArrayList<ProductoParaSolicitar> carrito = this.obtenerCarrito(request);
	        Producto productoBuscadoPorCodigo = productosRepository.findFirstByCodigo(producto.getCodigo());
	        if (productoBuscadoPorCodigo == null) {
	            redirectAttrs
	                    .addFlashAttribute("mensaje", "El producto con el código " + producto.getCodigo() + " no existe")
	                    .addFlashAttribute("clase", "warning");
	            return "redirect:/vender/";
	        }
	        if (productoBuscadoPorCodigo.sinExistencia()) {
	            redirectAttrs
	                    .addFlashAttribute("mensaje", "El producto está agotado")
	                    .addFlashAttribute("clase", "warning");
	            return "redirect:/solicitar/";
	        }
	        boolean encontrado = false;
	        for (ProductoParaSolicitar productoParaSolicitarActual : carrito) {
	            if (productoParaSolicitarActual.getCodigo().equals(productoBuscadoPorCodigo.getCodigo())) {
	                productoParaSolicitarActual.aumentarCantidad();
	                encontrado = true;
	                break;
	            }
	        }
	        if (!encontrado) {
	            carrito.add(new ProductoParaSolicitar(productoBuscadoPorCodigo.getNombre_producto(), 
	            		productoBuscadoPorCodigo.getValor(), productoBuscadoPorCodigo.getExistencia(), productoBuscadoPorCodigo.getCodigo(),productoBuscadoPorCodigo.getId_producto(), 1f));
	        }
	        this.guardarCarrito(carrito, request);
	        return "redirect:/solicitar/";
	    }
}
