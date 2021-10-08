package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Client;

/**
 * The interface defines the strategy in the client domain. With this we can have multiples
 * implementations of the same interface.
 *
 * @author <a href="https://github.com/sergiotavuencas">sergiotavuencas</a>
 */

public interface ClientService {

    Iterable<Client> listAll();

    Client findById(Long id);

    void insert(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
