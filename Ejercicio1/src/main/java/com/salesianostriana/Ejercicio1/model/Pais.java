package com.salesianostriana.Ejercicio1.model;

import javax.persistence.*;

@Entity
//Especificamos la tabla a la que haremos referencia, presente en schema.sql en resources
@Table(name="country")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    // Metadatos de persistencia: no sustituye una validación de entrada Java.

    @Column( name = "name", nullable = false)
    //La anotación Column genera una restricción no nulo en la base de datos que afectara en este caso
    //a la columna nombre, además name= "name" se encarga de mapear esta propiedad con la columna name de
    //la base de datos.
    private String nombre;

    public Pais() {}
    public Pais(String name) { this.nombre = name; }
    public Long getId() { return id; }
    public String getName() { return nombre; }
}
