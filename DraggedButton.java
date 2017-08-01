import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DraggedButton extends JButton{

    private volatile int draggedAtX, draggedAtY;

    public DraggedButton(JButton button, JFrame frame){
    	
    	button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                draggedAtX = e.getX();
                draggedAtY = e.getY();
            }
        });

        button.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                button.setBounds(draggedAtX + e.getX(), draggedAtY + e.getY(), 500, 500);
            }
        });
    }
}