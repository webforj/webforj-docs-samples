package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogClose extends App {

  private Dialog dialog = new Dialog();
  private Button showDialog = new Button("Show Dialog");
  private Button closeDialog = new Button("Close Dialog");

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    p.add(dialog, showDialog);
    showDialog.setStyle("margin-left", "48vw")
        .setStyle("margin-top", "20px")
        .onClick(e -> dialog.open());

    dialog.addToHeader(new Div("Closing the Dialog"));
    dialog.addToContent(closeDialog);
    closeDialog.onClick(e -> dialog.close());
    dialog.setCancelOnEscKey(true);
    dialog.open();
  }
}
