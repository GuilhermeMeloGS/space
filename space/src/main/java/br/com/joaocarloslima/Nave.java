package br.com.joaocarloslima;

public class Nave extends Asset{

    public Nave(int x, int y, int velocidade, Direcao direcao) {
        super(x, y, velocidade, direcao);
    }

    public Tiro atirar(int poder){
        Tiro tiro = new Tiro(getX(), getY(),10, Direcao.CIMA,poder);
        return tiro;
    }

    @Override
    public void mover() {
        int proximoX = x;

        if (direcao == Direcao.DIREITA) {
            proximoX += velocidade;
        } else if (direcao == Direcao.ESQUERDA) {
            proximoX -= velocidade;
        }

        if (proximoX >= 0 && proximoX <= (640 - 50)) {
            this.x = proximoX;
        }

    }


}
