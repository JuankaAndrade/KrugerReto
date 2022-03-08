package com.innovativecorp.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovativecorp.model.Empleado;


@Repository
public interface IEmpleado extends CrudRepository <Empleado, Integer> {

}
