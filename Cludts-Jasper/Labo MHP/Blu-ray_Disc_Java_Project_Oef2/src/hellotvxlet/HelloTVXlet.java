package hellotvxlet;

import java.awt.*;
import java.util.*;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.davic.resources.*;
import org.dvb.event.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, ResourceClient,
    HBackgroundImageListener
{

  private HScreen screen;
  private HBackgroundDevice bgDevice;
  private HBackgroundConfigTemplate bgTemplate;
  private HStillImageBackgroundConfiguration bgConfiguration;
  private HBackgroundImage agrondimg = new HBackgroundImage("pizza1.m2v");
  private HBackgroundImage agrondimg2 = new HBackgroundImage("pizza2.m2v");
  private HBackgroundImage agrondimg3 = new HBackgroundImage("pizza3.m2v");
  private HBackgroundImage agrondimg4 = new HBackgroundImage("pizza4.m2v");
  
 public void imageLoaded(HBackgroundImageEvent e) 
 {
     try {
         bgConfiguration.displayImage(agrondimg);
     }
     catch (Exception s) {
     System.out.println(s.toString());
     }
 }
 
 public void imageLoadFailed(HBackgroundImageEvent e)
 {
     System.out.println("Image kan niet geladen worden");
 }
 
 
    public void initXlet(XletContext context) {
      // HScreen object opvragen
     screen = HScreen.getDefaultHScreen();
        
        
     // HBackgroundDevice opvragen
     bgDevice = screen.getDefaultHBackgroundDevice();
     
     // HBackgroundDevice proberen te reserveren
     if (bgDevice.reserveDevice(this)) {
     System.out.println("BackgroundImage device has been reserved");
     }
     else
     {
         System.out.println("BackgroundImage device cannot be reserved");
     }
        
     // Template maken
     bgTemplate = new HBackgroundConfigTemplate();
     
     // Configuratieinstelling "STILL_IMAGE"
     bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
     
     //configuratie aanvragen en activeren indien OK
     bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
     
     try
     {
         bgDevice.setBackgroundConfiguration(bgConfiguration);
     }
     catch (java.lang.Exception e) {
         System.out.println(e.toString());  
         }
    }
    
    public void startXlet() {
    System.out.println("start Xlet");
    
    agrondimg.load(this);
    
    }

    public void pauseXlet() {
     System.out.println("pauseXlet");
    }

    public void destroyXlet(boolean unconditional) {
     System.out.println("destroyXlet");
     agrondimg.flush();
    }


    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        return false;
    }

    public void release(ResourceProxy proxy) {
        
    }

    public void notifyRelease(ResourceProxy proxy) {
        
    }
}


