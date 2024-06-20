import java.awt.*;
import java.awt.event.*;

class CloseFrame extends Frame implements WindowListener {
    Label label;
    
    CloseFrame(String title) {
        super(title);
        label = new Label("Close the frame.");
        this.addWindowListener(this);
    }
    
    void launchFrame() {
        setSize(300, 300);
        setVisible(true);
    }
    
    public void windowActivated(WindowEvent e) {}
    
    public void windowClosed(WindowEvent e) {}
    
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        System.exit(0);
    }
    
    public void windowDeactivated(WindowEvent e) {}
    
    public void windowDeiconified(WindowEvent e) {}
    
    public void windowIconified(WindowEvent e) {}
    
    public void windowOpened(WindowEvent e) {}
    
    public static void main(String args[]) {
        CloseFrame cf = new CloseFrame("Close Window Example");
        cf.launchFrame();
    }
}
