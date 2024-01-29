package sanita.excercise;

import java.util.Comparator;

public class Persona implements Comparable<Persona> {

    private String nome;
    private String cognome;
    private String codiceFiscale;

//    private Medico medico;

    public Persona(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

//    public Medico getMedico() {
//        return medico;
//    }
//
//    public void setMedico(Medico medico) {
//        this.medico = medico;
//    }
    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persona persona) {
        return this.getCognome().compareTo(persona.getCognome());
    }
}
