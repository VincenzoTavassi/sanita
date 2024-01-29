package sanita.excercise;

import java.util.Comparator;

public class PersonaNomeComparator implements Comparator<Persona> {


    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
