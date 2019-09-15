package br.edu.materdei.tas.core.service;

import br.edu.materdei.tas.core.entity.ProdutoEntity;
import br.edu.materdei.tas.core.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements IBaseService<ProdutoEntity>{
    
    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<ProdutoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ProdutoEntity findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public ProdutoEntity save(ProdutoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
