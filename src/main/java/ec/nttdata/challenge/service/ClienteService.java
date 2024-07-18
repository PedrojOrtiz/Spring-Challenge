package ec.nttdata.challenge.service;

import ec.nttdata.challenge.dao.IClienteDao;
import ec.nttdata.challenge.domain.Cliente;
import ec.nttdata.challenge.utils.CrudService;
import org.springframework.stereotype.Service;


@Service
public class ClienteService extends CrudService<Cliente, IClienteDao> {


}
