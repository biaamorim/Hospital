package src.domain;

public abstract class Pessoa {
  private String nome;
  private String cpf;
  private String numeroTelefone;
  private String endereco;
  private String sexo;

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
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

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setNumeroTelefone(String numeroTelefone) {
    this.numeroTelefone = numeroTelefone;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public abstract Registro preencheRegistro(Registro registro);
}