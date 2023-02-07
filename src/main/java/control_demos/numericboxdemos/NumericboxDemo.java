package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.numericbox.NumericBox;


public class NumericboxDemo extends App{

    NumericBox nb;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        nb = new NumericBox();

        panel.add(nb);

        nb.setAttribute("show-spinners", "true");


    }
    
}
    