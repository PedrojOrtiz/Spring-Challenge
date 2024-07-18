package ec.nttdata.challenge.dao;

import ec.nttdata.challenge.domain.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface ICuentaDao  extends CrudRepository<Cuenta, String> {

}
