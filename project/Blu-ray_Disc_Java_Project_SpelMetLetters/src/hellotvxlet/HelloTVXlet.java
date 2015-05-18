package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font.*;
import java.util.Timer;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.ui.DVBColor;
import org.havi.ui.event.HBackgroundImageEvent;
import java.util.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

/**
 * Just a simple xlet that draws a String in the center of the screen.
 */
public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, HActionListener {
    
    private HScreen screen;
    private int index = 1;
    private HScene scene;
    private XletContext actueleXletContext;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    
    private Random gen = new Random();
    private int r1, r2;
    private int score;
    private String l1, l2;
    
    Kaart mc;
    private Graphics g;
    
    private HTextButton knop1, knop2, knop3 ;
    
    
    private HBackgroundImage Background = new HBackgroundImage("Background.png");
    
    private HStaticText lblTitel = new HStaticText("Letterspel");
    private HStaticText lblTekst = new HStaticText("Druk op start om te beginnen");
    private HStaticText lblScore = new HStaticText("");
    
    
    public void initXlet(XletContext context) throws XletStateChangeException {
        screen = HScreen.getDefaultHScreen();
        this.actueleXletContext = context;
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        lblTitel.setLocation(155,50);
        lblTitel.setSize(400,50);
        lblTitel.setFont(new Font("Default",Font.BOLD,50));
        lblTitel.setBackground(new DVBColor(150,150,150,0));
        lblTitel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblTitel.setForeground(new DVBColor(255,240,0,255));
     
        lblTekst.setLocation(150,140);
        lblTekst.setSize(400,50);
        lblTekst.setBackground(new DVBColor(150,150,150,0));
        lblTekst.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblTekst.setForeground(Color.darkGray);
        
        lblScore.setLocation(450,5);
        lblScore.setSize(400,50);
        lblScore.setBackground(new DVBColor(150,150,150,0));
        lblScore.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblScore.setForeground(Color.darkGray);
        
      //  l1 = mc.getJuist();
        
        this.knop1 = new HTextButton("De juiste letter");    
        this.knop1.setLocation(150,400);
        this.knop1.setForeground(new DVBColor(255,240,0,255));
        this.knop1.setSize(150,70);
        this.knop1.setBackground(new DVBColor(7,102,0,180));
        this.knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
           
      //  l2 = mc.getFout();
      this.knop2 = new HTextButton("De foute letter");      
      this.knop2.setLocation(380,400);
      this.knop2.setForeground(new DVBColor(255,240,0,255));
      this.knop2.setSize(150,70);
      this.knop2.setBackground(new DVBColor(7,102,0,180));
      this.knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      this.knop3 = new HTextButton("Start");    
        this.knop3.setLocation(270,400);
        this.knop3.setForeground(new DVBColor(255,240,0,255));
        this.knop3.setSize(150,70);
        this.knop3.setBackground(new DVBColor(7,102,0,180));
        this.knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        this.knop3.setActionCommand("Start");
      
      this.knop1.addHActionListener(this);
      this.knop2.addHActionListener(this);
      this.knop3.addHActionListener(this);
      
      
      this.knop1.setFocusTraversal(knop3, knop3, knop2, knop2);
      this.knop2.setFocusTraversal(knop3, knop3, knop1, knop1);
      this.knop3.setFocusTraversal(knop1, knop1, knop1, knop2);
      
      
      this.scene.add(knop1);
      this.scene.add(knop2);
      this.scene.add(knop3);
      
      this.knop1.setVisible(false);
      this.knop2.setVisible(false);
      
      this.knop3.requestFocus();
      
        
        scene.add(lblTitel);
        scene.add(lblTekst);
        scene.add(lblScore);
        bgDevice = screen.getDefaultHBackgroundDevice();
        if(bgDevice.reserveDevice(this)) {
            System.out.println("Background image device has been reserved.");
        } else {
            System.out.println("Background image device cannot be reserved.");
        }
        bgTemplate = new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        try {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        
    }
    
   

    public void startXlet() throws XletStateChangeException {
        
        Background.load(this);
         r1 = gen.nextInt(25) + 1;
         r2 = gen.nextInt(25) + 1;
         
        this.mc=new Kaart(r1, r2);
        this.mc.setLocation(305, 225);
        this.mc.setVisible(false);
        
        this.scene.add(mc);
        
        this.scene.validate();
        this.scene.setVisible(true);
    }

    public void pauseXlet() {

    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
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
        try {
            bgConfiguration.displayImage(Background);
        } catch(Exception s) {
            System.out.println(s.toString());
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden.");
    }
    
    public void actionPerformed ( ActionEvent e )
    {
        System.out.println(e.getActionCommand());
       
        this.knop3.requestFocus();
        
        l1 = mc.getJuist();
        l2 = mc.getFout();
        
        this.knop1.setActionCommand(l1);
        this.knop2.setActionCommand(l2);
        
        if (e.getActionCommand() == "Start")
        {
            this.scene.add(knop1);
            this.scene.add(knop2);
            
            this.knop1.setTextContent(mc.getJuist(), this.knop1.NORMAL_STATE);
            this.knop1.setVisible(true);
            
            this.knop2.setTextContent(mc.getFout(), this.knop2.NORMAL_STATE);
            this.knop2.setVisible(true);
            this.knop3.setVisible(false);
            
            this.mc.setVisible(true);
            
            this.lblTekst.setTextContent("Wat is de juiste letter?", this.lblTekst.NORMAL_STATE);   
        }
        
        if (e.getActionCommand() == l1)
        {
            this.lblTekst.setTextContent("Beest", this.lblTekst.NORMAL_STATE);
            this.knop1.setVisible(false);
            this.knop2.setVisible(false);
            this.knop3.setVisible(true);
            this.knop3.requestFocus();
            
            r1 = gen.nextInt(25) + 1;
            r2 = gen.nextInt(25) + 1;
            System.out.println("random 1 = " + r1);
            
            this.scene.remove(mc);
            this.mc=new Kaart(r1, r2);
            this.mc.setLocation(305, 225);
            this.mc.setVisible(false);
            this.scene.add(mc);
            this.scene.repaint();
            score = score + 1;
        }
        
        if (e.getActionCommand() == l2)
        {
            this.lblTekst.setTextContent("Loser", this.lblTekst.NORMAL_STATE);
            this.knop1.setVisible(false);
            this.knop2.setVisible(false);
            this.knop3.setVisible(true);
            this.knop3.requestFocus();
            
            r1 = gen.nextInt(25) + 1;
            r2 = gen.nextInt(25) + 1;
            System.out.println("random 1 = " + r1);
            
            this.scene.remove(mc);
            this.mc=new Kaart(r1, r2);
            this.mc.setLocation(305, 225);
            this.mc.setVisible(false);
            this.scene.add(mc);
            this.scene.repaint();
            score = score - 1;
        }
        
        this.lblScore.setTextContent(Integer.toString(score), this.lblTekst.NORMAL_STATE); 
    }
}
