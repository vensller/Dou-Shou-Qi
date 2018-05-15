package Principal;

import View.Tabuleiro;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivens
 */
public class Dou_Shou_Qi {
    
    public static void main(String[] args){
        Tabuleiro.getInstance().setVisible(true);
        JOptionPane.showMessageDialog(Tabuleiro.getInstance(), "Jogador 1 (Vermelho) começa!");
    }
    
}
