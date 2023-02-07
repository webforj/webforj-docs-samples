package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;

import org.dwcj.exceptions.DwcAppInitializeException;


public class ButtonDisable extends App {

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "block");
        panel.setStyle("padding", "10px");

        Div disabled = new Div();
        disabled.setId("disabledButtons");
        panel.add(disabled);

        disabled.setStyle("display", "inline-grid");
        
        disabled.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr");
        disabled.setStyle("gap", "20px");
        disabled.setStyle("border", "1px dotted");
        disabled.setStyle("padding", "10px");

        Button buttonTop = new Button("DEFAULT DISABLED");
        Button buttonCenter = new Button("PRIMARY DISABLED");
        Button buttonBottom = new Button("SUCCESS DISABLED");
        Button buttonTop2 = new Button("DEFAULT");
        Button buttonCenter2 = new Button("PRIMARY");
        Button buttonBottom2 = new Button("SUCCESS");
        Button buttonDisable = new Button("Push To Disable!");

        disabled.add(buttonTop2,buttonCenter2,buttonBottom2,buttonTop,buttonCenter,buttonBottom, buttonDisable);

        buttonTop.setStyle("grid-column", "1");
        buttonTop.setStyle("width", "100%");
        buttonTop.setTheme(Button.Theme.DEFAULT);
        buttonTop2.setStyle("grid-column", "1");
        buttonTop2.setStyle("width", "100%");
        buttonTop2.setTheme(Button.Theme.DEFAULT);
        buttonCenter.setStyle("grid-column", "2");
        buttonCenter.setStyle("width", "100%");
        buttonCenter.setTheme(Button.Theme.PRIMARY);
        buttonCenter2.setStyle("grid-column", "2");
        buttonCenter2.setStyle("width", "100%");
        buttonCenter2.setTheme(Button.Theme.PRIMARY);
        buttonBottom.setStyle("grid-column", "3");
        buttonBottom.setStyle("width", "100%");
        buttonBottom.setTheme(Button.Theme.SUCCESS);
        buttonBottom2.setStyle("grid-column", "3");
        buttonBottom2.setStyle("width", "100%");
        buttonBottom2.setTheme(Button.Theme.SUCCESS);
        buttonDisable.setStyle("grid-column", "4");
        buttonDisable.setStyle("width", "100%");
        buttonDisable.setTheme(Button.Theme.DANGER);

        buttonTop.setEnabled(false);
        buttonCenter.setEnabled(false);
        buttonBottom.setEnabled(false);
        buttonDisable.setDisableOnClick(true);        
    } 
}
