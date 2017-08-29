package aplicacao.produtos.modelo;

public class Produto {
  private Integer codigo;
  private String descricao;
  private Double preco;
  private Integer estoque;
  private String categoria;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Produto produto = (Produto) o;

    return codigo != null ? codigo.equals(produto.codigo) : produto.codigo == null;
  }

  @Override
  public int hashCode() {
    return codigo != null ? codigo.hashCode() : 0;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Integer getEstoque() {
    return estoque;
  }

  public void setEstoque(Integer estoque) {
    this.estoque = estoque;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
