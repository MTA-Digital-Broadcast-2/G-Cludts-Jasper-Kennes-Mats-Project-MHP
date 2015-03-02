package hellotvxlet;

import javax.tv.xlet.*;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HScreen;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import hellotvxlet.Letters;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import java.util.Timer;
import java.util.TimerTask;
import org.dvb.event.EventManager;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.event.HRcEvent;





public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {
    
        private HScreen screen;
        private HBackgroundDevice bgDevice;
        private HBackgroundConfigTemplate bgTemplate;
        private HStillImageBackgroundConfiguration bgConfiguration;
        private HBackgroundImage agrondimg = new HBackgroundImage("bg.png");
        private Image[] arrGLetters = new Image[26];
        private Image[] arrKLetters = new Image[26];
        private Image pic;
        MijnLetterComponent mc;
  
    public HelloTVXlet() {
       
    }

     public void destroyXlet(boolean unconditional)  {
        System.out.println("DestroyXlet");
        agrondimg.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
       /* for (int i=0; i<arrGLetters.length; i++){
          pic = p.getToolkit();
           
            arrGLetters[i] = pic;
        }*/
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
          mc = new MijnLetterComponent();
           scene.add(mc);
            scene.validate();
            scene.setVisible(true);
            UserEventRepository uev = new UserEventRepository("mijn verzameling");
        
       // Letters.Test();
        screen = HScreen.getDefaultHScreen();
      
      //HBGDevice opvragen
      bgDevice = screen.getDefaultHBackgroundDevice();
      
      //HBGDevice proberen te reserveren
      if (bgDevice.reserveDevice(this)){
          System.out.println("Background device has been reserved");
      }
      else {
          System.out.println("Background image device cannot be reserved");
      }
      
      //template maken
      bgTemplate = new HBackgroundConfigTemplate();
      
      //CFGinstelling "STILL_IMAGE"
      bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
      
      //CFG aanvragen en activeren indien OK
      bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
      try {
          bgDevice.setBackgroundConfiguration(bgConfiguration);
      }
      catch (java.lang.Exception e){
          System.out.println(e.toString());
      }
      
    }
    
     public class MijnLetterComponent extends HComponent{
    
        public class MijnTimerTask extends TimerTask {
            
            public void run() {
                //timer wordt hier uitgevoerd
                System.out.println("timer tick");
            }
        }
        
    public MijnLetterComponent(){
       
        this.setBounds(0,0,720,576);
        pic = this.getToolkit().getImage("1.png");
        //schip = this.getToolkit().getImage("spaceship.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(pic, 0);
       
            try {

                mt.waitForAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
       
        }

    
    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     public void startXlet() {
        System.out.println("StartXlet");
        //image laden
        agrondimg.load((HBackgroundImageListener) this);
        //DIT IS FOUT

    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   public void imageLoaded(HBackgroundImageEvent e)
{
    try {
        bgConfiguration.displayImage(agrondimg);
    }
    catch(Exception s){
        System.out.println(s.toString());
    }
}

   public void imageLoadFailed(HBackgroundImageEvent e)
{
    System.out.println("Image kan niet geladen worden.");
}
   
    public void userEventReceived(UserEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    
    
}

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startXlet() throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }}
