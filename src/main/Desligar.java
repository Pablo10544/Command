import java.util.Objects;

public class Desligar implements Comando {
    private final Luz luz;

    public Desligar(Luz luz) {
        this.luz = Objects.requireNonNull(luz, "Luz obrigatoria");
    }

    @Override
    public void executar() {
        luz.desligar();
    }
}
