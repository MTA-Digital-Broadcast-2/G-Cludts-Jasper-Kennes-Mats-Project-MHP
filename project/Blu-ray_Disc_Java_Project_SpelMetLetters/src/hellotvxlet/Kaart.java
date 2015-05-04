package hellotvxlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import org.havi.ui.*;

public class Kaart extends HComponent {
    private Image bmap;
    private MediaTracker mtrack;
    public int letter1=1;
    public int letter2=1; 
    public String kleurTekst;
    
    public Kaart(int r1, int r2) {
        
        letter1=r1;
        letter2=r2;
        
      // bmap = this.getToolkit().getImage("A.png");
        switch(letter1) {
        
            case 1: bmap = this.getToolkit().getImage("A.png");
            break;
            case 2: bmap = this.getToolkit().getImage("B.png");
            break;
            case 3: bmap = this.getToolkit().getImage("C.png");
            break;
            case 4: bmap = this.getToolkit().getImage("D.png");
            break;
            case 5: bmap = this.getToolkit().getImage("E.png");
            break;
            case 6: bmap = this.getToolkit().getImage("F.png");
            break;
            case 7: bmap = this.getToolkit().getImage("G.png");
            break;
            case 8: bmap = this.getToolkit().getImage("H.png");
            break;
            case 9: bmap = this.getToolkit().getImage("I.png");
            break;
            case 10: bmap = this.getToolkit().getImage("J.png");
            break;
            case 11: bmap = this.getToolkit().getImage("K.png");
            break;
            case 12: bmap = this.getToolkit().getImage("L.png");
            break;
            case 13: bmap = this.getToolkit().getImage("M.png");
            break;
            case 14: bmap = this.getToolkit().getImage("N.png");
            break;
            case 15: bmap = this.getToolkit().getImage("O.png");
            break;
            case 16: bmap = this.getToolkit().getImage("P.png");
            break;
            case 17: bmap = this.getToolkit().getImage("Q.png");
            break;
            case 18: bmap = this.getToolkit().getImage("R.png");
            break;
            case 19: bmap = this.getToolkit().getImage("S.png");
            break;
            case 20: bmap = this.getToolkit().getImage("T.png");
            break;
            case 21: bmap = this.getToolkit().getImage("U.png");
            break;
            case 22: bmap = this.getToolkit().getImage("V.png");
            break;
            case 23: bmap = this.getToolkit().getImage("W.png");
            break;
            case 24: bmap = this.getToolkit().getImage("X.png");
            break;
            case 25: bmap = this.getToolkit().getImage("Y.png");
            break;
            case 26: bmap = this.getToolkit().getImage("Z.png");
            break;
            
        }
         mtrack = new MediaTracker(this);
        mtrack.addImage(bmap, 0);
        try {
            mtrack.waitForAll();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        this.setBounds(0,0,100, 155);
    }

    public int getJuist()
    {
        return letter1;
    }
    public int getFout()
    {
        return letter2;
    }
    
   public String getLetter(int r1,int r2)
    {
        if (letter1 == r1 || letter2 == r2)
        {
            kleurTekst = "Zwart";
        }
        else
        {
            kleurTekst = "Rood";
        }
        
        return kleurTekst;
    }
       
    public void setLetter(int r1, int r2)
    {
        
        
       
       
        
    }
    
    public void paint(Graphics g) {
         //     g.fillRect(0, 0, 79, 123);
               g.drawImage(bmap,(letter1), letter2,null);
    
}    
}

