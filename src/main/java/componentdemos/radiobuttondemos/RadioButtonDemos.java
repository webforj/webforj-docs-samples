package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

import org.dwcj.component.optioninput.RadioButton;

public class RadioButtonDemos extends App{

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame window = new Frame();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");


        RadioButton rb1 = new RadioButton();
        RadioButton rb2 = new RadioButton();
        RadioButton rb3 = new RadioButton();
        RadioButton rb4 = new RadioButton();
        RadioButton rb5 = new RadioButton();

        panel.add(rb1,rb2,rb3,rb4,rb5);

        rb1.setText("TEST");



    }

}
