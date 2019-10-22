package br.edu.materdei.tas.venda.service;

import br.edu.materdei.tas.core.service.IBaseService;
import br.edu.materdei.tas.venda.entity.PedidoEntity;
import br.edu.materdei.tas.venda.entity.VendaEntity;
import br.edu.materdei.tas.venda.repository.PedidoRepository;
import br.edu.materdei.tas.venda.repository.VendaRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService implements IBaseService<VendaEntity> {
    
    @Autowired
    private VendaRepository repository;
    
    @Autowired
    private PedidoRepository pedRepository;

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
        //Busca o último código
        VendaEntity last = this.repository.findFirstByOrderByCodigoDesc();
        Integer codigo = (last == null) ? 0 : Integer.valueOf(last.getCodigo());
        codigo++;
        
        entity.setCodigo( String.format("%06d", codigo));
        
        VendaEntity saved = this.repository.saveAndFlush(entity);
        
        //"Marca" o pedido como faturado
        PedidoEntity pedido = saved.getPedido();
        pedido.setDtfaturado(new Date());
        
        //Grava a alteração no pedido
        this.pedRepository.save(pedido);
        
        return saved;
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
