package com.salesianostriana.Ejercicio2.model;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // optional/nullable describen el contrato ORM/SQL, no validación de entrada.
    // precio es double: su ausencia no se representa con null, sino con su valor por defecto.
    @Basic(optional = false)
    @Column(name = "name",nullable = false)
    private String nombre;

    @Basic(optional = false)
    @Column(name = "price",nullable = false)
    private double precio;

    //En estos dos últimos casos agregamos la definición de columna para que casen con el tipo
    //de datos que se pedía en el ejercicio, tipo TEXT.
    @Column(name = "image", columnDefinition="TEXT")
    private String imagen;

    @Column(name = "description", columnDefinition="TEXT")
    private String descripcion;

    public Producto() {}
    public Producto(String name, double price, String image, String description) {
        this.nombre = name; this.precio = price; this.imagen = image; this.descripcion = description;
    }
    public Long getId() { return id; }
    public String getName() { return nombre; }
    public double getPrice() { return precio; }
    public String getImage() { return imagen; }
    public String getDescription() { return descripcion; }
}
