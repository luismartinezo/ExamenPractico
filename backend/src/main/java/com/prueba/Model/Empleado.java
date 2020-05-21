/**
 * 
 */
package com.prueba.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author Luis Martinez
 *
 */
@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dui;

    @Column(name = "Nombre")
    @NotBlank
    private String nombre;

    @Column(name = "Departamento")
    private String departamento;

    @Column(name = "Salario")
    private int salario;

    @Column(name = "EstadoCivil")
    private String estadoCivil;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Nit")
    private String nit;

    @Column(name = "AFP")
    private int afp;

    @Column(name = "ISSS")
    private int isss;

    @Column(name = "RENTA")
    private int renta;

    // public Empleado(Long dui, String nombre, String departamento, int salario,
    // String estadoCivil, String estado, String nit, int afp, int isss,
    // int renta) {
    // this.dui = dui;
    // this.nombre = nombre;
    // this.departamento = departamento;
    // this.salario = salario;
    // this.estadoCivil = estadoCivil;
    // this.estado = estado;
    // this.nit = nit;
    // this.afp = afp;
    // this.isss = isss;
    // this.renta = renta;
    // }

    public Long getDui() {
        return dui;
    }

    public void setDui(Long dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getSalario() {
        return salario;
    }

    // Calculo de descuentos sobre el salario
    public void setSalario(int salario) {
        this.salario = salario;
        this.afp = salario * 8 / 100;
        this.isss = salario * 11 / 100;
        this.renta = salario * 6 / 100;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getAfp() {
        return afp;
    }

    public void setAfp(int afp) {
        this.afp = afp;
    }

    public int getIsss() {
        return isss;
    }

    public void setIsss(int isss) {
        this.isss = isss;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }
}
