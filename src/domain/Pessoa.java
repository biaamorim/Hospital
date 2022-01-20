package domain;

public class Pessoa {
  private int id;
  private String nome;
  private String cpf;
  private String numeroTelefone;
  private String endereco;
  private String sexo;

  public int getId() {
    return id;
  }

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

  public void setNome(String Nome) {
    this.nome = Nome;
  }

  public void setCpf(String Cpf) {
    this.cpf = Cpf;
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