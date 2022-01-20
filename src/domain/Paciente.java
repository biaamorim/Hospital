package domain;

public class Paciente extends Pessoa {
  private int id;
  private String dataNascimento;
  private String cor;
  private String dataCadastro;
  private String filiacao;
  private String email;

  public int getId() {
    return id;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public String getCor() {
    return cor;
  }

  public String getDataCadastro() {
    return dataCadastro;
  }

  public String getFiliacao() {
    return filiacao;
  }

  public String getEmail() {
    return email;
  }
  
  public void setDataNascimento(String DataNascimento) {
    this.dataNascimento = DataNascimento;
  }

  public void setCor(String Cor) {
    this.cor = Cor;
  }

  public void setDataCadastro(String DataCadastro) {
    this.dataCadastro = DataCadastro;
  }

  public void setFiliacao(String Filiacao) {
    this.filiacao = Filiacao;
  }

  public void setEmail(String Email) {
    this.email = Email;
  }
}
