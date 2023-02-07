package control_demos.labeldemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.exceptions.DwcAppInitializeException;


public class LabelDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        
        Label l1 = new Label("This is a Label component, which renders as static text on a webpage");
        Label l2 = new Label("Below is an example of an HTML ordered list rendered purely using a Label control: ");
        Label l3 = new Label("<html><ol><li>My First Item</li><li>My Second Item</li><li>My Third Item</li></ol><html>");

        panel.add(l1,l2,l3);


    }
    
}
    