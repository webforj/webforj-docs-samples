package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.stringeditbox.StringEditBox;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditExpanse extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");
        
        StringEditBox s1 = new StringEditBox().setExpanse(StringEditBox.Expanse.XSMALL).setAttribute("placeholder","XSMALL");
        StringEditBox s2 = new StringEditBox().setExpanse(StringEditBox.Expanse.SMALL).setAttribute("placeholder","SMALL");
        StringEditBox s3 = new StringEditBox().setExpanse(StringEditBox.Expanse.MEDIUM).setAttribute("placeholder","MEDIUM");
        StringEditBox s4 = new StringEditBox().setExpanse(StringEditBox.Expanse.LARGE).setAttribute("placeholder","LARGE");
        StringEditBox s5 = new StringEditBox().setExpanse(StringEditBox.Expanse.XLARGE).setAttribute("placeholder","XLARGE");

        panel.add(s1,s2,s3,s4,s5);    

    }
    
}
    