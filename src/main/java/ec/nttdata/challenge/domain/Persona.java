package ec.nttdata.challenge.domain;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@MappedSuperclass
@Data
public abstract class Persona implements Serializable {
    
    @Id
    @UuidGenerator
    @Column(name = "person_id")
    private String id;

    @Column(name="person_nombre", length = 200)
    private String nombre;

    @Column(name="person_genero", length = 50)
    private String genero;

    @Column(name="person_edad")
    private Integer edad;

    @Column(name="person_identificacion", unique = true, length = 13)
    private String identificacion;

    @Column(name="person_direccion", length = 300)
    private String direccion;

    @Column(name="person_telefono", length = 13)
    private String telefono;

}
