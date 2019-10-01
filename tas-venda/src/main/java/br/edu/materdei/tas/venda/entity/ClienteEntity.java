package br.edu.materdei.tas.venda.entity;

import br.edu.materdei.tas.core.entity.Pessoa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity extends Pessoa {
    
    @Column(length = 11, nullable = false)
    private String cpf;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private TabelaPrecoEntity tabelapreco;

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the tabelapreco
     */
    public TabelaPrecoEntity getTabelapreco() {
        return tabelapreco;
    }

    /**
     * @param tabelapreco the tabelapreco to set
     */
    public void setTabelapreco(TabelaPrecoEntity tabelapreco) {
        this.tabelapreco = tabelapreco;
    }
    
}
