package sanita.excercise;

public class ErrMedicoInesistenteException extends RuntimeException {
    public ErrMedicoInesistenteException() {
    }

    public ErrMedicoInesistenteException(String message) {
        super(message);
    }
}
