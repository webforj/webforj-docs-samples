package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.numericbox.NumericBox;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.exceptions.DwcException;

public class DialogPositioning extends App {

    NumericBox xPos, yPos;
    Dialog test;

    @Override
    public void run() throws DwcException{
        AppPanel p = new AppPanel();
        test = new Dialog();
        xPos = new NumericBox();
        yPos = new NumericBox();
        p.add(test, new NumericBox());
        
        test.getHeader().add(new Label("Header"));
        test.getContent().add(new Label("X:"), xPos, new Label("Y:"), yPos, new Button("Set Dialog Position").onClick(this::setPosition));
        test.getFooter().add(new Button("Top Align").onClick(this::topAlign),new Button("Center Align").onClick(this::centerAlign),new Button("Bottom Align").onClick(this::bottomAlign));
        test.show();
        // test.setAutoFocus(true);
    }

    private void setPosition(ButtonClickEvent ev){
        test.setPosx(xPos.getValue().toString() + "px");
        test.setPosy(yPos.getValue().toString() + "px");
    }

    private void topAlign(ButtonClickEvent ev){
        test.setAlignment(Dialog.Alignment.TOP);
    }
    private void centerAlign(ButtonClickEvent ev){
        test.setAlignment(Dialog.Alignment.CENTER);
    }
    private void bottomAlign(ButtonClickEvent ev){
        test.setAlignment(Dialog.Alignment.BOTTOM);
    }

}
