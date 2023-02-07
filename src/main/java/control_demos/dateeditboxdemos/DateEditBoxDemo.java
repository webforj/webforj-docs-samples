package control_demos.dateeditboxdemos;

import org.dwcj.App;
import org.dwcj.controls.dateeditbox.DateEditBox;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;


public class DateEditBoxDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        DateEditBox d1 = new DateEditBox();

        panel.add(d1);

        d1.setAttribute("visible-calender-icon", "true");

        

    }
    
}
    