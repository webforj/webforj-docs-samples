package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.numericbox.NumericBox;

@InlineStyleSheet("context://css/numericboxstyles/placeholder_styles.css")
public class NumericboxPlaceholder extends App{

    NumericBox nb;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");
        nb = new NumericBox();
        panel.add(nb);
        nb.setAttribute("placeholder", "Example placeholder");
    }
    
}
    