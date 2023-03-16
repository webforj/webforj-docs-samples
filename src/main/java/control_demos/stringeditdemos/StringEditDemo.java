package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.stringeditbox.StringEditBox;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        StringEditBox s1 = new StringEditBox();
        panel.add(s1);    
    }
    
}
    