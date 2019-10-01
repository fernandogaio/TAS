package br.edu.materdei.tas.venda.service;

import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.venda.entity.VendaEntity;
import br.edu.materdei.tas.venda.repository.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService implements IBaseService<VendaEntity> {
    
    @Autowired
    private VendaRepository repository;

    @Override
    public List<VendaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public VendaEntity findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public VendaEntity save(VendaEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
