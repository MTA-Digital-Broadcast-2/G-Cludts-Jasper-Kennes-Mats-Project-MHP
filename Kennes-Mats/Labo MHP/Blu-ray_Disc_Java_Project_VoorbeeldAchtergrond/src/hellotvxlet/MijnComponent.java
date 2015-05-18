/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Graphics;
import javax.microedition.xlet.XletContext;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
    
    public MijnComponent(){
        this.setBounds(0,0,100,100);
    }
    
public void paint(Graphics g) {
    g.drawLine(0,0,200,200);
}

public void initXlet(XletContext context){
    HScene scene = HSceneFactory.getInstance().getDefaultHScene();
    MijnComponent mc = new MijnComponent();
    scene.add(mc);
    scene.validate();
    scene.setVisible(true);
    
}
}
