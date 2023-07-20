package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogDraggable extends App {
  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    Dialog dialog = new Dialog();
    p.add(dialog);

    dialog.getHeader().add(new Label("Snapping"));
    dialog.getContent().add(new Label("This dialog will snap when dragged within 100px of the edge of the display."));
    dialog.show();

    dialog.setSnapToEdge(true);
    dialog.setSnapThreshold(100);
  }
}
