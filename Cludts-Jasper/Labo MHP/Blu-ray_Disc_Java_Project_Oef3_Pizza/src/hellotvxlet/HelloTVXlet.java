package hellotvxlet;

import java.awt.*;
import java.util.*;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;

public class HelloTVXlet implements Xlet, UserEventListener {

  private Image sterren, schip;
  private int sterrenx, sterreny, schipx, schipy;
  public MijnComponent mc;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      
     HScene scene = HSceneFactory.getInstance().getDefaultHScene();
     mc = new MijnComponent();
     scene.add(mc);
     scene.validate();
     scene.setVisible(true);
     UserEventRepository uev = new UserEventRepository("Mijn verzameling");
     uev.addKey(HRcEvent.VK_LEFT);
     uev.addKey(HRcEvent.VK_RIGHT);
     
     EventManager.getInstance().addUserEventListener(this, uev);
     
     Timer t = new Timer();
     
     MijnTimerTask mtt = new MijnTimerTask();
     mtt.setCallBack(this);
     t.scheduleAtFixedRate(mtt, 0, 100);
    }

    void callback() {
        System.out.println("callback");
        mc.verplaatsSterren(0, 10);
    }
    public class MijnComponent extends HComponent {
    
        public MijnComponent() {
            
            this.setBounds(0,0,720,576);
            sterren = this.getToolkit().getImage("sterren.png");
            schip = this.getToolkit().getImage("spaceship.png");
            
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(sterren,0);
            mt.addImage(schip, 0);
            try {
                mt.waitForAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        public void verplaatsSchip(int x, int y)
        {
            schipx += x;
            schipy += y;
            this.repaint();
        }
        
        public void verplaatsSterren(int x, int y)
        {
            sterrenx += x;
            sterreny += y;
            if (sterreny > 570) sterreny -= 570;
            this.repaint();
        }
        
        public void paint (Graphics g) {
        
            g.setColor(new DVBColor(40, 0, 0, 255));
            g.drawLine(0,0,50,120);
            g.drawRect(20,20,20,20);
            
            g.drawImage(sterren, sterrenx,sterreny,this);
            g.drawImage(sterren, sterrenx,sterreny-570,this);
            
            g.drawImage(schip, schipx, 500, this);
            
        }
    }
    
    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        
        if(e.getType() == HRcEvent.KEY_PRESSED) {
            switch(e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("liinks");
                    mc.verplaatsSchip(-10, 0);
                    break;
                    
                case HRcEvent.VK_RIGHT:
                    System.out.println("REchts");
                    mc.verplaatsSchip(10, 0);
            }
        }
            }
}

