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
    private List<Armadilha> armadilhas;
    private Toca toca;
    private boolean jogadorAtual;
    private Animal animalAtual;

    public Jogador(String nome) {
        this.nome = nome;
        this.jogadorAtual = false;
        this.pecas = new ArrayList();
        this.armadilhas = new ArrayList();
        this.toca = null;
        this.animalAtual = null;
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

    public Toca getToca() {
        return toca;
    }

    public void setToca(Toca toca) {
        this.toca = toca;
    }

    public List<Armadilha> getArmadilhas() {
        return armadilhas;
    }

    public void setArmadilhas(List<Armadilha> armadilhas) {
        this.armadilhas = armadilhas;
    }
    
    public void addArmadilha(Armadilha a){
        armadilhas.add(a);
    }

    public Animal getAnimalAtual() {
        return animalAtual;
    }

    public void setAnimalAtual(Animal animalAtual) {
        this.animalAtual = animalAtual;
    }  
    
    public boolean verificaSeEhArmadilha(int linha, int coluna){
        for (Armadilha a : armadilhas){
            if (a.getLinha() == linha && a.getColuna() == coluna){
                return true;
            }
        }
        
        return false;
    }
    
    public Animal retornaAnimalPelaPosicao(int linha, int coluna){
        for (Animal a : pecas){
            if (a.getLinha() == linha && a.getColuna() == coluna){
                return a;
            }
        }
        
        return null;
    }
    
    public void accept(VisitorAnimaisJogador visitor){
        for (Animal a : pecas){
            visitor.visit(a);
        }
    }
    
}
