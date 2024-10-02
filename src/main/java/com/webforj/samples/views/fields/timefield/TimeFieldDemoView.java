package com.webforj.samples.views.fields.timefield;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.TimeField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.time.LocalTime;

@InlineStyleSheet(/*css */"""
  .main__window {
    display: flex;
    margin: 20px;
    gap: 100px;
  }

  .time__input {
    flex: none;
    width: 200px;
  }
  """)
@Route
@FrameTitle("Time Field Demo")
public class TimeFieldDemoView extends Composite<Div> {

  public TimeFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    TimeField reminder = new TimeField("Set Reminder:", LocalTime.now());
    reminder.addClassName("time__input");

    getBoundComponent().add(reminder);
  }

}
