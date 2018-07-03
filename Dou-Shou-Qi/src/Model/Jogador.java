package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class Jogador {
    
    private String nome;
    private List<Animal> pecas;
    private boolean jogadorAtual;

    public Jogador(String nome) {
        this.nome = nome;
        this.jogadorAtual = false;
        this.pecas = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Animal> getPecas() {
        return pecas;
    }

    public void setPecas(List<Animal> pecas) {
        this.pecas = pecas;
    }   

    public boolean isJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(boolean jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }
    
    public void adicionaPeca(Animal peca){
        pecas.add(peca);
    }
    
    public void removePeca(Animal peca){
        pecas.remove(peca);
    }
    
    public void accept(VisitorAnimaisJogador visitor){
        for (Animal a : pecas){
            visitor.visit(a);
        }
    }
    
}
