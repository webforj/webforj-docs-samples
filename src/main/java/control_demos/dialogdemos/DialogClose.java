package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.label.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DialogClose extends App {

  Dialog dialog;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    p.add(dialog,
      new Button("Show Dialog")
        .onClick(this::openDialog)
        .setStyle("margin", "50px"));

    dialog.getHeader().add(new Label("Header"));
    dialog.getContent().add(new Button("Close Dialog").onClick(this::closeDialog));
    dialog.getFooter().add(new Label("Footer"));
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
