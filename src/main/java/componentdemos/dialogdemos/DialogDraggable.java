package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogDraggable extends App {

  private Dialog dialog = new Dialog();

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    p.add(dialog);

    dialog.addToHeader(new Label("Snapping"));
    dialog.addToContent(new Label("This dialog will snap when dragged within 100px of the edge of the display."));
    dialog.open();

    dialog.setSnapToEdge(true);
    dialog.setSnapThreshold(100);
  }
}
