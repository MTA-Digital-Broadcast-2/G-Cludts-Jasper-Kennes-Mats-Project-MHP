package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, HActionListener {

    
    private XletContext actueleXletContext;
    private HScene scene;
    
    //debuggen activeren of niet?
    private boolean debug=true;
    
    private HTextButton knop1, knop2, knop3, knop4;
    private HStaticText label1, label2;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException {
      
     if (debug) System.out.println("Xlet Initialiseren");
     this.actueleXletContext = context;
     
     //template aanmaken
     HSceneTemplate sceneTemplate = new HSceneTemplate();
     
     //grootte en positie aangeven
     
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
             new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
     
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
             new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
     
     //een instantie van de scene aanvragen aan de factory.
     scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        label1 = new HStaticText("Wie wordt multimilionair");
        label1.setLocation(100, 50);
        label1.setSize(300, 50);
        label1.setBackground(new DVBColor(0,0,0,179));
        label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        label2 = new HStaticText("");
        label2.setLocation(100, 150);
        label2.setSize(300, 50);
        label2.setBackground(new DVBColor(0,0,0,179));
        label2.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
        knop1 = new HTextButton("Jasper");
        knop1.setLocation(100, 100);
        knop1.setSize(100, 50);
        knop1.setBackground(new DVBColor(0,0,0,179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);

        knop2 = new HTextButton("Mats");
        knop2.setLocation(200, 100);
        knop2.setSize(100, 50);
        knop2.setBackground(new DVBColor(0,0,0,179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
        knop3 = new HTextButton("Dieter");
        knop3.setLocation(300, 100);
        knop3.setSize(100, 50);
        knop3.setBackground(new DVBColor(0,0,0,179));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
        knop4 = new HTextButton("Jonah");
        knop4.setLocation(400, 100);
        knop4.setSize(100, 50);
        knop4.setBackground(new DVBColor(0,0,0,179));
        knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);

      //het veranderen van de gelesecteerde knop (op, neer, links, rechts)
      
      knop1.setFocusTraversal(null, null, knop4, knop2);
      knop2.setFocusTraversal(null, null, knop1, knop3);
      knop3.setFocusTraversal(null, null, knop2, knop4);
      knop4.setFocusTraversal(null, null, knop3, knop1);
      
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      scene.add(label1);
      scene.add(label2);
      
      knop1.requestFocus();
      
      knop1.setActionCommand("Jasper");
      knop2.setActionCommand("Mats");
      knop3.setActionCommand("Dieter");
      knop4.setActionCommand("Jonah");
      
      knop1.addHActionListener((HActionListener) this);
      knop2.addHActionListener((HActionListener) this);
      knop3.addHActionListener((HActionListener) this);
      knop4.addHActionListener((HActionListener) this);
      
    }

    public void startXlet() throws XletStateChangeException {
    
        if(debug) System.out.println("Xlet Starten");
        //Scene zichtbaar maken
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
     
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        
        if (e.getActionCommand().toString().equals("Jasper"))
        {
            label2 = new HStaticText("Juist");
        }
        }
    }
