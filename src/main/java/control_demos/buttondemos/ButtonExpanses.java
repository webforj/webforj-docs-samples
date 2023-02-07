package control_demos.buttondemos;
import org.dwcj.App;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;

import org.dwcj.exceptions.DwcAppInitializeException;


public class ButtonExpanses extends App {
    
    private TextBox edFirstname;
    private TextBox edLastname;

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");

        Div buttonExpanses = new Div();

        buttonExpanses.setId("buttonExpanses");
        panel.add(buttonExpanses);
        buttonExpanses.setStyle("display", "inline-grid");
        buttonExpanses.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr 1fr");
        buttonExpanses.setStyle("gap", "20px");
        buttonExpanses.setStyle("border", "1px dotted");
        buttonExpanses.setStyle("padding", "10px");
        buttonExpanses.setStyle("align-items", "center");

        Button be1 = new Button("XSMALL").setExpanse(Button.Expanse.XSMALL).setStyle("width", "100%").setStyle("grid-column", "1");
        Button be2 = new Button("SMALL").setExpanse(Button.Expanse.SMALL).setStyle("width", "100%").setStyle("grid-column", "2");
        Button be3 = new Button("MEDIUM").setExpanse(Button.Expanse.MEDIUM).setStyle("width", "100%").setStyle("grid-column", "3");
        Button be4 = new Button("LARGE").setExpanse(Button.Expanse.LARGE).setStyle("width", "100%").setStyle("grid-column", "4");
        Button be5 = new Button("XLARGE").setExpanse(Button.Expanse.XLARGE).setStyle("width", "100%").setStyle("grid-column", "5");

        buttonExpanses.add(be1,be2,be3,be4,be5);
                        

        
    }
        

}
