package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.stringeditbox.StringEditBox;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditPlaceholder extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");
        // panel.setStyle("padding", "10px");
        // panel.setStyle("background", "white");
        
        panel.add(new StringEditBox().setAttribute("placeholder", "Example Placeholder").setExpanse(StringEditBox.Expanse.LARGE));    

    }
    
}
    