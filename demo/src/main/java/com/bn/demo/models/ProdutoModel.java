package com.bn.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity//Define para o compulador que essa entidade se refere a uma entidade dentro do projeto
@Table(name = "TB_PRODUTO")//define em qual local aquele dado esta disponibilizado EX: client
public class ProdutoModel {

    @Id//define esse atributo como identificador unico da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)//define o tipo de maneira como o elemento tera seu identificador unico gerado
    private Long id;
    private String nome;
    @Column(name = "preco_do_produto")//define à qual coluna esse atributo se refere
    private BigDecimal preco;
    @Column(name = "quant_estoque")//define à qual coluna esse atributo se refere
    private Integer estoque;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPreco() { return preco; }

    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Integer getEstoque() { return estoque; }

    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}
