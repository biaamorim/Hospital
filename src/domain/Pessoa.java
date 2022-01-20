package domain;

public class Pessoa {
  private String nome;
  private String numeroTelefone;
  private String endereco;
  private String sexo;

  public String getNome() {
    return nome;
  }

  public String getNumeroTelefone() {
    return numeroTelefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getSexo() {
    return sexo;
  }

  public void setNome(String Nome) {
    this.nome = Nome;
  }

  public void setNumeroTelefone(String NumeroTelefone) {
    this.numeroTelefone = NumeroTelefone;
  }

  public void setEndereco(String Endereco) {
    this.endereco = Endereco;
  }

  public void setSexo(String Sexo) {
    this.sexo = Sexo;
  }
}