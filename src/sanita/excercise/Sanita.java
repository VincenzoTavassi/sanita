package sanita.excercise;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Sanita {

    Set<Persona> persone = new HashSet<>();
    Set<Medico> medici = new HashSet<>();


    public void aggiungiPersona(String nome, String cognome, String codiceFiscale) {
        Persona persona = new Persona (nome, cognome, codiceFiscale);
        persone.add(persona);
    }
    public void aggiungiMedico(String nome, String cognome, String codiceFiscale, int matricola) {
        Medico medico = new Medico(nome, cognome, codiceFiscale, matricola);
        medici.add(medico);
        persone.add(medico);
    }
    public Persona getPersona (String codiceFiscale) throws ErrPersonaInesistenteException {

        boolean exists = false;
        for (Persona persona : persone) {
            if (persona.getCodiceFiscale().equals(codiceFiscale)) {
                exists = true;
                return persona;
            }
    }
        if (!exists) throw new ErrPersonaInesistenteException("Persona inesistente");
        return null;
    }

    public Medico getMedico (int matricola) throws ErrMedicoInesistenteException {

        boolean exists = false;
        for (Medico medico : medici) {
            if (medico.getMatricola() == matricola) {
                exists = true;
                return medico;
            }
        }
        if (!exists) throw new ErrMedicoInesistenteException("Medico inesistente");
        return null;
    }

    public void assegnaMedico (int matricola, String codiceFiscale) throws ErrPersonaInesistenteException, ErrMedicoInesistenteException {
        Medico medicoTrovato = null;
        Paziente personaTrovata = null;
        for (Medico medico : medici) {
            if (medico.getMatricola() == matricola) medicoTrovato = medico;
        }
        if (medicoTrovato == null) throw new ErrMedicoInesistenteException("Medico non trovato");

        for (Persona persona : persone) {
            if (persona.getCodiceFiscale().equals(codiceFiscale)) {
                personaTrovata = new Paziente (persona.getNome(), persona.getCognome(), persona.getCodiceFiscale(), medicoTrovato);
            }
        }
        if (personaTrovata == null) throw new ErrPersonaInesistenteException("Persona non trovata");

        medicoTrovato.addPaziente(personaTrovata);
    }

    public void caricaDati(String path) throws FileNotFoundException {
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineContent = line.split(";");
                if (lineContent.length == 4 || lineContent.length == 5) {
                    if(lineContent[0].equalsIgnoreCase("P")) {
                        Paziente paziente = new Paziente(lineContent[1], lineContent[2], lineContent[3]);
                        persone.add(paziente);
                    } else if(lineContent[0].equalsIgnoreCase("M")) {
                        Medico medico = new Medico(lineContent[1], lineContent[2], lineContent[3], Integer.parseInt(lineContent[4]));
                        persone.add(medico);
                        medici.add(medico);
                    } else {
                        System.out.println("SKIP: Trovato errore nella lista: una delle righe non è un medico o un paziente");
                    }
                } else {
                    System.out.println("SKIP: Trovato errore nella ista: pochi parametri in una riga");
                }
            }
        }

    }

}
