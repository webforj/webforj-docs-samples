package com.webforj.samples.views.fields.datetimefield;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.DateTimeField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
@Route
@FrameTitle("Date Time Field Demo")
public class DateTimeFieldDemoView extends Composite<Div> {

  public DateTimeFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    DateTimeField departure = new DateTimeField();
    departure.setLabel("Departure Date and Time:")
        .addClassName("date__input");

    getBoundComponent().add(departure);

  }
}