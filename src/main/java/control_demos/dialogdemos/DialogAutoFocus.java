package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.exceptions.DwcException;

public class DialogAutoFocus extends App {
    @Override
    public void run() throws DwcException{
        AppPanel p = new AppPanel();
        Dialog test = new Dialog();
        p.add(test);
        
        test.getHeader().add(new Label("Header"));
        test.getContent().add(new TextBox().setAttribute("label", "This Box is Auto Focused"));
        test.getFooter().add(new Label("Footer"));
        test.show();

        test.setAutoFocus(true);
    }
}
