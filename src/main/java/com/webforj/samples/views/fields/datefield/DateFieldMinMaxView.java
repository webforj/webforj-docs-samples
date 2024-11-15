package com.webforj.samples.views.fields.datefield;

import java.time.LocalDate;
import com.webforj.component.Composite;
import com.webforj.component.field.DateField;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Date Field Min/Max")
public class DateFieldMinMaxView extends Composite<FlexLayout> {

  public DateFieldMinMaxView() {
    getBoundComponent().setDirection(FlexDirection.ROW).setSpacing("var(--dwc-space-l")
    .setMargin("var(--dwc-space-m)");

    DateField departure = new DateField(LocalDate.now());
    departure.setLabel("Departure Date:")
        .setWidth("200px")
        .setMin(LocalDate.now());

    DateField returnField = new DateField(LocalDate.now().plusDays(1));
    returnField.setLabel("Return Date:")
        .setWidth("200px");

    getBoundComponent().add(departure, returnField);

    departure.onModify(e -> {
      returnField.setValue(DateField.fromDate(e.getText()).plusDays(1));
      returnField.setMin(DateField.fromDate(e.getText()));
    });
  }
}