package componentdemos.numericboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.maskednumberfield.MaskedNumberField;

@InlineStyleSheet("context://css/numericboxstyles/demo_styles.css")
public class NumericboxDemo extends App {

  MaskedNumberField nb;

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");
    nb = new MaskedNumberField();
    window.add(nb);
  }
}
