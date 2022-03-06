package domain;

import java.util.Date;

public class Registro {
    private final int id;
    private String nomePaciente;
    private String tipoAtendimento;
    private Date diaAtendimento;
    private String areaAtendimento;
    private String nomeMedico;
    private String nomeEnfermeiro;

    public Registro(int id, String nomePaciente, String tipoAtendimento, Date diaAtendimento,
                    String areaAtendimento, String nomeMedico, String nomeEnfermeiro) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.tipoAtendimento = tipoAtendimento;
        this.diaAtendimento = diaAtendimento;
        this.areaAtendimento = areaAtendimento;
        this.nomeMedico = nomeMedico;
        this.nomeEnfermeiro = nomeEnfermeiro;
    }

    public int getId() {
        return id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public Date getDiaAtendimento() {
        return diaAtendimento;
    }

    public String getAreaAtendimento() {
        return areaAtendimento;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getNomeEnfermeiro() {
        return nomeEnfermeiro;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public void setDiaAtendimento(Date diaAtendimento) {
        this.diaAtendimento = diaAtendimento;
    }

    public void setAreaAtendimento(String areaAtendimento) {
        this.areaAtendimento = areaAtendimento;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void setNomeEnfermeiro(String nomeEnfermeiro) {
        this.nomeEnfermeiro = nomeEnfermeiro;
    }
}
