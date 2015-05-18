package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Timer;
import java.util.TimerTask;
import javax.tv.xlet.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.event.HRcEvent;



public class HelloTVXlet extends HComponent implements Xlet, UserEventListener  {

  private Image sterren, schip;
  int sterrenx=0, sterreny= 10;
  int schipx= 150, schipy=500;
  MijnComponent mc;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
       HScene scene = HSceneFactory.getInstance().getDefaultHScene();
    mc = new MijnComponent();
    scene.add(mc);
    scene.validate();
    scene.setVisible(true);
    UserEventRepository uev = new UserEventRepository("mijn verzameling");
    uev.addKey(HRcEvent.VK_LEFT);
    uev.addKey(HRcEvent.VK_RIGHT);
    
    
    EventManager.getInstance().addUserEventListener(this, uev);
    
    Timer t = new Timer();
    MijnTimerTask mtt = new MijnTimerTask();
    mtt.setCallBack(this);
    t.scheduleAtFixedRate(mtt, 0 , 100);
    
    }

    void callback() {
       mc.verplaatssterren(0,3);
    }
    
    
    
    public class MijnComponent extends HComponent{
    
        public class MijnTimerTask extends TimerTask {
            
            public void run() {
                //timer wordt hier uitgevoerd
                System.out.println("timer tick");
            }
        }
        
    public MijnComponent(){
       
        this.setBounds(0,0,720,576);
        sterren = this.getToolkit().getImage("sterren.png");
        schip = this.getToolkit().getImage("spaceship.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(sterren, 0);
        mt.addImage(schip ,0);
            try {

                mt.waitForAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
       
        }
        
    
    
    public void verplaatssterren(int x, int y)
    {
        sterrenx+= x;
        sterreny+= y;
        if(sterreny>570){
            sterreny-=570;
        }
        this.repaint();
        
    }
    
     public void verplaatsSchip(int x, int y)
    {
        schipx+= x;
        schipy+= y;
       /* if(sterreny>570){
            sterreny-=570;
        }*/
        this.repaint();
        
    }
    
    
public void paint(Graphics g) {
    g.setColor(new DVBColor(40,0,0,255));
    g.drawLine(0,0,50,120);
    g.drawRect(20, 20, 20, 20);
    g.drawString("TestTestTest", 20, 100);
    g.drawImage(sterren,sterrenx,sterreny,this);
    g.drawImage(sterren,sterrenx,sterreny-570, this);
    g.drawImage(schip, schipx,schipy,this);
    
   // g.drawString("Testfdkdfksfdkdkfsdk",)
    
}

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }



    public void userEventReceived(UserEvent e) {
        
        
        if (e.getType()==HRcEvent.KEY_PRESSED) { 
            //enkel indrukken (niet loslaten)
            switch (e.getCode())
            {
                case HRcEvent.VK_LEFT:
                System.out.println("Links");
                mc.verplaatsSchip(-10,0);
                break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("Rechts");
                    mc.verplaatsSchip(10,0);
                    break;
                  /*  case HRcEvent.VK_DOWN:
                    System.out.println("Onder");
                    mc.verplaatssterren(0,10);
                    break;*/
            }
        }
        
    }
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startXlet() throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

