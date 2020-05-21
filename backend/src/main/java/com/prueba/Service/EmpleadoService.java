package com.prueba.Service;

import java.util.List;
import java.util.Optional;

import com.prueba.Model.Empleado;

// import org.springframework.stereotype.Service;

/**
 * @author Luis Martinez
 * @since 05/2020
 * @version 1.0
 */

// @Service
public interface EmpleadoService {

    // Guardar Empleado
    Empleado save(Empleado empleado);

    // Listar Empleado
    List<Empleado> findAll();

    // actualizar empleado
    Empleado update(Empleado empleado);

    // Eliminar Empleado por el id
    String delete(Long id);

    // Verificar la existencia del id
    boolean existeId(Long id);

    // Detalles del empleado por id
    Optional<Empleado> detail(Long id);

}