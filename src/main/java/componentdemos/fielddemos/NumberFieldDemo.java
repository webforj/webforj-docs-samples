package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class NumberFieldDemo extends App {

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame window = new Frame();
    window.addClassName("main__window");

    NumberField numField = new NumberField();
    numField.addClassName("date__input");
    numField.setLabel("Quantity:");
    

    window.add(numField);

  }
}
