package com.FeriaVirtual.MaipoGrande.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registro) {
		registro.addViewController("/").setViewName("index");
		registro.addViewController("/login");
		registro.addViewController("/inicio");
		registro.addViewController("/pedido").setViewName("pedido");		
		registro.addViewController("/main-menu").setViewName("main-menu");
		registro.addViewController("/main-menuProductor").setViewName("main-menuProductor");
		registro.addViewController("/main-menuProveedor").setViewName("main-menuProveedor");
		registro.addViewController("/quienesomos").setViewName("quienesomos");
		registro.addViewController("/origen").setViewName("origen");
		registro.addViewController("/productos").setViewName("productos");

		// se agregaron estas que son mas. Se probo y no tiene mayot inferencia que hacer visibles las paginas html. las pantallas de listas y save
		//no es necesario agregar
	}

}
