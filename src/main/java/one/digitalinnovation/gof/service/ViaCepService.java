package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client HTTP, created via OpenFeign, for the consumption of API with ViaCEP
 *
 * @see <a href="https://github.com/sergiotavuencas">ViaCEP</a>
 *
 * @author <a href="https://viacep.com.br/ws">sergiotavuencas</a>
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Address consultCep(@PathVariable("cep") String cep);
}
