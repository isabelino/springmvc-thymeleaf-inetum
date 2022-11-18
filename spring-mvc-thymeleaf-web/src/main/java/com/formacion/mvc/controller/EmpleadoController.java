package com.formacion.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacion.mvc.entity.Empleado;
import com.formacion.mvc.service.EmpleadoService;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService servicio;
	
	@GetMapping("empleados")
	public String index(Model modelo) {
		modelo.addAttribute("empleados",servicio.listarEmpleados() );
		return "empleado";
	}
	
	@GetMapping("empleados/nuevo")
	public String newEmpl(Model modelo) {
		Empleado empleado = new Empleado();
		modelo.addAttribute("empleado", empleado);
		return "nuevo_empleado";
	}
	
	@PostMapping("/empleado")
	public String saveEmpl(@ModelAttribute("empleado") Empleado empleado) {
		servicio.guardarEmpleado(empleado);	
		return "redirect:/empleados";
	}
	
	@GetMapping("/empleado/editar/{id}")
	public String editEmpl(@PathVariable Long id, Model modelo) {
		Empleado empleadoEdit= servicio.obtenerEmpleadoPorId(id);
		modelo.addAttribute("empleado", empleadoEdit);
		return "editar_empleado";
	}
	
	@PostMapping("/empleado/edit/{id}")
	public String saveEmpl(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado) {
		empleado.setId(id);
		servicio.guardarEmpleado(empleado);	
		return "redirect:/empleados";
	}
	
	@GetMapping("/empleado/eliminar/{id}")
	public String deleteEmple(@PathVariable Long id) {
		servicio.eliminarEmpleado(id);
		return "redirect:/empleados";
	}
	
	@PostMapping("/empleado/eliminar/{id}")
	public String deleteEmple2(@PathVariable Long id) {
		servicio.eliminarEmpleado(id);
		return "redirect:/empleados";
	}
	

}
