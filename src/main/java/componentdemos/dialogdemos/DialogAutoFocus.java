package componentdemos.dialogdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.field.TextField;
import com.webforj.component.window.Frame;
import com.webforj.component.html.elements.Div;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogAutoFocus extends App {
  
  private Dialog dialog = new Dialog();
  
  @Override
  public void run() throws WebforjException {
    Frame p = new Frame();
    p.add(dialog);

    dialog.addToContent(new Div("Auto Focus"));
    dialog.addToContent(new TextField().setLabel("This Box is Auto Focused"));

    dialog.open();
    dialog.setAutofocus(true);
  }
}
