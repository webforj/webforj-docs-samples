package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

public class ButtonIcon extends App {
    


    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 1fr 1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        
        Button b1 = new Button ("<html><bbj-icon name=\"alien\"></bbj-icon> Icon Left</html>");
        panel.add(b1);
        Button b2= new Button ("<html>Icon Right <bbj-icon name=\"alien\"></bbj-icon></html>");
        panel.add(b2);
        Button b3 = new Button ("<html><bbj-icon name=\"alien\"></bbj-icon></html>");
        panel.add(b3);


    }
    
}
