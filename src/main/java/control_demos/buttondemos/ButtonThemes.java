package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.button.Button;

import org.dwcj.exceptions.DwcAppInitializeException;


@InlineStyleSheet("context://css/buttonstyles/theme_styles.css")


public class ButtonThemes extends App {
    
    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        Button b1 = new Button("DEFAULT").setTheme(Button.Theme.DEFAULT);
        Button b2 = new Button("DANGER").setTheme(Button.Theme.DANGER);
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

        panel.add(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14);

    }
        

}
