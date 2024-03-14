package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.DateTimeField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class DateTimeFieldDemo extends App {

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    DateTimeField departure = new DateTimeField();
    departure.setLabel("Departure Date and Time:")
        .addClassName("date__input");

    window.add(departure);

  }
}