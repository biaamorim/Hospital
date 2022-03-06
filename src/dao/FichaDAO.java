package src.dao;

import java.util.Date;

import config.ProvedorPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FichaDAO {
  ProvedorPostgres provedor = new ProvedorPostgres();

  public Ficha preencheFicha() {
    Scanner scan = new Scanner(System.in);
    System.out.println("------------------- DADOS DA FICHA -------------------");
    System.out.println("Insira a descrição: ");
    String descricao = scan.next();
    System.out.println("Insira o tipo de atendimento: ");
    String tipoAtendimento = scan.next();
    return new Ficha(descricao, tipoAtendimento);
  }

  public void cadastraFicha() {
    String fichaQuery = "INSERT INTO ficha (descricao, dataRegistro, tipoAtendimento) VALUES (?, ?, ?)";
    Connection conn = provedor.pegaConexao();
    PreparedStatement pstm; 

    try {
      pstm = conn.prepareStatement(fichaQuery);
      pstm.setString(1, ficha.getDescricao());
      pstm.setDate(2, ficha.getDataRegistro());
      pstm.setString(3, ficha.getTipoAtendimento());

      ResultSet resultSet = pstm.executeQuery();
      int id = 0; 
      if (resultSet.next()) {
        id = resultSet.getInt("id");
      }
    }catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if(conn != null) {
        provedor.fechaConexao(conn); 
      }
    }
  }

  public void listaFicha() {
    String fichaQuery = "SELECT FROM ficha";
    Connection conn = provedor.pegaConexao();
    PreparedStatement pstm;
    ResultSet resultSet; 
    List<Ficha> fichas = new ArrayList<>();
    try {
      pstm = conn.prepareStatement(fichaQuery);
      resultSet = pstm.executeQuery();
      while(resultSet.next()) {
        Ficha ficha = new Ficha(resultSet.getString("descricao"), 
        resultSet.getString("dataRegistro"), 
        resultSet.getString("tipoAtendimento"));
        fichas.add(ficha);
      }
      for (Ficha ficha: fichas) {
        System.out.println("------------------- DADOS DA FICHA -------------------");
        System.out.println("Id:" + ficha.getId());
        System.out.println("Descrição: " + ficha.getDescricao());
        System.out.println("Data registro:" + ficha.getDataRegistro());
        System.out.println("Tipo de Atendimento" + ficha.getTipoAtendimento());
        System.out.println("------------------------------------------");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if (conn != null) {
        provedor.fechaConexao(conn);
      }
    }
  }

  public void atualizaFicha() {

  }
  
  public void deleteFicha() {

  }
}



/*private final int id;
    private String descricao;
    private String dataRegistro;
    private String tipoAtendimento;*/ 