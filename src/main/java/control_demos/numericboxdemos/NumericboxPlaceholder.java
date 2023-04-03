package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.numberfield.NumberField;

@InlineStyleSheet("context://css/numericboxstyles/placeholder_styles.css")
public class NumericboxPlaceholder extends App {

  NumberField nb;

  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    nb = new NumberField();
    panel.add(nb);

    nb.setAttribute("placeholder", "Example placeholder");
  }
}
