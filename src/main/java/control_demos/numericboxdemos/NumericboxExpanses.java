package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.numberfield.NumberField;

@InlineStyleSheet("context://css/numericboxstyles/expanse_styles.css")
public class NumericboxExpanses extends App {
  @Override
  public void run() throws DwcjException {

    Frame panel = new Frame();
    Panel container = new Panel();

    panel.add(container);
    panel.addClassName("Frame");
    container.addClassName("container");

    NumberField nb1 = new NumberField().setExpanse(NumberField.Expanse.XSMALL)
        .setAttribute("label", "Extra Small")
        .setStyle("grid-column", "1");

    NumberField nb2 = new NumberField().setExpanse(NumberField.Expanse.SMALL)
        .setAttribute("label", "Small")
        .setStyle("grid-column", "2");

    NumberField nb3 = new NumberField().setExpanse(NumberField.Expanse.MEDIUM)
        .setAttribute("label", "Medium")
        .setStyle("grid-column", "3");

    NumberField nb4 = new NumberField().setExpanse(NumberField.Expanse.LARGE)
        .setAttribute("label", "Large")
        .setStyle("grid-column", "1");

    NumberField nb5 = new NumberField().setExpanse(NumberField.Expanse.XLARGE)
        .setAttribute("label", "Extra Large")
        .setStyle("grid-column", "3");

    container.add(nb1, nb2, nb3, nb4, nb5);
  }
}
