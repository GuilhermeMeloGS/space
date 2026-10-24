package br.com.joaocarloslima;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Jogo {
    List<Asset> assets = new ArrayList<>();
    Nave nave = new Nave(280, 400, 10, Direcao.DIREITA);
    private int pontos;
    private int nivel = 1;

    public Tiro atirar(){
        Tiro tiro  = (nave.atirar(nivel));
        assets.add(tiro);
        return tiro;
    }


    public Meteoro criarMeteoro() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        int xAleatorio = random.nextInt(0, 640 - 50 + 1);
        int velocidadeAleatoria = random.nextInt(1, 6);

        Meteoro meteoro = new Meteoro(
                xAleatorio,
                0,
                velocidadeAleatoria,
                Direcao.BAIXO
        );

        assets.add(meteoro);
        return meteoro;
    }

    public void pontuar() {
        pontos++;
        int novoNivel = 1 + (pontos / 10);
        if (novoNivel > 4) {
            novoNivel = 4;
        }
        this.nivel = novoNivel;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
