package sanita.excercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Medico extends Persona {

    private int matricola;
    private List<Persona> pazienti = new ArrayList<>();
    public Medico(String nome, String cognome, String codiceFiscale, int matricola) {
        super(nome, cognome, codiceFiscale);
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public void addPaziente (Persona persona) {
        pazienti.add(persona);
    }

    public void deletePaziente (Persona persona) {
        pazienti.remove(persona);
    }

    public List<Persona> getPazienti() {
        pazienti.sort(Comparator.comparing(Persona::getCognome).reversed());
//        Collections.sort(pazienti, new PersonaNomeComparator());
        return pazienti;
    }

    @Override
    public String toString() {
        return "Medico{" +
                super.toString() +
                "matricola=" + matricola +
                ", pazienti=" + pazienti +
                '}';
    }
}
