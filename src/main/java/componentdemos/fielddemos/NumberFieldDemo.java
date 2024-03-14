package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.NumberField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class NumberFieldDemo extends App {

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    NumberField numField = new NumberField();
    numField.addClassName("date__input");
    numField.setLabel("Quantity:");

    window.add(numField);
  }
}