package control_demos.textareademos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textarea.TextArea;
import org.dwcj.exceptions.DwcAppInitializeException;



public class TextAreaLabel extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        panel.setStyle("overflow-y", "hidden");

        

        TextArea t1 = new TextArea().setAttribute("label", "Example Label").setStyle("height", "100%");

        panel.add(t1);    

    }
    
}
    