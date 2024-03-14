package componentdemos.numericboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.window.Panel;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.maskednumberfield.MaskedNumberField;

@InlineStyleSheet("context://css/numericboxstyles/expanse_styles.css")
public class NumericboxExpanses extends App {
  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    Panel container = new Panel();

    window.add(container);
    window.addClassName("Frame");
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
