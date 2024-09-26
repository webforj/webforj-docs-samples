package com.webforj.samples.views.fields.timefield;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TimeField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.time.LocalTime;

@InlineStyleSheet(/*css */"""
    .window {
      display: flex;
      align-items: flex-end;
      margin: 20px;
      gap: 50px;
      width: 100%;
      flex-wrap: wrap;
    }
    """)
@Route
@FrameTitle("Time Field Min/Max")
public class TimeFieldMinMaxView extends Composite<Div> {

  private final TimeField meeting = new TimeField(LocalTime.of(12, 30));
  private final Button confirm = new Button("Confirm", ButtonTheme.PRIMARY);

  public TimeFieldMinMaxView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(meeting, confirm);

    LocalTime min = LocalTime.of(12, 30);
    LocalTime max = LocalTime.of(17, 15);
    String label = "Choose a meeting time between %s and %s:".formatted(min, max);
    meeting.setMin(min)
        .setMax(max);

    meeting.setLabel(label)
      .onModify(e -> {
        try {
          meeting.setText(e.getText());
          confirm.setEnabled(true);
        } catch (IllegalArgumentException __) {
          confirm.setEnabled(false);
        }
        App.console().log(meeting.getValue() + "");
      });
  }
}
