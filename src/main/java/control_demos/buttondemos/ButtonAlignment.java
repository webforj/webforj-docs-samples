package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.Button.TextVerticalAlignment;
import org.dwcj.controls.button.events.ButtonClickEvent;

import org.dwcj.exceptions.DwcAppInitializeException;


public class ButtonAlignment extends App{
    
    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 1fr 1fr");
        panel.setStyle("gap", "20px");
        panel.setStyle("border", "1px dotted");
        panel.setStyle("padding", "10px");

        Button buttonTop = new Button("TOP ALIGNMENT");
        Button buttonCenter = new Button("CENTER ALIGNMENT");
        Button buttonBottom = new Button("BOTTOM ALIGNMENT");

        panel.add(buttonTop,buttonCenter,buttonBottom);

        buttonTop.setStyle("grid-column", "1");
        buttonTop.setStyle("width", "100%");
        buttonTop.setStyle("height", "75px");
        buttonTop.setTheme(Button.Theme.DEFAULT).setVerticalAlignment(TextVerticalAlignment.TOP);
        buttonCenter.setStyle("grid-column", "2");
        buttonCenter.setStyle("width", "100%");
        buttonCenter.setStyle("height", "75px");
        buttonCenter.setTheme(Button.Theme.DEFAULT).setVerticalAlignment(TextVerticalAlignment.CENTER);
        buttonBottom.setStyle("grid-column", "3");
        buttonBottom.setStyle("width", "100%");
        buttonBottom.setStyle("height", "75px");
        buttonBottom.setTheme(Button.Theme.DEFAULT).setVerticalAlignment(TextVerticalAlignment.BOTTOM);
    } 


}
