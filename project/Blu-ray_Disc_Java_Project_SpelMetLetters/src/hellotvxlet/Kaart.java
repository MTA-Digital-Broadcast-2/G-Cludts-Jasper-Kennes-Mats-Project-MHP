package hellotvxlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import org.havi.ui.*;

public class Kaart extends HComponent {
    private Image bmap;
    private MediaTracker mtrack;
    public int letter1;
    public int letter2; 
    public String kleurTekst;
    public String letterJuist, letterFout;
    public Kaart(int r1, int r2) {
        
        letter1=r1;
        letter2=r2;
        
        //juiste letterselectie
        switch(letter1) {
        
            case 1: bmap = this.getToolkit().getImage("A.png");
            letterJuist = "A";
            break;
            case 2: bmap = this.getToolkit().getImage("B.png");
            letterJuist = "B";
            break;
            case 3: bmap = this.getToolkit().getImage("C.png");
            letterJuist = "C";
            break;
            case 4: bmap = this.getToolkit().getImage("D.png");
            letterJuist = "D";
            break;
            case 5: bmap = this.getToolkit().getImage("E.png");
            letterJuist = "E";
            break;
            case 6: bmap = this.getToolkit().getImage("F.png");
            letterJuist = "F";
            break;
            case 7: bmap = this.getToolkit().getImage("G.png");
            letterJuist = "G";
            break;
            case 8: bmap = this.getToolkit().getImage("H.png");
            letterJuist = "H";
            break;
            case 9: bmap = this.getToolkit().getImage("I.png");
            letterJuist = "I";
            break;
            case 10: bmap = this.getToolkit().getImage("J.png");
            letterJuist = "J";
            break;
            case 11: bmap = this.getToolkit().getImage("K.png");
            letterJuist = "K";
            break;
            case 12: bmap = this.getToolkit().getImage("L.png");
            letterJuist = "L";
            break;
            case 13: bmap = this.getToolkit().getImage("M.png");
            letterJuist = "M";
            break;
            case 14: bmap = this.getToolkit().getImage("N.png");
            letterJuist = "N";
            break;
            case 15: bmap = this.getToolkit().getImage("O.png");
            letterJuist = "O";
            break;
            case 16: bmap = this.getToolkit().getImage("P.png");
            letterJuist = "P";
            break;
            case 17: bmap = this.getToolkit().getImage("Q.png");
            letterJuist = "Q";
            break;
            case 18: bmap = this.getToolkit().getImage("R.png");
            letterJuist = "R";
            break;
            case 19: bmap = this.getToolkit().getImage("S.png");
            letterJuist = "S";
            break;
            case 20: bmap = this.getToolkit().getImage("T.png");
            letterJuist = "T";
            break;
            case 21: bmap = this.getToolkit().getImage("U.png");
            letterJuist = "U";
            break;
            case 22: bmap = this.getToolkit().getImage("V.png");
            letterJuist = "V";
            break;
            case 23: bmap = this.getToolkit().getImage("W.png");
            letterJuist = "W";
            break;
            case 24: bmap = this.getToolkit().getImage("X.png");
            letterJuist = "X";
            break;
            case 25: bmap = this.getToolkit().getImage("Y.png");
            letterJuist = "Y";
            break;
            case 26: bmap = this.getToolkit().getImage("Z.png");
            letterJuist = "Z";
            break;
        }
            //foute letterselectie
            switch(letter2) {
        
            case 1: 
            letterFout = "A";
            break;
            case 2:
            letterFout = "B";
            break;
            case 3:
            letterFout = "C";
            break;
            case 4:
            letterFout = "D";
            break;
            case 5:
            letterFout = "E";
            break;
            case 6:
            letterFout = "F";
            break;
            case 7:
            letterFout = "G";
            break;
            case 8:
            letterFout = "H";
            break;
            case 9:
            letterFout = "I";
            break;
            case 10:
            letterFout = "J";
            break;
            case 11:
            letterFout = "K";
            break;
            case 12:
            letterFout = "L";
            break;
            case 13:
            letterFout = "M";
            break;
            case 14:
            letterFout = "N";
            break;
            case 15:
            letterFout = "O";
            break;
            case 16:
            letterFout = "P";
            break;
            case 17:
            letterFout = "Q";
            break;
            case 18:
            letterFout = "R";
            break;
            case 19:
            letterFout = "S";
            break;
            case 20:
            letterFout = "T";
            break;
            case 21:
            letterFout = "U";
            break;
            case 22:
            letterFout = "V";
            break;
            case 23:
            letterFout = "W";
            break;
            case 24:
            letterFout = "X";
            break;
            case 25:
            letterFout = "Y";
            break;
            case 26:
            letterFout = "Z";
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
    
    public String getJuist()
    {
        return letterJuist;
    }
    public String getFout()
    {
        return letterFout;
    }
    
    public void paint(Graphics g) {
         //     g.fillRect(0, 0, 79, 123);
               g.drawImage(bmap,(letter1), letter2,null);
    
}    
}

