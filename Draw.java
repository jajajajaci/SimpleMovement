import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Draw extends JComponent{


   private BufferedImage image;
   private URL resource = getClass().getResource("run0.png");

   private BufferedImage backgroundImage;
   private URL backgroundresource = getClass().getResource("background.jpg");

   public int x = 0;
   public int y = 350;
   public int height = 0;
   public int width = 0;

   public int state = 0;

   public Random randomizer;

   public int enemyCount = 0;
   Monster[] monsters = new Monster[10];

   public Draw(){
      randomizer = new Random();
      spawnEnemy();

     try{
        backgroundImage = ImageIO.read(backgroundresource);
        image = ImageIO.read(resource);
     }
     catch(IOException e){
         e.printStackTrace();
     }

     height = image.getHeight();
     width = image.getWidth();

     startGame();
   }

  public void startGame(){
    Thread gameThread = new Thread(new Runnable(){
      public void run(){
        while(true){
          try{
            for(int c = 0; c < monsters.length; c++){
              if(monsters[c]!=null){
                monsters[c].moveTo(x,y);
                repaint();
              }
            }
            Thread.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        }
      }
    });
    gameThread.start();
  }

  public void spawnEnemy(){
    if(enemyCount < 10){
      monsters[enemyCount] = new Monster(randomizer.nextInt(500), randomizer.nextInt(500), this);
      enemyCount++;
    }
  }


  public void attackAnimation(){
    Thread thread1 = new Thread(new Runnable(){
      public void run(){
        for(int ctr = 0; ctr < 5; ctr++){
          try {
            if(ctr==4){
              resource = getClass().getResource("run0.png");
            }
            else{
              resource = getClass().getResource("attack"+ctr+".png");
            }
            
            try{
              image = ImageIO.read(resource);
            }
            catch(IOException e){
              e.printStackTrace();
            }
                repaint();
                Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread1.start();
  }
  public void attackAnimation2(){
  Thread thread2 = new Thread(new Runnable(){
      public void run(){
        for(int ctr = 0; ctr < 5; ctr++){
          try {
            if(ctr==4){
              resource = getClass().getResource("run0.png");
            }
            else{
              resource = getClass().getResource("2attack"+ctr+".png");
            }
            
            try{
              image = ImageIO.read(resource);
            }
            catch(IOException e){
              e.printStackTrace();
            }
                repaint();
                Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread2.start();
  }

    public void attackAnimation3(){
  Thread thread3 = new Thread(new Runnable(){
      public void run(){
        for(int ctr = 0; ctr < 5; ctr++){
          try {
            if(ctr==4){
              resource = getClass().getResource("run0.png");
            }
            else{
              resource = getClass().getResource("3attack"+ctr+".png");
            }
            
            try{
              image = ImageIO.read(resource);
            }
            catch(IOException e){
              e.printStackTrace();
            }
                repaint();
                Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread3.start();
  }

    public void punchAnimation(){
  Thread thread4 = new Thread(new Runnable(){
      public void run(){
        for(int ctr = 0; ctr < 13; ctr++){
          try {
            if(ctr==12){
              resource = getClass().getResource("run0.png");
            }
            else{
              resource = getClass().getResource("punch"+ctr+".png");
            }
            
            try{
              image = ImageIO.read(resource);
            }
            catch(IOException e){
              e.printStackTrace();
            }
                repaint();
                Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread4.start();
  }

  public void kickAnimation(){
  Thread thread5 = new Thread(new Runnable(){
      public void run(){
        for(int ctr = 0; ctr < 9; ctr++){
          try {
            if(ctr==8){
              resource = getClass().getResource("run0.png");
            }
            else{
              resource = getClass().getResource("kick"+ctr+".png");
            }
            
            try{
              image = ImageIO.read(resource);
            }
            catch(IOException e){
              e.printStackTrace();
            }
                repaint();
                Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread5.start();
  }



   public void reloadImage(){
       state++;

      if (state == 0){
          resource = getClass().getResource("run0.png");
      }

      else if (state == 1){
          resource = getClass().getResource("run1.png");
      }

      else if (state == 2){
          resource = getClass().getResource("run2.png");
      }

      else if (state == 3){
          resource = getClass().getResource("run3.png");
      }

      else if (state == 4){
          resource = getClass().getResource("run4.png");
      }

      else if (state == 5){
          resource = getClass().getResource("run5.png");
          state = 0;
      }

      try {
          image = ImageIO.read(resource);
      }
      catch(IOException e){
          e.printStackTrace();
      }
   }
   
  public void reloadImage2(){
    state++;

    if(state == 0){
      resource = getClass().getResource("run00.png");
    }
    else if(state == 1){
      resource = getClass().getResource("run01.png");
    }
    else if(state == 2){
      resource = getClass().getResource("run02.png");
    }
    else if(state == 3){
      resource = getClass().getResource("run03.png");
    }
    else if(state == 4){
      resource = getClass().getResource("run04.png");
    }
    else if(state == 5){
      resource = getClass().getResource("run05.png");
      state = 0;
    }

    try{
      image = ImageIO.read(resource);
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }


	public void moveLeft(){
		x = x - 5;
		reloadImage2();
		repaint();
	}

	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
	}

  public void attack(){
    attackAnimation();
    attackAnimation2();
    attackAnimation3();
  }

  public void punch(){
    punchAnimation();
  }

  public void kick(){
   kickAnimation();
  }




	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
    g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);
    for(int c = 0; c < monsters.length; c++){
      if(monsters[c]!=null){
        g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
        g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
      }
    }
	}
}