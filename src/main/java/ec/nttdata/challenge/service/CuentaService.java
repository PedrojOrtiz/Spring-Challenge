package ec.nttdata.challenge.service;

import ec.nttdata.challenge.dao.ICuentaDao;
import ec.nttdata.challenge.domain.Cuenta;
import ec.nttdata.challenge.utils.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService extends CrudService<Cuenta, ICuentaDao> {

    public List<Cuenta> getAllCuentasWithClients() {
        return dao.getAllCuentasConCliente();
    }

    public Cuenta getCuentaById(String id) {
        return dao.getCuentaConCliente(id);
    }


}
