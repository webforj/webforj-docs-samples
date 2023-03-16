package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

public class DialogDraggable extends App {
    @Override
    public void run() throws DwcException{
        AppPanel p = new AppPanel();
        Dialog test = new Dialog();
        p.add(test);
        
        test.getHeader().add(new Label("Header"));
        test.getContent().add(new Label("Content"));
        test.getFooter().add(new Label("Footer"));
        test.show();

        test.setSnapToEdge(true);
        test.setSnapThreshold(100);
    }
}
