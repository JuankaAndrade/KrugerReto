package com.innovativecorp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovativecorp.interfaceService.IempleadoService;
import com.innovativecorp.interfaces.IEmpleado;
import com.innovativecorp.model.Empleado;

@Service
public class EmpleadoService implements IempleadoService {

	@Autowired
	private IEmpleado data;
	
	public List<Empleado> listar() {
		return (List<Empleado>)data.findAll();
	}

	
	public Optional<Empleado> listarId(int id) {
		return data.findById(id);
	}

	
	public int save(Empleado e) {
		int res = 0;
		Empleado empleado = data.save(e);
		if(!empleado.equals(null)) {
			res = 1;
		}
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);
	}

}
