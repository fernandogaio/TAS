package br.edu.materdei.tas.estoque.service;

import br.edu.materdei.tas.estoque.entity.EstoqueEntity;
import br.edu.materdei.tas.estoque.repository.EstoqueRepository;
import br.edu.materdei.tas.core.service.IBaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService implements IBaseService<EstoqueEntity>{
    
    @Autowired
    private EstoqueRepository repository;

    @Override
    public List<EstoqueEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public EstoqueEntity findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public EstoqueEntity save(EstoqueEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
