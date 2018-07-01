package View;

import Controller.TabuleiroController;
import Model.ObservadorTabuleiro;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivens
 */
public class TabuleiroTableModel extends AbstractTableModel implements ObservadorTabuleiro{

    private TabuleiroController tabuleiroController;
    private HashMap<String, ImageIcon> imagens;        
    
    public TabuleiroTableModel(){              
        String jogador1     = JOptionPane.showInputDialog("Digite o nome do jogador 1:");
        String jogador2     = JOptionPane.showInputDialog("Digite o nome do jogador 2:");
        imagens             = new HashMap<String, ImageIcon>();        
        tabuleiroController = new TabuleiroController(jogador1, jogador2);
        tabuleiroController.observarTabuleiro(this);    
        tabuleiroController.adicionaTodasPecasNoTabuleiro();        
    }
    
    @Override
    public int getRowCount() {
        return 9;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return imagens.get(tabuleiroController.retornaCaminhoImagemPelaPosicao(columnIndex, rowIndex)).getImage();
    }

    @Override
    public void notificarCarregamentoTabuleiro() {
        for (int x = 0; x < 7; x++){
            for (int y = 0; y < 9; y++){
                String caminho = tabuleiroController.retornaCaminhoImagemPelaPosicao(x, y);
                if (imagens.get(caminho) == null){                    
                    imagens.put(caminho, new ImageIcon(caminho));                                 
                    setValueAt(imagens.get(caminho).getImage(), x, y);
                }
            }
        }
    }    
    
    public TabuleiroController retornaController(){
        return this.tabuleiroController;
    }
    
    public ImageIcon retornaImageIconPeloCaminho(String caminho){
        return imagens.get(caminho);
    }
    
    public void movimentaPecas(int coluna, int linha){        
        tabuleiroController.movimentaPeca(coluna, linha);
    }

    @Override
    public void receberMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    @Override
    public void notificarAlteracaoTabuleiro() {
        fireTableDataChanged();
    }

    @Override
    public void notificarFimJogo(String jogadorVencedor) {
        JOptionPane.showMessageDialog(null, "Fim do jogo! Parabéns " + jogadorVencedor + "!");
        System.exit(0);
    }

    @Override
    public void notificaTrocouImagem(String imagem) {
        if (imagens.get(imagem) == null){
            imagens.put(imagem, new ImageIcon(imagem));
        }
    }
    
}
