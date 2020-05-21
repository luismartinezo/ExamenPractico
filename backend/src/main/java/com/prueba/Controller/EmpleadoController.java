package com.prueba.Controller;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.Model.Empleado;
import com.prueba.Service.EmpleadoService;
// import com.prueba.Util.queryResult;
import com.prueba.Util.restResponse;
// import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Luis Martinez
 * @since 05/2020
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    protected EmpleadoService empleadoService;

    protected ObjectMapper mapper;

    // Nuevo Empleado
    @PostMapping("/nuevo")
    public restResponse save(@RequestBody String empleadoJson) throws JsonMappingException, JsonProcessingException {
        this.mapper = new ObjectMapper();
        Empleado empleado = this.mapper.readValue(empleadoJson, Empleado.class);
        if (!this.validate(empleado)) {
            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
        }
        this.empleadoService.save(empleado);
        return new restResponse(HttpStatus.OK.value(), "Empleado guardado con exito");
    }

    // Actualizar Empleado
    @PostMapping("/actualizar")
    public restResponse update(@RequestBody String empleadoJson) throws JsonMappingException, JsonProcessingException {
        this.mapper = new ObjectMapper();
        Empleado empleado = this.mapper.readValue(empleadoJson, Empleado.class);
        if (!empleadoService.existeId(empleado.getDui())) {
            return new restResponse(HttpStatus.NOT_FOUND.value(), "No existe el empleado en la base de datos");
        }

        if (!this.validate(empleado)) {
            return new restResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Campo obligatorio sin diligenciar");
        }
        this.empleadoService.update(empleado);
        return new restResponse(HttpStatus.OK.value(), "Empleado actualizo con exito");
    }

    // Listar todos los empleados
    @GetMapping("/lista")
    public List<Empleado> getEmpleados() {
        return this.empleadoService.findAll();

    }

    // Eliminar Empleado
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.PATCH)
    public String deleteEmpleado(@PathVariable Long id) {
        return empleadoService.delete(id);
    }

    // Detalles Empleado
    @RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
    public Optional<Empleado> detail(@PathVariable Long id) {
        return empleadoService.detail(id);
    }

    // Validaciones
    private boolean validate(Empleado empleado) {
        boolean isValid = true;
        if (empleado.getNombre() == null || empleado.getNombre() == "") {
            isValid = false;
        }
        if (empleado.getNit() == null || empleado.getNit() == "") {
            isValid = false;
        }
        // if (empleado.getId() == null) {
        // isValid = false;
        // }
        return isValid;
    }
}