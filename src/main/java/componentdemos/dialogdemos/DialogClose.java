package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogClose extends App {

  Dialog dialog;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    Button showDialog = new Button("Show Dialog");
    showDialog.setStyle("margin-left", "48vw")
      .setStyle("margin-top", "20px")
      .onClick(this::openDialog);
    p.add(dialog, showDialog);

    dialog.getHeader().add(new Label("Closing the Dialog"));

    Button closeDialog = new Button("Close Dialog");
    closeDialog.onClick(this::closeDialog);
    dialog.getContent().add(closeDialog);
    
    dialog.setCancelOnEscKey(true);
    dialog.show();
  }

  private void closeDialog(ButtonClickEvent ev) {
    dialog.hide();
  }

  private void openDialog(ButtonClickEvent ev) {
    dialog.show();
  }

}
