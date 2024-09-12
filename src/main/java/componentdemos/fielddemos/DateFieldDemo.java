package componentdemos.fielddemos;

import java.time.LocalDate;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.DateField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.data.event.ValueChangeEvent;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css*/"""
    .main__window{
        display: flex;
        margin: 20px;
        gap: var(--dwc-space-l);
    }

    .date__input{
        flex: none;
        width: 200px;
    }
    """)
public class DateFieldDemo extends App {
    private DateField returnField = new DateField(LocalDate.now());
    private DateField departure = new DateField(LocalDate.now());

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    departure.setLabel("Departure Date:")
        .addClassName("date__input")
        .setMin(LocalDate.now())
        .addValueChangeListener(this::setMinReturn); 

    returnField.setLabel("Return Date:")
        .addClassName("date__input")
        .setMin(LocalDate.now());

    window.add(departure,returnField);
  }


  private void setMinReturn(ValueChangeEvent e) {
    LocalDate departureDate = (LocalDate) e.getValue();
    LocalDate arrivalDate = (LocalDate) returnField.getValue();

    if (departureDate.isAfter(arrivalDate)) {
         returnField.setValue(departureDate);
    }

    returnField.setMin(departureDate);
  }
}
