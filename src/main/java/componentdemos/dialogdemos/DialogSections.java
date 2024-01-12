package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogSections extends App {

  private Dialog dialog = new Dialog();

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    p.add(dialog);
    dialog.addToHeader(new Div("Header"));
    dialog.addToContent(new Div("Content"));
    dialog.addToFooter(new Div("Footer"));
    dialog.setCloseable(false);
    dialog.open();
  }
}
