package src.domain;

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
  
  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public void setDataCadastro(String dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public void setFiliacao(String filiacao) {
    this.filiacao = filiacao;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public Registro preencheRegistro(Registro registro) {
    registro.setPacienteId(id);
    return registro;
  }
}
