public class Luz {
    private boolean ligada;

    public void ligar() {
        ligada = true;
    }

    public void desligar() {
        ligada = false;
    }

    public boolean isLigada() {
        return ligada;
    }
}
