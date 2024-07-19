package ec.nttdata.challenge.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class Cuenta implements Serializable {

    @Id
    @UuidGenerator
    @Column(name = "cuenta_id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cuenta_cliente_id")
    private Cliente cliente;

    @Column(name = "cuenta_numero", unique = true, length = 10)
    private String numero;

    @Column(name = "cuenta_tipo", length = 10)
    private String tipo;

    @Column(name = "cuenta_saldo", precision = 24, scale = 14)
    private BigDecimal saldo;

    @Column(name = "cuenta_estado", columnDefinition = "boolean DEFAULT true")
    private Boolean estado;

}
