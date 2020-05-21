package com.prueba.Repository;

// import java.util.List;

import com.prueba.Model.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luis Martinez
 * @since 05/2020
 * @version 1.0
 */

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @SuppressWarnings("unchecked")
    Empleado save(Empleado empleado);

}