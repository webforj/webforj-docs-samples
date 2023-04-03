package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.label.Label;
import org.dwcj.component.numberfield.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DialogPositioning extends App {

  NumberField xPos, yPos;
  Dialog dialog;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    xPos = new NumberField();
    yPos = new NumberField();
    p.add(dialog);

    dialog.getHeader().add(new Label("Header"));
    dialog.getContent()
        .add(new Label("X Pixels:"), xPos, new Label("Y Pixels:"), yPos, new Button("Set Dialog Position").onClick(this::setPosition))
        .setStyle("display", "flex")
        .setStyle("justify-content", "space-around");

    dialog.setAutoFocus(true);
    dialog.show();
    dialog.setCloseable(false);
  }

  private void setPosition(ButtonClickEvent ev) {
    dialog.setPosx(xPos.getValue().toString() + "px");
    dialog.setPosy(yPos.getValue().toString() + "px");
  }
}
