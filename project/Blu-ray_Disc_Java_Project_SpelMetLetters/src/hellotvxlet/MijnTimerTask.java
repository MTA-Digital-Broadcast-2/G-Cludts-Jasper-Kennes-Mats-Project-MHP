package hellotvxlet;

import java.util.TimerTask;

public class MijnTimerTask extends TimerTask {
    
    private Kaart mc;
    
    public void run() {
        mc.setBounds(mc.getX() + 1, mc.getY(), mc.getHeight(), mc.getWidth());
    }
    
    public void setComponent(Kaart mc) {
        this.mc = mc;
    }
    
    public Kaart getComponent() {
        return this.mc;
    }
    
}
