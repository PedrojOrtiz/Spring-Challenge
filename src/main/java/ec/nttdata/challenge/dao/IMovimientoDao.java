package ec.nttdata.challenge.dao;

import ec.nttdata.challenge.domain.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface IMovimientoDao extends CrudRepository<Movimiento, String> {

}
