import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MyFrame extends JFrame implements KeyListener{
	
  Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

   public void keyPressed(KeyEvent e){

       if(e.getKeyCode() == KeyEvent.VK_RIGHT){
           drawing.moveRight();
       }

       else if(e.getKeyCode() == KeyEvent.VK_LEFT){
           drawing.moveLeft();
       }

       else if(e.getKeyCode() == KeyEvent.VK_UP){
           drawing.moveUp();
       }

       else if(e.getKeyCode() == KeyEvent.VK_DOWN){
           drawing.moveDown();
       }
   	    
   }

   public void keyReleased(KeyEvent e){

   }

   public void keyTyped(KeyEvent e){
       System.out.println("key typed");
   }

	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();

		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setBackground(Color.GRAY);
		gameFrame.setSize(500, 500);
		gameFrame.setVisible(true);
    gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("PG");
	}
}