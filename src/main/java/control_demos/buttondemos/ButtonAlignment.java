package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.Button.TextVerticalAlignment;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet(value = "css/buttonstyles/alignment_styles.css", local = true)

public class ButtonAlignment extends App{
    
    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");
        
        Button buttonTop = new Button("TOP ALIGNMENT");
        Button buttonCenter = new Button("CENTER ALIGNMENT");
        Button buttonBottom = new Button("BOTTOM ALIGNMENT");

        panel.add(buttonTop,buttonCenter,buttonBottom);

        buttonTop.setTheme(Button.Theme.DEFAULT).setVerticalAlignment(TextVerticalAlignment.TOP);
        buttonCenter.setTheme(Button.Theme.DEFAULT).setVerticalAlignment(TextVerticalAlignment.CENTER);
        buttonBottom.setTheme(Button.Theme.DEFAULT).setVerticalAlignment(TextVerticalAlignment.BOTTOM);
    } 


}
