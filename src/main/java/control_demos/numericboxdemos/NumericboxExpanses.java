package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.numericbox.NumericBox;

@InlineStyleSheet("context://css/numericboxstyles/expanse_styles.css")
public class NumericboxExpanses extends App{

    

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        Div container = new Div();

        panel.add(container);
        panel.addClassName("appPanel");
        container.addClassName("container");
        

        NumericBox nb1 = new NumericBox().setExpanse(NumericBox.Expanse.XSMALL).setAttribute("label", "Extra Small").setStyle("grid-column", "1");
        NumericBox nb2 = new NumericBox().setExpanse(NumericBox.Expanse.SMALL).setAttribute("label", "Small").setStyle("grid-column", "2");
        NumericBox nb3 = new NumericBox().setExpanse(NumericBox.Expanse.MEDIUM).setAttribute("label", "Medium").setStyle("grid-column", "3");
        NumericBox nb4 = new NumericBox().setExpanse(NumericBox.Expanse.LARGE).setAttribute("label", "Large").setStyle("grid-column", "4");
        NumericBox nb5 = new NumericBox().setExpanse(NumericBox.Expanse.XLARGE).setAttribute("label", "Extra Large").setStyle("grid-column", "5");

        container.add(nb1,nb2,nb3,nb4,nb5);


    }
    
}
    