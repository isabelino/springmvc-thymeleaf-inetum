package com.formacion.mvc.service;

import java.util.List;

import com.formacion.mvc.entity.Empleado;

public interface EmpleadoService {

	//metodo para listar todos los empleados
	public List<Empleado> listarEmpleados();
	//metodo para guardar empleado
	public Empleado guardarEmpleado(Empleado empleado);
	//metodo para obtener empleado por id
	public Empleado obtenerEmpleadoPorId(Long id);
	//metodo para eliminar empleado
	public void eliminarEmpleado(Long id);
	
	
}
