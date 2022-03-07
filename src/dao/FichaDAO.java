package dao;

import config.ProvedorPostgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

import domain.Ficha;
import interfaces.DAOInterface;

public class FichaDAO implements DAOInterface {
  ProvedorPostgres provedor = new ProvedorPostgres();

  public Ficha preencheFicha() {
    Scanner scan = new Scanner(System.in);
    System.out.println("------------------- DADOS DA FICHA -------------------");
    System.out.println("Insira a descrição: ");
    String descricao = scan.nextLine();
    System.out.println("Insira o tipo de atendimento: ");
    String tipoAtendimento = scan.nextLine();
    System.out.println("Insira a data: ");
    String dataRegistro = scan.nextLine();
    return new Ficha(0, descricao, tipoAtendimento, dataRegistro);
  }

  public void cadastraFicha(@NotNull Ficha ficha) {
    String fichaQuery = "INSERT INTO ficha (descricao, tipo_atendimento, data_registro) VALUES (?, ?, ?)";
    Connection conn = provedor.pegaConexao();
    PreparedStatement pstm;
    try {
      pstm = conn.prepareStatement(fichaQuery);
      pstm.setString(1, ficha.getDescricao());
      pstm.setString(3, ficha.getTipoAtendimento());
      pstm.setString(2, ficha.getDataRegistro());
      pstm.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if(conn != null) {
        provedor.fechaConexao(conn); 
      }
    }
  }

  public void atualizaFicha(@NotNull Ficha ficha, int id) {
    String fichaQuery = "UPDATE ficha SET descricao = ?, tipo_atendimento = ?, data_registro = ? WHERE id_ficha = ?";
    Connection conn = provedor.pegaConexao();
    PreparedStatement pstm;
    try {
      pstm = conn.prepareStatement(fichaQuery);
      pstm.setString(1, ficha.getDescricao());
      pstm.setString(2, ficha.getTipoAtendimento());
      pstm.setString(3, ficha.getDataRegistro());
      pstm.setInt(4, id);
      pstm.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        provedor.fechaConexao(conn);
      }
    }
  }

  @Override
  public void lista() {
      String fichaQuery = "SELECT * FROM ficha";
      Connection conn = provedor.pegaConexao();
      PreparedStatement pstm;
      ResultSet resultSet;
      List<Ficha> fichas = new ArrayList<>();
      try {
        pstm = conn.prepareStatement(fichaQuery);
        resultSet = pstm.executeQuery();
        while(resultSet.next()) {
          Ficha ficha = new Ficha( resultSet.getInt("id_ficha"), resultSet.getString("descricao"),
                  resultSet.getString("tipo_atendimento"),
                  resultSet.getString("data_registro"));
          fichas.add(ficha);
        }
        for (Ficha ficha: fichas) {
          System.out.println("------------------- DADOS DA FICHA -------------------");
          System.out.println("Id:" + ficha.getId());
          System.out.println("Descrição: " + ficha.getDescricao());
          System.out.println("Tipo de Atendimento:" + ficha.getTipoAtendimento());
          System.out.println("Data registro:" + ficha.getDataRegistro());
          System.out.println("------------------------------------------");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        if (conn != null) {
          provedor.fechaConexao(conn);
        }
      }
  }

  @Override
  public void remove(int id) {
    String fichaQuery = "DELETE FROM ficha WHERE id_ficha = ?";
    Connection conn = provedor.pegaConexao();
    PreparedStatement pstm;
    try {
      pstm = conn.prepareStatement(fichaQuery);
      pstm.setInt(1, id);
      pstm.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        provedor.fechaConexao(conn);
      }
    }
  }
}