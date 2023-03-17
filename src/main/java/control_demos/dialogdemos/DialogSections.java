package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;

public class DialogSections extends App {
  @Override
  public void run() throws DwcException {
    AppPanel p = new AppPanel();
    Dialog dialog = new Dialog();
    p.add(dialog);

    dialog.getHeader().add(new Label("Header"));
    dialog.getContent().add(new Label("Content"));
    dialog.getFooter().add(new Label("Footer"));

    dialog.setCloseable(false);
    dialog.show();
  }
}
