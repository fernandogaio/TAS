package br.edu.materdei.tas.venda.service;

import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.venda.entity.ClienteEntity;
import br.edu.materdei.tas.venda.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IBaseService<ClienteEntity> {
    
    @Autowired
    private ClienteRepository repository;

    @Override
    public List<ClienteEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ClienteEntity findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public ClienteEntity save(ClienteEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
