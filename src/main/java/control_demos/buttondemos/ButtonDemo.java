package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;

import org.dwcj.exceptions.DwcAppInitializeException;


public class ButtonDemo extends App {
    
    private TextBox edFirstname;
    private TextBox edLastname;

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");


        Div buttonThemes = new Div();
        buttonThemes.setId("buttonThemes");
        panel.add(buttonThemes);
        buttonThemes.setStyle("display", "inline-grid");
        buttonThemes.setStyle("grid-template-columns", "1fr 1fr 1fr 1fr 1fr 1fr 1fr");
        buttonThemes.setStyle("gap", "20px");
        buttonThemes.setStyle("border", "1px dotted");
        buttonThemes.setStyle("padding", "10px");
        buttonThemes.setStyle("overflow", "auto");



        Button b1 = new Button("DEFAULT");
        buttonThemes.add(b1);
        b1.setTheme(Button.Theme.DEFAULT);

        Button b2 = new Button("DANGER");
        buttonThemes.add(b2);
        b2.setTheme(Button.Theme.DANGER);
        Button b3 = new Button("GRAY").setTheme(Button.Theme.GRAY);
        Button b4 = new Button("INFO").setTheme(Button.Theme.INFO);
        Button b5 = new Button("PRIMARY").setTheme(Button.Theme.PRIMARY);
        Button b6 = new Button("SUCCESS").setTheme(Button.Theme.SUCCESS);
        Button b7 = new Button("WARNING").setTheme(Button.Theme.WARNING);
        Button b8 = new Button("OUTLINED DEFAULT").setTheme(Button.Theme.OUTLINED_DEFAULT);
        Button b9 = new Button("OUTLINED DANGER").setTheme(Button.Theme.OUTLINED_DANGER);
        Button b10 = new Button("OUTLINED GRAY").setTheme(Button.Theme.OUTLINED_GRAY);
        Button b11 = new Button("OUTLINED INFO").setTheme(Button.Theme.OUTLINED_INFO);
        Button b12 = new Button("OUTLINED PRIMARY").setTheme(Button.Theme.OUTLINED_PRIMARY);
        Button b13 = new Button("OUTLINED SUCCESS").setTheme(Button.Theme.OUTLINED_SUCCESS);
        Button b14 = new Button("OUTLINED WARNING").setTheme(Button.Theme.OUTLINED_WARNING);

        buttonThemes.add(b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14);
        
        b1.setStyle("grid-column", "1");
        b1.setStyle("width", "100%");
        b2.setStyle("grid-column", "2");
        b2.setStyle("width", "100%");
        b3.setStyle("grid-column", "3"); 
        b4.setStyle("grid-column", "4"); 
        b5.setStyle("grid-column", "5"); 
        b6.setStyle("grid-column", "6"); 
        b7.setStyle("grid-column", "7"); 
        b8.setStyle("grid-column", "1"); 
        b9.setStyle("grid-column", "2"); 
        b10.setStyle("grid-column", "3");
        b11.setStyle("grid-column", "4");
        b12.setStyle("grid-column", "5");
        b13.setStyle("grid-column", "6");
        b14.setStyle("grid-column", "7");
        b3.setStyle("width", "100%"); 
        b4.setStyle("width", "100%"); 
        b5.setStyle("width", "100%"); 
        b6.setStyle("width", "100%"); 
        b7.setStyle("width", "100%"); 
        b8.setStyle("width", "100%"); 
        b9.setStyle("width", "100%"); 
        b10.setStyle("width", "100%");
        b11.setStyle("width", "100%");
        b12.setStyle("width", "100%");
        b13.setStyle("width", "100%");
        b14.setStyle("width", "100%");

    }
        

}
