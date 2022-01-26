package src.domain;

public class Registro {
    private int id;
    private int pacienteId;
    private int medicoId;
    private int enfermeiroId;
    private int fichaId;

    public int getId() {
        return id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public int getEnfermeiroId() {
        return enfermeiroId;
    }

    public int getFichaId() {
        return fichaId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public void setEnfermeiroId(int enfermeiroId) {
        this.enfermeiroId = enfermeiroId;
    }

    public void setFichaId(int fichaId) {
        this.fichaId = fichaId;
    }
}
