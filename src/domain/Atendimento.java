package src.domain;

public class Atendimento {
     private int id;
     private String  tipoAtendimento;
     private int idMedico ;
     private int idEnfermeiro ;

    public int getId() {
        return id;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public int getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public void setIdEnfermeiro(int idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }
}
