package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.label.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DialogDraggable extends App {
  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
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
