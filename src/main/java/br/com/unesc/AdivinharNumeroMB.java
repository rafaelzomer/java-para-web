package br.com.unesc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;

@ManagedBean
@SessionScoped
public class AdivinharNumeroMB {
  private final Integer maxNums = 100;
  private Integer numero;
  private Integer acertos;
  private Integer secreto;
  private Integer tentativa;
  private Integer nivel;
  private String mensagemStatus;

  public AdivinharNumeroMB() {
    if (tentativa == null)
    {
      resetar();
    }
  }

  public void submeter() {
    if (numero == null)
    {
      numero = null;
      mensagemStatus = "Insira um número para enviar";
      return;
    }
    if (numero < 0)
    {
      numero = null;
      mensagemStatus = "O número deve ser mair que 0";
      return;
    }
    if (numero > maxNums)
    {
      numero = null;
      mensagemStatus = "O número deve ser menor ou igual a "+ maxNums;
      return;
    }
    if (numero == secreto)
    {
      numero = null;
      acertos--;
      int maxAcertos = acertosPorNivel(nivel);
      mensagemStatus = "Sucesso: Você acertou ("+(maxAcertos-acertos)+"/"+maxAcertos+")!";
      if (acertos == 0)
      {
        nivel++;
        acertos = acertosPorNivel(nivel);
        tentativa = 11 - nivel;
        mensagemStatus = "Sucesso: Você passou para o proximo nível!";
        geraAleatorio();
        if (nivel == 11)
        {
          numero = null;
          mensagemStatus = "Sucesso: Parabéns, você ganhou!";
          resetar();
        }
      }

      return;
    }
    else
    {
      tentativa--;
      if (tentativa == 0)
      {
        numero = null;
        mensagemStatus = "Você perdeu! suas tentativas acabaram!";
        resetar();
        return;
      }
      if (numero > secreto) {
        mensagemStatus = "Erro: O número digitado é maior que o número oculto.";
      } else {
        mensagemStatus = "Erro: O número digitado é menor que o número oculto.";
      }
    }
  }

  private Integer acertosPorNivel(Integer nivel)
  {
    if (nivel >= 1 && nivel <= 7)
    {
      return 3;
    }
    else if (nivel <= 9)
    {
      return 2;
    }
    else
    {
      return 1;
    }
  }

  public void desistir() {
    mensagemStatus = "Você desistiu";
    resetar();
  }

  public void resetar() {
    if (secreto != null)
    {
      mensagemStatus += ", o numero secreto era: "+secreto;
    }
    nivel = 1;
    tentativa = 10;
    acertos = acertosPorNivel(nivel);
    geraAleatorio();
  }

  private void geraAleatorio() {
    if (maxNums < 1)
    {
      secreto = maxNums;
      return;
    }
    secreto = new Random().nextInt(maxNums);
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Integer getTentativa() {
    return tentativa;
  }

  public void setTentativa(Integer tentativa) {
    this.tentativa = tentativa;
  }

  public String getMensagemStatus() {
    return mensagemStatus;
  }

  public void setMensagemStatus(String mensagemStatus) {
    this.mensagemStatus = mensagemStatus;
  }

  public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }

  public Integer getMaxNums() {
    return maxNums;
  }
}