package ec.nttdata.challenge.dao;

import ec.nttdata.challenge.domain.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICuentaDao  extends CrudRepository<Cuenta, String> {

    @Query("SELECT DISTINCT c " +
            "FROM Cuenta c " +
            "JOIN FETCH c.cliente cli")
    List<Cuenta> getAllCuentasConCliente();

    @Query("SELECT DISTINCT c " +
            "FROM Cuenta c " +
            "JOIN FETCH c.cliente cli " +
            "WHERE c.id = :id")
    Cuenta getCuentaConCliente(String id);

    @Query("SELECT DISTINCT c " +
            "FROM Cuenta c " +
            "JOIN FETCH c.cliente cli " +
            "WHERE c.numero = :numero")
    Cuenta getCuentaPorNumero(String numero);

}
