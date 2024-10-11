package com.webforj.samples.views.fields.datefield;

import java.time.LocalDate;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.DateField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fields/datefield/dateFieldDemo.css")
@Route
@FrameTitle("Date Field Min/Max")
public class DateFieldMinMaxView extends Composite<Div> {

  public DateFieldMinMaxView() {
    getBoundComponent().addClassName("main__window");

    DateField departure = new DateField(LocalDate.now());
    departure.setLabel("Departure Date:")
        .setMin(LocalDate.now())
        .addClassName("date__input");

    DateField returnField = new DateField(LocalDate.now().plusDays(1));
    returnField.setLabel("Return Date:")
        .addClassName("date__input");

    getBoundComponent().add(departure, returnField);

    departure.onModify(e -> {
      returnField.setValue(DateField.fromDate(e.getText()).plusDays(1));
      returnField.setMin(DateField.fromDate(e.getText()));
    });
  }
}