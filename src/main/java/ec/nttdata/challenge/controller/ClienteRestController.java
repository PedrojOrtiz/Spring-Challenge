package ec.nttdata.challenge.controller;

import ec.nttdata.challenge.domain.Cliente;
import ec.nttdata.challenge.service.ClienteService;
import ec.nttdata.challenge.utils.BindingUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:8081r", "*" })
@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
        Cliente clienteNew;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {
            BindingUtils.handleBindingErrors(result, response);
        }

        try {
            clienteNew = clienteService.save(cliente);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido creado con éxito!");
        response.put("cliente", clienteNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cliente> readAll() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return clienteService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readOne(@PathVariable String id) {

        Cliente cliente;
        Map<String, Object> response = new HashMap<>();

        try {
            cliente = clienteService.read(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null) {
            response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable String id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        Cliente clienteActual;
        Cliente clienteUpdated;

        Map<String, Object> response = new HashMap<>();

        try {
            clienteActual = clienteService.read(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(result.hasErrors()) {
            BindingUtils.handleBindingErrors(result, response);
        }

        if (clienteActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {

            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setEdad(cliente.getEdad());
            clienteActual.setIdentificacion(cliente.getIdentificacion());
            clienteActual.setGenero(cliente.getGenero());
            clienteActual.setDireccion(cliente.getDireccion());
            clienteActual.setTelefono(cliente.getTelefono());

            clienteUpdated = clienteService.save(clienteActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el cliente en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido actualizado con éxito!");
        response.put("cliente", clienteUpdated);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Map<String, Object> response = new HashMap<>();

        try {
            clienteService.read(id);
            clienteService.delete(id);
        } catch (DataAccessException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            response.put("mensaje", "Error al eliminar el cliente de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente eliminado con éxito!");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
