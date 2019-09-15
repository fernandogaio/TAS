package br.edu.materdei.tas.core.service;

import br.edu.materdei.tas.core.entity.GrupoEntity;
import br.edu.materdei.tas.core.repository.GrupoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService implements IBaseService<GrupoEntity> {
    
    @Autowired
    private GrupoRepository repository;

    @Override
    public List<GrupoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public GrupoEntity findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public GrupoEntity save(GrupoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
