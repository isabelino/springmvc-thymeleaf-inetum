package com.formacion.mvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formacion.mvc.entity.Empleado;
import com.formacion.mvc.service.EmpleadoService;

@Controller
public class HolaController {
	
	@Autowired
	private EmpleadoService servicio;
	
	
	@GetMapping("empleados")
	public String index(Model modelo) {
		modelo.addAttribute("empleados",servicio.listarEmpleados() );
		return "empleado";
	}
	
	@GetMapping("hola")
	public String hola(Model modelo) {
		String valor = "Hola como vamos, desde controlador";
		String valor2 = "Esto mola, desde controlador";
		String valor3[]={"tomates","zanahorias","cebollas","pepinillo"};
		
		Empleado objEmp = new Empleado(1,"Pepe","Mejia","pm@email.com",654545);
		Empleado objEmp2 = new Empleado(2,"Carlos","Lopez","cl@email.com",478781);
		Empleado objEmp3 = new Empleado(3,"Maria","Perez","mp@email.com",996454);
		Empleado objEmp4 = new Empleado(4,"Luis","Arrua","la@email.com",621211);
		
		ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
		
		listaEmpleado.add(objEmp);
		listaEmpleado.add(objEmp2);
		listaEmpleado.add(objEmp3);
		listaEmpleado.add(objEmp4);
		
		modelo.addAttribute("key", valor);
		modelo.addAttribute("key2",valor2);
		modelo.addAttribute("key3",valor3);
		modelo.addAttribute("empleado",objEmp);
		modelo.addAttribute("lista",listaEmpleado);
		return "index";
	}
	


}
