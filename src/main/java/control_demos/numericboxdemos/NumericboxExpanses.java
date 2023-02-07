package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.numericbox.NumericBox;


public class NumericboxExpanses extends App{

    

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        
        Div container = new Div();
        panel.add(container);
        container.setStyle("display", "inline-grid");
        container.setStyle("padding", "10px");
        container.setStyle("gap", "50px");
        container.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr 1fr");
        container.setStyle("overflow", "auto");
        

        NumericBox nb1 = new NumericBox();
        NumericBox nb2 = new NumericBox();
        NumericBox nb3 = new NumericBox();
        NumericBox nb4 = new NumericBox();
        NumericBox nb5 = new NumericBox();

        nb1.setExpanse(NumericBox.Expanse.XSMALL).setAttribute("label", "Extra Small").setStyle("grid-column", "1");
        nb2.setExpanse(NumericBox.Expanse.SMALL).setAttribute("label", "Small").setStyle("grid-column", "2");
        nb3.setExpanse(NumericBox.Expanse.MEDIUM).setAttribute("label", "Medium").setStyle("grid-column", "3");
        nb4.setExpanse(NumericBox.Expanse.LARGE).setAttribute("label", "Large").setStyle("grid-column", "4");
        nb5.setExpanse(NumericBox.Expanse.XLARGE).setAttribute("label", "Extra Large").setStyle("grid-column", "5");

        container.add(nb1,nb2,nb3,nb4,nb5);


    }
    
}
    