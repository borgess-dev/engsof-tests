package api.engsof.shop.services;

import api.engsof.shop.entities.Cliente;
import api.engsof.shop.exceptions.NullParameterException;
import api.engsof.shop.exceptions.StringMustHaveContent;
import api.engsof.shop.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente cliente){

        if(cliente.getNome() == null){
            throw new NullParameterException("O campo \"Nome\" não pode ter valor null.");
        }

        if(cliente.getTelefone() == null){
            throw new NullParameterException("O campo \"Telefone\" não pode ter valor null.");
        }

        if(cliente.getNome().isEmpty()){
            throw new StringMustHaveContent("O Nome é obrigatório!");
        }

        if(cliente.getTelefone().isEmpty()){
            throw new StringMustHaveContent("O Telefone é obrigatório");
        }

        return this.clienteRepository.save(cliente);
    }
}
