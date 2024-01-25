package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.field.TextField;
import org.dwcj.component.window.Frame;
import org.dwcj.component.html.elements.Div;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogAutoFocus extends App {
  
  private Dialog dialog = new Dialog();
  
  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    p.add(dialog);

    dialog.addToContent(new Div("Auto Focus"));
    dialog.addToContent(new TextField().setLabel("This Box is Auto Focused"));

    dialog.open();
    dialog.setAutofocus(true);
  }
}
