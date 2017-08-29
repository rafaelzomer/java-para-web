package aplicacao.produtos.mb;

import aplicacao.produtos.modelo.Produto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

@ManagedBean
@ViewScoped
public class ProdutoMB {
  private ArrayList<Produto> produtos = new ArrayList<>();
  private Produto produto;

  @PostConstruct
  public void novo() {
    this.produto = new Produto();
    this.produto.setCodigo(this.produtos.size() + 1);
  }

  public void salvar() {
    if(!this.produtos.contains(produto)) {
      this.produtos.add(produto);
    }
    this.novo();
  }

  public void excluir() {
    this.excluir(this.produto);
  }

  public void excluir(Produto produto) {
    this.produtos.remove(produto);
    this.novo();
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public ArrayList<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(ArrayList<Produto> produtos) {
    this.produtos = produtos;
  }
}