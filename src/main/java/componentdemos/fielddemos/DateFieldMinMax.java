package componentdemos.fielddemos;

import java.time.LocalDate;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.DateField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class DateFieldMinMax extends App {

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame window = new Frame();
    window.addClassName("main__window");

    DateField departure = new DateField(LocalDate.now());
    departure.setLabel("Departure Date:")
        .setMin(LocalDate.now())
        .addClassName("date__input");

    DateField returnField = new DateField(LocalDate.now().plusDays(1));
    returnField.setLabel("Return Date:")
        .addClassName("date__input");

    window.add(departure, returnField);


    departure.onModify(e -> {
      returnField.setValue(DateField.fromDate(e.getText()).plusDays(1));
      returnField.setMin(DateField.fromDate(e.getText()));
      App.consoleLog(DateField.fromDate(e.getText()) + "");
    });
  }
}

