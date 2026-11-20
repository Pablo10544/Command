public class Main {
    public static void main(String[] args) {
        Luz luz = new Luz();
        Comando ligar = new Ligar(luz);
        Comando desligar = new Desligar(luz);
        Controle controle = new Controle(ligar);

        controle.executar();
        controle.definir(desligar);
        controle.executar();
    }
}
