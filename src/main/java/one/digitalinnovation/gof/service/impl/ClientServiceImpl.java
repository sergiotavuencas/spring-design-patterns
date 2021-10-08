package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Address;
import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.repository.AddressRepository;
import one.digitalinnovation.gof.repository.ClientRepository;
import one.digitalinnovation.gof.service.ClientService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Implementation of the Strategy {@link ClientService}, which can be
 * injected via Spring using {@link Autowired}, with this
 * the class will be treated as a Singleton.
 *
 * @author <a href="https://github.com/sergiotavuencas">sergiotavuencas</a>
 */

@Service
public class ClientServiceImpl implements ClientService {

    // Singleton: injects the components of Spring with @Autowired.
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implements the methods defined in the interface.
    // Facade: Abstract the integrations with subsystems, providing a simple interface

    @Override
    public Iterable<Client> listAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> clientSearched = clientRepository.findById(id);
        return clientSearched.get();
    }

    @Override
    public void insert(Client client) {
        fillClientAndSave(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientBd = clientRepository.findById(id);

        if (clientBd.isPresent()) {
            fillClientAndSave(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void fillClientAndSave(Client client) {
        String cep = client.getAddress().getCep();

        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultCep(cep);

            addressRepository.save(newAddress);

            return newAddress;
        });

        client.setAddress(address);
        clientRepository.save(client);
    }
}
