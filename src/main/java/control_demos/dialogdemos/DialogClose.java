package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

public class DialogClose extends App {
    
    Dialog dialog;

    @Override
    public void run() throws DwcException{
        AppPanel p = new AppPanel();
        dialog = new Dialog();
        p.add(dialog,new Button("Show Dialog").onClick(this::openDialog));
        
        dialog.getHeader().add(new Label("Header"));
        dialog.getContent().add(new Button("Close Dialog").onClick(this::closeDialog));
        dialog.getFooter().add(new Label("Footer"));
        dialog.setCancelOnEscKey(true);
        dialog.show();
    }

    private void closeDialog(ButtonClickEvent ev){
        dialog.hide();
    }

    private void openDialog(ButtonClickEvent ev){
        dialog.show();
    }

}
