package control_demos.buttondemos;
import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.button.Button;

import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet(value = "css/buttonstyles/expanse_styles.css", local = true)

public class ButtonExpanses extends App {

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        Button be1 = new Button("XSMALL").setExpanse(Button.Expanse.XSMALL);
        Button be2 = new Button("SMALL").setExpanse(Button.Expanse.SMALL);
        Button be3 = new Button("MEDIUM").setExpanse(Button.Expanse.MEDIUM);
        Button be4 = new Button("LARGE").setExpanse(Button.Expanse.LARGE);
        Button be5 = new Button("XLARGE").setExpanse(Button.Expanse.XLARGE);

        panel.add(be1,be2,be3,be4,be5);
                        

        
    }
        

}
