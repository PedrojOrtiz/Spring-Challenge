package ec.nttdata.challenge.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class Movimiento implements Serializable {

    @Id
    @UuidGenerator
    @Column(name = "movimiento_id")
    private String id;

    @NotNull(message = "Movimiento: cuenta no puede estar vacia")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "movimiento_cuenta_id")
	private Cuenta cuenta;

    @Column(name = "movimiento_fecha")
    private LocalDate fecha;

    @Column(name = "movimiento_tipo", length = 10)
    private String tipo;

    @Column(name = "movimiento_saldo_posterior", precision = 24, scale = 14)
    private BigDecimal saldoPosterior;
    
}
