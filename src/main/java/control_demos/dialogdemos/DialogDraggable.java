package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

public class DialogDraggable extends App {
  @Override
  public void run() throws DwcException {
    AppPanel p = new AppPanel();
    Dialog dialog = new Dialog();
    p.add(dialog);

    dialog.getHeader().add(new Label("Header"));
    dialog.getContent().add(new Label("This dialog will snap to the sides when dragged within 100px of the edge of the display"));
    dialog.getFooter().add(new Label("Footer"));
    dialog.show();

    dialog.setSnapToEdge(true);
    dialog.setSnapThreshold(100);
  }
}
