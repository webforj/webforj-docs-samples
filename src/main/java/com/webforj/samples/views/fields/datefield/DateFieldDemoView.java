package com.webforj.samples.views.fields.datefield;

import java.time.LocalDate;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.DateField;
import com.webforj.component.html.elements.Div;
import com.webforj.data.event.ValueChangeEvent;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fields/datefield/dateFieldDemo.css")

@Route
@FrameTitle("Date Field Demo")
public class DateFieldDemoView extends Composite<Div> {

  private DateField returnField = new DateField(LocalDate.now());
  private DateField departure = new DateField(LocalDate.now());

  public DateFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    departure.setLabel("Departure Date:")
        .addClassName("date__input")
        .setMin(LocalDate.now())
        .addValueChangeListener(this::setMinReturn);

    returnField.setLabel("Return Date:")
        .addClassName("date__input")
        .setMin(LocalDate.now());

    getBoundComponent().add(departure, returnField);
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
