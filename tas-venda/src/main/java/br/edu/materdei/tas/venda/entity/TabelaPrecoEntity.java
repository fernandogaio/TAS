package br.edu.materdei.tas.venda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tabelapreco")       
public class TabelaPrecoEntity {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(length = 6, nullable = false)
    private String codigo;
    
    @Column(length = 50, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private Double fator;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the fator
     */
    public Double getFator() {
        return fator;
    }

    /**
     * @param fator the fator to set
     */
    public void setFator(Double fator) {
        this.fator = fator;
    }
    
    
    
    
}
