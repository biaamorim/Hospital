package src.domain;

public class Atendimento {
     private int id;
     private String  tipodeAtendimento;
     private int idMedico ;
     private int idEnfermeiro ;

    public int getId() {
        return id;
    }

    public String getTipodeAtendimento() {
        return tipodeAtendimento;
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

    public void setTipodeAtendimento(String tipodeAtendimento) {
        this.tipodeAtendimento = tipodeAtendimento;
    }

    public void setIdEnfermeiro(int idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }
}
