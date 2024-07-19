package ec.nttdata.challenge.dao;

import ec.nttdata.challenge.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, String> {



}
