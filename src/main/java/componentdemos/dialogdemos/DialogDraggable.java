package componentdemos.dialogdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogDraggable extends App {

  private Dialog dialog = new Dialog();

  @Override
  public void run() throws WebforjException {
    Frame p = new Frame();
    p.add(dialog);

    dialog.addToHeader(new Div("Snapping"));
    dialog.addToContent(new Div("This dialog will snap when dragged within 100px of the edge of the display."));
    dialog.open();

    dialog.setSnapToEdge(true);
    dialog.setSnapThreshold(100);
  }
}
