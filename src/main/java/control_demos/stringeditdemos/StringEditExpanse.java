package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.stringeditbox.StringEditBox;

public class StringEditExpanse extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "flex");
        // panel.setStyle("flex-dir", "flex");
        // panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        StringEditBox s1 = new StringEditBox().setExpanse(StringEditBox.Expanse.XSMALL).setAttribute("placeholder","XSMALL");
        StringEditBox s2 = new StringEditBox().setExpanse(StringEditBox.Expanse.SMALL).setAttribute("placeholder","SMALL");
        StringEditBox s3 = new StringEditBox().setExpanse(StringEditBox.Expanse.MEDIUM).setAttribute("placeholder","MEDIUM");
        StringEditBox s4 = new StringEditBox().setExpanse(StringEditBox.Expanse.LARGE).setAttribute("placeholder","LARGE");
        StringEditBox s5 = new StringEditBox().setExpanse(StringEditBox.Expanse.XLARGE).setAttribute("placeholder","XLARGE");

        panel.add(s1,s2,s3,s4,s5);    

    }
    
}
    