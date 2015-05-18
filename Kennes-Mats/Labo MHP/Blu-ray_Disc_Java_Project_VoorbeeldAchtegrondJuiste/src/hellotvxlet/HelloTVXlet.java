package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.event.UserEvent;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.EventManager;
import org.havi.ui.event.*;
import org.havi.ui.event.HActionListener;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;



  
public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {
         
private HScreen screen;
private HBackgroundDevice bgDevice;
private HBackgroundConfigTemplate bgTemplate;
private HStillImageBackgroundConfiguration bgConfiguration;
private HBackgroundImage agrondimg = new HBackgroundImage("pizza1.m2v");
private HBackgroundImage agrondimg2 = new HBackgroundImage("pizza2.m2v");
private HBackgroundImage agrondimg3 = new HBackgroundImage("pizza3.m2v");
private HBackgroundImage agrondimg4 = new HBackgroundImage("pizza4.m2v");


public void notifyRelease(ResourceProxy proxy) {}
public void release(ResourceProxy proxy) {}
public boolean requestRelease(ResourceProxy proxy, Object requestData) {
    return false;
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


    public void destroyXlet(boolean unconditional)  {
        System.out.println("DestroyXlet");
        agrondimg.flush();
    }

    public void pauseXlet() {
      System.out.println("PauseXlet");
    }

    public void startXlet() {
        System.out.println("StartXlet");
        //image laden
        agrondimg.load(this);
    }



   public HelloTVXlet() {  }

    public void initXlet(XletContext context) {
        //HScreen object opvragen
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
      
      
      UserEventRepository uev = new UserEventRepository("mijn verzameling");
    uev.addKey(HRcEvent.VK_LEFT);
    uev.addKey(HRcEvent.VK_RIGHT);
      EventManager.getInstance().addUserEventListener(this, uev);
    }
    
    
    public void actionPerformed(ActionEvent e) {
      System.out.println(e.getActionCommand());
      //Tekst = e.getActionCommand();
  
      if (e.getActionCommand().toString().equals("Help"))
      {
          System.out.println("Help");
         
         // knop1 = (HTextButton) new HStaticText("TestTest");
         
          //scene.validate();
      }
      }

  public void userEventReceived(UserEvent e) {
        
        
        if (e.getType()==HRcEvent.KEY_PRESSED) { 
            //enkel indrukken (niet loslaten)
            switch (e.getCode())
            {
                case HRcEvent.VK_LEFT:
                System.out.println("Links");
               try {
        bgConfiguration.displayImage(agrondimg2);
        agrondimg2.load(this);
    }
    catch(Exception s){
        System.out.println(s.toString());
    }
                break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("Rechts");
                   
                    break;
                  /*  case HRcEvent.VK_DOWN:
                    System.out.println("Onder");
                    mc.verplaatssterren(0,10);
                    break;*/
            }
        }
        

   

    
}
}
