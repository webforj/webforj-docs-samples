package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.numericbox.NumericBox;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

public class DialogPositioning extends App {

  NumericBox xPos, yPos;
  Dialog dialog;

  @Override
  public void run() throws DwcException {
    AppPanel p = new AppPanel();
    dialog = new Dialog();
    xPos = new NumericBox();
    yPos = new NumericBox();
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
