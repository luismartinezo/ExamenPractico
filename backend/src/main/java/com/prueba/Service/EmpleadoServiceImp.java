package com.prueba.Service;

import java.util.List;
import java.util.Optional;

// import com.prueba.Model.Department;
import com.prueba.Model.Empleado;
import com.prueba.Repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Luis Martinez
 * @since 05/2020
 * @version 1.0
 */

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    protected EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado) {
        // Metodo Autogenerado para guardar empleado
        return this.empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> findAll() {
        // Metodo Autogenerado para listar empleado
        return this.empleadoRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        // Metodo Autogenerado para eliminar empleado
        if (empleadoRepository.findById(id).isPresent()) {
            empleadoRepository.deleteById(id);
            return "Empleado eliminado correctamente.";
        }
        return "Error! El Empleado no existe";

    }

    @Override
    public boolean existeId(Long id) {
        // Metodo Autogenerado para verificar si exite el id
        return this.empleadoRepository.existsById(id);
    }

    @Override
    public Empleado update(Empleado empleado) {
        // Metodo Autogenerado para actualizar empleado
        return this.empleadoRepository.save(empleado);
    }

    @Override
    public Optional<Empleado> detail(Long id) {
        // Metodo Autogenerado para mostrar detalles del empleado por medio del id
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado;
    }

}