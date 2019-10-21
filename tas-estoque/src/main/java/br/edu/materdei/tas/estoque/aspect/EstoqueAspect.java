package br.edu.materdei.tas.estoque.aspect;

import br.edu.materdei.tas.compra.entity.CompraEntity;
import br.edu.materdei.tas.compra.entity.ItemCompraEntity;
import br.edu.materdei.tas.compra.service.CompraService;
import br.edu.materdei.tas.estoque.entity.EstoqueEntity;
import br.edu.materdei.tas.estoque.service.EstoqueService;
import br.edu.materdei.tas.venda.entity.ItemPedidoEntity;
import br.edu.materdei.tas.venda.entity.VendaEntity;
import br.edu.materdei.tas.venda.service.VendaService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EstoqueAspect {
    
    @Autowired
    private EstoqueService estoqueService;
    
    @Autowired
    private CompraService compraService;
    
    @Autowired
    private VendaService vendaService;
    
    
    @AfterReturning(pointcut = "execution(* br.edu.materdei.tas.compra.service.CompraService.save(..))")
    public void salvarCompra(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();        
        CompraEntity compra = (CompraEntity) args[0];
        
        for (ItemCompraEntity item : compra.getItens()) {
        
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setProduto(item.getProduto());
            estoque.setQtdade(item.getQtdade());
            estoque.setHistorico("Movimento de entrada originado pela compra "+ compra.getCodigo());
            
            estoqueService.save(estoque);
        }
        
    }
    
    @AfterReturning(pointcut = "execution(* br.edu.materdei.tas.venda.service.VendaService.save(..))")
    public void salvarVenda(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();        
        VendaEntity venda = (VendaEntity) args[0];
        
        for (ItemPedidoEntity item : venda.getPedido().getItens()) {
        
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setProduto(item.getProduto());
            estoque.setQtdade(item.getQtdade() * -1);
            estoque.setHistorico("Movimento de saída originado pela venda "+ venda.getCodigo());
            
            estoqueService.save(estoque);
        }
    }
    
    @AfterReturning(pointcut = "execution(* br.edu.materdei.tas.compra.service.CompraService.delete(..))")
    public void estornarCompra(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();        
        Integer id = (Integer) args[0];
        
        CompraEntity compra = compraService.findById(id);
        
        for (ItemCompraEntity item : compra.getItens()) {
        
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setProduto(item.getProduto());
            estoque.setQtdade(item.getQtdade() * -1);
            estoque.setHistorico("Movimento de saída originado pelo estorno da compra "+ compra.getCodigo());
            
            estoqueService.save(estoque);
        }
    }
    
    @AfterReturning(pointcut = "execution(* br.edu.materdei.tas.venda.service.VendaService.delete(..))")
    public void estornarVenda(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();        
        Integer id = (Integer) args[0];
        
        VendaEntity venda = vendaService.findById(id);
        
        for (ItemPedidoEntity item : venda.getPedido().getItens()) {
        
            EstoqueEntity estoque = new EstoqueEntity();
            estoque.setProduto(item.getProduto());
            estoque.setQtdade(item.getQtdade());
            estoque.setHistorico("Movimento de entrada originado pelo estorno da venda "+ venda.getCodigo());
            
            estoqueService.save(estoque);
        }
    }
}
