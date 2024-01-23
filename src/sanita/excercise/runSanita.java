package sanita.excercise;

import java.io.FileNotFoundException;

public class runSanita {

    public static void main(String[] args){

        Sanita sanita = new Sanita();
        try {
            sanita.caricaDati("C:\\Users\\UTENTE\\IdeaProjects\\sanita\\src\\sanita\\excercise\\persone.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sanita.getMedico(45678));
        System.out.println(sanita.getPersona("MRTSMN80F12H456L"));

        sanita.assegnaMedico(23456, "CNTFNC87F10H890J");
        sanita.assegnaMedico(23456, "NREELN92F04H012D");
        sanita.assegnaMedico(23456, "FRRGPP88M05H345E");
        // Assegno anche un medico
        sanita.assegnaMedico(23456, "ESPALE90F14H012N");
        System.out.println(sanita.getMedico(23456).getPazienti());

    }
}
