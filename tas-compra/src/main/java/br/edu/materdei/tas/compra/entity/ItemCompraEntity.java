package br.edu.materdei.tas.compra.entity;

import br.edu.materdei.tas.core.entity.ProdutoEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemcompra")
public class ItemCompraEntity {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(nullable = false)
    private Double qtdade;
    
    @Column(nullable = false)
    private Double vlrunit;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProdutoEntity produto;

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
     * @return the qtdade
     */
    public Double getQtdade() {
        return qtdade;
    }

    /**
     * @param qtdade the qtdade to set
     */
    public void setQtdade(Double qtdade) {
        this.qtdade = qtdade;
    }

    /**
     * @return the vlrunit
     */
    public Double getVlrunit() {
        return vlrunit;
    }

    /**
     * @param vlrunit the vlrunit to set
     */
    public void setVlrunit(Double vlrunit) {
        this.vlrunit = vlrunit;
    }

    /**
     * @return the produto
     */
    public ProdutoEntity getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }
    
    
}
