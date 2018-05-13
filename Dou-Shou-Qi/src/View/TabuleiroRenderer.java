package View;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ivens
 */
public class TabuleiroRenderer extends DefaultTableCellRenderer{
    
    private Image image;
    private int alturaImagem;
    private int larguraImagem;
    private int alturaDesenhar;
    private int larguraDesenhar;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {                
        String caminho = ((TabuleiroTableModel)table.getModel()).retornaController().retornaCaminhoImagemPelaPosicao(column, row);
        ImageIcon imageIcon = ((TabuleiroTableModel)table.getModel()).retornaImageIconPeloCaminho(caminho);
        this.image = imageIcon.getImage();
        setIcon(imageIcon);
        larguraImagem = table.getColumnModel().getTotalColumnWidth() / 9 + 15;
        table.setRowHeight(larguraImagem - 5);
        alturaImagem = table.getRowHeight();        
        larguraDesenhar = table.getColumnModel().getTotalColumnWidth() / 7;
        alturaDesenhar = table.getRowHeight();        
        return this;
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(this.image, 0, 0, larguraImagem, alturaImagem, null);
        g.drawRect(0, 0, larguraDesenhar, alturaDesenhar);
    }
    
}
