package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.maskednumberfield.MaskedNumberField;

@InlineStyleSheet("context://css/numericboxstyles/expanse_styles.css")
public class NumericboxExpanses extends App {
  @Override
  public void run() throws DwcjException {

    Frame panel = new Frame();
    Panel container = new Panel();

    panel.add(container);
    panel.addClassName("Frame");
    container.addClassName("container");

    MaskedNumberField nb1 = new MaskedNumberField().setExpanse(MaskedNumberField.Expanse.XSMALL)
        .setAttribute("label", "Extra Small")
        .setStyle("grid-column", "1");

    MaskedNumberField nb2 = new MaskedNumberField().setExpanse(MaskedNumberField.Expanse.SMALL)
        .setAttribute("label", "Small")
        .setStyle("grid-column", "2");

    MaskedNumberField nb3 = new MaskedNumberField().setExpanse(MaskedNumberField.Expanse.MEDIUM)
        .setAttribute("label", "Medium")
        .setStyle("grid-column", "3");

    MaskedNumberField nb4 = new MaskedNumberField().setExpanse(MaskedNumberField.Expanse.LARGE)
        .setAttribute("label", "Large")
        .setStyle("grid-column", "1");

    MaskedNumberField nb5 = new MaskedNumberField().setExpanse(MaskedNumberField.Expanse.XLARGE)
        .setAttribute("label", "Extra Large")
        .setStyle("grid-column", "3");

    container.add(nb1, nb2, nb3, nb4, nb5);
  }
}
