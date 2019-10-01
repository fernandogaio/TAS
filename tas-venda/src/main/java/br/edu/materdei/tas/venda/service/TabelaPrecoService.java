package br.edu.materdei.tas.venda.service;

import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.venda.entity.TabelaPrecoEntity;
import br.edu.materdei.tas.venda.repository.TabelaPrecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabelaPrecoService implements IBaseService<TabelaPrecoEntity> {
    
    @Autowired
    private TabelaPrecoRepository repository;

    @Override
    public List<TabelaPrecoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public TabelaPrecoEntity findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public TabelaPrecoEntity save(TabelaPrecoEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
