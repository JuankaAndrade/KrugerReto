package com.innovativecorp.interfaceService;

import java.util.List;
import java.util.Optional;

import com.innovativecorp.model.Empleado;

public interface IempleadoService {
	public List<Empleado> listar();
	public Optional<Empleado>listarId(int id);
	public int save(Empleado e);
	public void delete(int id);
}
