package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.stringeditbox.StringEditBox;

public class StringEditPlaceholder extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        StringEditBox s1 = new StringEditBox().setAttribute("placeholder", "Example Placeholder").setExpanse(StringEditBox.Expanse.LARGE);

        panel.add(s1);    

    }
    
}
    