import java.util.Objects;

public class Ligar implements Comando {
    private final Luz luz;

    public Ligar(Luz luz) {
        this.luz = Objects.requireNonNull(luz, "Luz obrigatoria");
    }

    @Override
    public void executar() {
        luz.ligar();
    }
}
