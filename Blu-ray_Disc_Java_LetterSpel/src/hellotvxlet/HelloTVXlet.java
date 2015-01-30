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



public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {
        private HScreen screen;
        private HBackgroundDevice bgDevice;
        private HBackgroundConfigTemplate bgTemplate;
        private HStillImageBackgroundConfiguration bgConfiguration;
        private HBackgroundImage agrondimg = new HBackgroundImage("bg.png");
  
    public HelloTVXlet() {
       
    }

     public void destroyXlet(boolean unconditional)  {
        System.out.println("DestroyXlet");
        agrondimg.flush();
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
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

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     public void startXlet() {
        System.out.println("StartXlet");
        //image laden
        agrondimg.load(this);
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
