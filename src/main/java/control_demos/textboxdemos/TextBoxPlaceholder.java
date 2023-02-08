package control_demos.textboxdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.exceptions.DwcAppInitializeException;



public class TextBoxPlaceholder extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        TextBox t1 = new TextBox().setAttribute("Placeholder", "Example Placeholder");

        panel.add(t1);    

    }
    
}
    