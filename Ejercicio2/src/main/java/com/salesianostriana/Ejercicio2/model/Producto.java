package com.salesianostriana.Ejercicio2.model;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //para cada propiedad marcamos la propiedad optional false para que a nivel java no pueda ser nulo,
    //marcamos también a nivel columna/bbdd el nombre de la columna al que hace referencia cad propiedad,
    // y marcamos con nullable= false aquellas que queramos no sean nulas.
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
}
