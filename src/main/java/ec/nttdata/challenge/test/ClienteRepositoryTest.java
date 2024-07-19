package ec.nttdata.challenge.test;

import ec.nttdata.challenge.dao.IClienteDao;
import ec.nttdata.challenge.domain.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.InvocationTargetException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {

    @Autowired
    private IClienteDao clienteDao;

    @Test
    public void testSaveCliente() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        Cliente cliente = new Cliente();
        cliente.setNombre("Elon Musk");
        cliente.setGenero("Male");
        cliente.setEdad(40);
        cliente.setIdentificacion("12345678910");
        cliente.setDireccion("123 Main St");
        cliente.setTelefono("1234567890");
        cliente.setClienteId("elon123");
        cliente.setContrasena("password");
        cliente.setEstado(true);

        Cliente savedCliente = clienteDao.save(cliente);

        // Then
        assertEquals("Elon Musk", savedCliente.getNombre());
    }

}
