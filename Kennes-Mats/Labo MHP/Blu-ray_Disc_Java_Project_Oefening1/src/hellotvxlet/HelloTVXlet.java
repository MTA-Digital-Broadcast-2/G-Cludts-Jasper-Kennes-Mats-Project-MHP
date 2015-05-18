package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
//import java.awt.*;
import org.dvb.ui.*;

import org.havi.ui.*;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {
    

   private HTextButton knop1, knop2, knop3, knop4, HulpKnop;
    private XletContext actueleXletContext;
    private String Tekst;
    /*private boolean debug=true;*/
    
    private HStaticText tekstLabel;
    private HScene scene;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) /*throws XletStateChangeException*/ {
    /* if(debug) System.out.println("Xlet Initialiseren");*/
      this.actueleXletContext = context;
      //template aanmaken
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      
      
      //grootte en positie aangeven
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new
              HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f),
             HSceneTemplate.REQUIRED);
     
     scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
     
     tekstLabel = new HStaticText("Wie wordt multimiljonair?");
     
     tekstLabel.setLocation(40, 40);
     tekstLabel.setSize(490, 50);
     tekstLabel.setBackground(new DVBColor(0,0,0 ,179));
     tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     //toevoegen aan scene
     scene.add(tekstLabel);
     
     //knop toevoegen
     knop1 = new HTextButton("1");
     knop1.setLocation(40,100);
     knop1.setSize(100,50);
     knop1.setBackground(new DVBColor(0,0,0,179));
     knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     knop2 = new HTextButton("2");
     knop2.setLocation(170,100);
     knop2.setSize(100,50);
     knop2.setBackground(new DVBColor(0,0,0,179));
     knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     knop3 = new HTextButton("3");
     knop3.setLocation(300,100);
     knop3.setSize(100,50);
     knop3.setBackground(new DVBColor(0,0,0,179));
     knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     knop4 = new HTextButton("4");
     knop4.setLocation(430,100);
     knop4.setSize(100,50);
     knop4.setBackground(new DVBColor(0,0,0,179));
     knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     HulpKnop = new HTextButton("HELP ME");
     HulpKnop.setLocation(220,300);
     HulpKnop.setSize(100,50);
     HulpKnop.setBackground(new DVBColor(0,0,0,179));
     HulpKnop.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     knop1.setFocusTraversal(null, null, HulpKnop, knop2);
     knop2.setFocusTraversal(null, null, knop1, knop3);
     knop3.setFocusTraversal(null, null, knop2, knop4);
     knop4.setFocusTraversal(null, null, knop3, HulpKnop);
     HulpKnop.setFocusTraversal(null,null,knop4, knop1);
     
     
     scene.add(knop1);
     scene.add(knop2);
     scene.add(knop3);
     scene.add(knop4);
     scene.add(HulpKnop);
     
     knop1.requestFocus();
     
     knop1.setActionCommand("KNOP1 JUIST");
     knop2.setActionCommand("KNOP2 FOUT");
     knop3.setActionCommand("KNOP3 FOUT");
     knop4.setActionCommand("KNOP4 FOUT");
     HulpKnop.setActionCommand("Help");
     
     
     
     knop1.addHActionListener((HActionListener) this);
     knop2.addHActionListener((HActionListener) this);
     knop3.addHActionListener((HActionListener) this);
     knop4.addHActionListener((HActionListener) this);
     HulpKnop.addHActionListener((HActionListener) this);
     
    }
    
    

    public void startXlet() {
    scene.validate();
    scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent e) {
      System.out.println(e.getActionCommand());
      //Tekst = e.getActionCommand();
      
      
      if (e.getActionCommand().toString().equals("Help"))
      {
          System.out.println("Help");
          knop3.setVisible(false);
          knop4.setVisible(false);
          knop1.setBackground(new DVBColor(160,50,50,179));
          knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
         // knop1 = (HTextButton) new HStaticText("TestTest");
         
          scene.validate();
      }
      }
    }

