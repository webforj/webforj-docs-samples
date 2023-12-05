package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogSections extends App {

  private Dialog dialog = new Dialog();

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    p.add(dialog);
    dialog.addToHeader().add(new Label("Header"));
    dialog.addToContent().add(new Label("Content"));
    dialog.addToFooter().add(new Label("Footer"));
    dialog.setCloseable(false);
    dialog.open();
  }
}
