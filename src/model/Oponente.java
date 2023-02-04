package src.model;

import java.util.Random;
/**
 *
 * @author (Luiz Moura - 326495 )
 * @author (Matheus Maica - 264449)
 * @version (11/22)
 *
 */
public class Oponente {
    public Local minhaLocalizacao;
    Random numeroAleatorio;

    public Oponente(Local minhaLocalizacao) {
        this.minhaLocalizacao = minhaLocalizacao;
        this.numeroAleatorio = new Random();
    }

    public void mover() {
        if (this.minhaLocalizacao instanceof IPortaExterna && this.numeroAleatorio.nextBoolean()) {
            Local novaLocalizacao;
            do {
                novaLocalizacao = this.minhaLocalizacao.saidas[this.numeroAleatorio.nextInt(this.minhaLocalizacao.saidas.length) + 1];
            } while(!(novaLocalizacao instanceof IEsconderijo));

            this.minhaLocalizacao = novaLocalizacao;
        }

    }

    public Boolean checar(Local local) {
        return local.nome == this.minhaLocalizacao.nome;
    }
}
