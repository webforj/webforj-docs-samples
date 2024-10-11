package com.webforj.samples.views.fields.timefield;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.TimeField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.time.LocalTime;

@InlineStyleSheet("context://css/fields/datefield/dateFieldDemo.css")
@Route
@FrameTitle("Time Field Demo")
public class TimeFieldDemoView extends Composite<Div> {

  public TimeFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    TimeField reminder = new TimeField("Set Reminder:", LocalTime.now());
    reminder.addClassName("date__input");

    getBoundComponent().add(reminder);
  }

}
