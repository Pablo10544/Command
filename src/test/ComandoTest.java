import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComandoTest {
    @Test
    void iniciaDesligada() {
        assertFalse(new Luz().isLigada());
    }

    @Test
    void ligaLuz() {
        Luz luz = new Luz();

        new Ligar(luz).executar();

        assertTrue(luz.isLigada());
    }

    @Test
    void desligaLuz() {
        Luz luz = new Luz();
        luz.ligar();

        new Desligar(luz).executar();

        assertFalse(luz.isLigada());
    }

    @Test
    void trocaComando() {
        Luz luz = new Luz();
        Controle controle = new Controle(new Ligar(luz));

        controle.executar();
        assertTrue(luz.isLigada());

        controle.definir(new Desligar(luz));
        controle.executar();
        assertFalse(luz.isLigada());
    }

    @Test
    void aceitaOutroComando() {
        int[] chamadas = {0};
        Controle controle = new Controle(() -> chamadas[0]++);

        controle.executar();

        assertEquals(1, chamadas[0]);
    }

    @Test
    void rejeitaLuzNula() {
        assertThrows(NullPointerException.class, () -> new Ligar(null));
        assertThrows(NullPointerException.class, () -> new Desligar(null));
    }

    @Test
    void rejeitaComandoNulo() {
        assertThrows(NullPointerException.class, () -> new Controle(null));
        Luz luz = new Luz();
        Controle controle = new Controle(new Ligar(luz));

        assertThrows(NullPointerException.class, () -> controle.definir(null));

        controle.executar();
        assertTrue(luz.isLigada());
    }
}
