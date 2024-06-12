package gestionclientesgimnasio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Cliente implements Comparable<Cliente>, Serializable {

    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private String apellidos;

    public Cliente(String nombre, String dni, String fechaNacimiento, String apellidos) {
        this.nombre = nombre;
        this.dni = dni;
        DateTimeFormatter formatoFechas
                = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatoFechas);
        this.apellidos = apellidos;
    }

    int edad() {
        return (int) getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);
    }

    @Override
    public boolean equals(Object ob) {
        return getDni().equals(((Cliente) ob).getDni());
    }

    @Override
    public int compareTo(Cliente otro) {
        return getDni().compareTo(otro.getDni());
    }

    @Override
    public String toString() {
        return "DNI: " + getDni() + " Nombre: " + getNombre() + " Edad: " + edad() + "\n";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
