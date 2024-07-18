package ec.nttdata.challenge.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Cuenta implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "cuenta_id")
    private UUID id;

    @NotNull(message = "Cuenta: cliente no puede estar vacio")
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
