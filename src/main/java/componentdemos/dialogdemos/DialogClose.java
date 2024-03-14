package componentdemos.dialogdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogClose extends App {

  private Dialog dialog = new Dialog();
  private Button showDialog = new Button("Show Dialog");
  private Button closeDialog = new Button("Close Dialog");

  @Override
  public void run() throws WebforjException {
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
