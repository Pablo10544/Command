import java.util.Objects;

public class Controle {
    private Comando comando;

    public Controle(Comando comando) {
        definir(comando);
    }

    public void definir(Comando comando) {
        this.comando = Objects.requireNonNull(comando, "Comando obrigatorio");
    }

    public void executar() {
        comando.executar();
    }
}
