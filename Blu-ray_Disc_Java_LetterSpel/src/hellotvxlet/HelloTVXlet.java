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
import org.havi.ui.HSceneTemplate;
import org.havi.ui.HScreenDimension;
import org.havi.ui.HScreenPoint;
import org.havi.ui.event.HRcEvent;
import java.util.Random;




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
        

        //Scene maken
        HScene scene;
        //Template Maken
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        
        
  
    public HelloTVXlet() {
       
        //Grootte en positie ingeven
        sceneTemplate.setPreference( org.havi.ui.HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), org.havi.ui.HSceneTemplate.REQUIRED);
        
        sceneTemplate.setPreference(org.havi.ui.HSceneTemplate.SCENE_SCREEN_LOCATION,new HScreenPoint(1.0f, 1.0f) , org.havi.ui.HSceneTemplate.REQUIRED);
        
        //Een instantie van een Scene vragen aan de factory
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        //scene zichtbaar maken
        scene.validate(); scene.setVisible(true);
    }

     public void destroyXlet(boolean unconditional)  {
        System.out.println("DestroyXlet");
        agrondimg.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
          scene = HSceneFactory.getInstance().getDefaultHScene();
          mc = new MijnLetterComponent();
          scene.add(mc);
          scene.validate();
          scene.setVisible(true);
          UserEventRepository uev = new UserEventRepository("mijn verzameling");
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
      
      //random generator
      Random randomCreator = new Random();
      int randomInt = randomCreator.nextInt(26);
      System.out.println(randomInt);
      
      //Image lettertje = new Image(randomInt + ".png");
      //scene.add(lettertje);
      scene.validate();
      
      //HIER IS NOG WERK AAN
      String letter = null;
      
      for (int i=0; i<26; i++)
      {
        MijnLetterComponent letters = new MijnLetterComponent(letter, 0, 0, i);
      }
    }
    
     public class MijnLetterComponent extends HComponent{
         
         private Image bmap;
         private MediaTracker mtrack;
         public MijnLetterComponent()
         {
             
         }
         //Plaats en locatie instellen in de constructor
         public MijnLetterComponent(String bitmapnaam, int x, int y, int teller)
         {
         bmap = this.getToolkit().getImage(bitmapnaam);
         mtrack = new MediaTracker(this);
         mtrack.addImage(bmap, teller);
         
         try
         {
             mtrack.waitForAll();
         }
         catch (Exception e)
         {
             System.out.println(e.toString());
         }
         this.setBounds(x, y, bmap.getWidth(null), bmap.getWidth(null));
         }
         
         public void paint(Graphics g)
         {
             g.drawImage(bmap, 0, 0, null);
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
