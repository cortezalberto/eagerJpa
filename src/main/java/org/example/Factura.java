package org.example;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "detalles")
@Builder
@Entity
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;
    private String cliente;
    // por defecto me trae una carga TEMPRANA, ME TRAE TODO EAGER
  //  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // Ahora NO QUIERO TRAER LOS DETALLES


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)

    @JoinColumn(name = "fk_factura")

    @Builder.Default
    private List<DetalleFactura> detalles = new ArrayList<>();

    // Constructores, getters y setters

    public void addDetalleFactura(DetalleFactura detalle) {
        detalles.add(detalle);
    }

    public void removeDetalleFactura(DetalleFactura detalle) {
        detalles.remove(detalle);
    }
}

