package componentdemos.fielddemos;

import java.time.LocalDate;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.DateField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class DateFieldDemo_OLD extends App {

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    DateField departure = new DateField(LocalDate.now());
    departure.setLabel("Departure Date:")
        .addClassName("date__input");

    window.add(departure);

  }
}