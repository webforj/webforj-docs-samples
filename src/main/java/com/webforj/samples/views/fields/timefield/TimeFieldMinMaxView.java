package com.webforj.samples.views.fields.timefield;

import com.webforj.App;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TimeField;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.time.LocalTime;

@Route
@FrameTitle("Time Field Min/Max")
public class TimeFieldMinMaxView extends Composite<FlexLayout> {

  TimeField meeting = new TimeField(LocalTime.of(12, 30));
  Button confirm = new Button("Confirm", ButtonTheme.PRIMARY);

  public TimeFieldMinMaxView() {
    getBoundComponent().setWrap(FlexWrap.WRAP)
        .setSpacing("var(--dwc-space-l")
        .setMargin("var(--dwc-space-m)");
    
    getBoundComponent().add(meeting, confirm);
    
    getBoundComponent().setItemAlignment(FlexAlignment.END, confirm);

    LocalTime min = LocalTime.of(12, 30);
    LocalTime max = LocalTime.of(17, 15);
    String label = "Choose a meeting time between %s and %s:".formatted(min, max);
    meeting.setMin(min)
        .setMax(max);

    meeting.setLabel(label)
    .onModify(e -> {
      try {
        LocalTime parsedTime = LocalTime.parse(e.getText());
        meeting.setValue(parsedTime);
        confirm.setEnabled(true);
      } catch (Exception ex) {
        confirm.setEnabled(false);
        App.console().log("Invalid time input: " + e.getText());
      }
    });
  }
}
