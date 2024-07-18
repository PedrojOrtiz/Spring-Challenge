package ec.nttdata.challenge.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends Persona {
    
    @Column(name = "cliente_id", unique = true, length = 50)
    private String clienteId;

    @Column(name = "cliente_contrasena", length = 50)
    private String contrasena;

    @Column(name = "cliente_estado", columnDefinition = "boolean DEFAULT true")
    private Boolean estado;

}
