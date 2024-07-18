package ec.nttdata.challenge.domain;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Persona implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private UUID id;

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
