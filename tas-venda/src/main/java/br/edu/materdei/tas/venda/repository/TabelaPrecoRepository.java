package br.edu.materdei.tas.venda.repository;

import br.edu.materdei.tas.venda.entity.TabelaPrecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaPrecoRepository extends JpaRepository<TabelaPrecoEntity, Integer>{
    
}
