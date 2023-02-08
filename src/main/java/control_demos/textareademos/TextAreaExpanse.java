package control_demos.textareademos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.textarea.TextArea;

public class TextAreaExpanse extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "flex");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        TextArea t1 = new TextArea().setExpanse(TextArea.Expanse.XSMALL).setAttribute("placeholder","XSMALL");
        TextArea t2 = new TextArea().setExpanse(TextArea.Expanse.SMALL).setAttribute("placeholder","SMALL");
        TextArea t3 = new TextArea().setExpanse(TextArea.Expanse.MEDIUM).setAttribute("placeholder","MEDIUM");
        TextArea t4 = new TextArea().setExpanse(TextArea.Expanse.LARGE).setAttribute("placeholder","LARGE");
        TextArea t5 = new TextArea().setExpanse(TextArea.Expanse.XLARGE).setAttribute("placeholder","XLARGE");

        panel.add(t1,t2,t3,t4,t5);    

    }
    
}
    