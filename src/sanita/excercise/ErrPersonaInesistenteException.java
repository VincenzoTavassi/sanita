package sanita.excercise;

public class ErrPersonaInesistenteException extends RuntimeException {
    public ErrPersonaInesistenteException() {
    }

    public ErrPersonaInesistenteException(String message) {
        super(message);
    }
}
