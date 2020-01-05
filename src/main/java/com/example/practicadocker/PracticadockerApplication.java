package com.example.practicadocker;

import com.example.practicadocker.Entidad.Usuario;
import com.example.practicadocker.Repositorio.UsuarioRepository;
import com.example.practicadocker.Servicio.SeguridadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PracticadockerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PracticadockerApplication.class, args);
		ApplicationContext applicationContext = SpringApplication.run(PracticadockerApplication.class, args);

		String[] lista = ((ConfigurableApplicationContext) applicationContext).getBeanDefinitionNames();
		System.out.println("====== Beans Registrados =====");
		for(String bean : lista){
			System.out.println(""+bean);
		}
		System.out.println("====== FIN Beans Registrados =====");

		SeguridadServices seguridadServices = (SeguridadServices) applicationContext.getBean("seguridadServices");
		seguridadServices.crearUsuarioAdmin();
		seguridadServices.crearUsuarioUser();
		//seguridadServices.crearFormularioTest();
	}

}
