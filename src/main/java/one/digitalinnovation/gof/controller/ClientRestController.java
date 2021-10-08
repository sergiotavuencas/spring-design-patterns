package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This {@link RestController} represents our Facade, because it abstracts all the integration
 * complexity (H2 Database and API of ViaCEP) in one simple and cohesive interface (API REST).
 *
 * @author <a href="https://github.com/sergiotavuencas">sergiotavuencas</a>
 */

@RestController
@RequestMapping("clients")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> listAll() {
        return ResponseEntity.ok(clientService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        clientService.insert(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
