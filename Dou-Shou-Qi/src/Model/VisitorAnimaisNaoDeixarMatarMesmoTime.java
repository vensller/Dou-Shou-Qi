package Model;

import java.util.List;

/**
 *
 * @author Ivens
 */
public class VisitorAnimaisNaoDeixarMatarMesmoTime implements VisitorAnimaisJogador{
    
    private List<Animal> pecasTime;

    public VisitorAnimaisNaoDeixarMatarMesmoTime(List<Animal> pecasTime) {
        this.pecasTime = pecasTime;
    }   

    @Override
    public void visit(Animal animal) {
        animal.naoDeixarMatarMesmoTime(pecasTime);
    }
    
    
}
