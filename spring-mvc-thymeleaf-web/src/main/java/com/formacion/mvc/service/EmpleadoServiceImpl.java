package com.formacion.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.mvc.entity.Empleado;
import com.formacion.mvc.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoRepository repositorio;
	
	@Override
	public List<Empleado> listarEmpleados() {
		return repositorio.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public Empleado obtenerEmpleadoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarEmpleado(Long id) {
		repositorio.deleteById(id);
		
	}

}
