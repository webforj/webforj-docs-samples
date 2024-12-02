package com.webforj.samples.views.fields.timefield;

import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TimeField;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.component.toast.Toast;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@Route
@FrameTitle("Time Field Min/Max")
public class TimeFieldMinMaxView extends Composite<FlexLayout> {

  private TimeField meeting = new TimeField(LocalTime.of(12, 30));
  private Button confirm = new Button("Confirm", ButtonTheme.PRIMARY);

  public TimeFieldMinMaxView() {
    getBoundComponent()
        .setWrap(FlexWrap.WRAP)
        .setSpacing("var(--dwc-space-l)")
        .setMargin("var(--dwc-space-m)");

    meeting.setWidth("250px");
    confirm.setWidth("150px");

    getBoundComponent().add(meeting, confirm);
    getBoundComponent().setItemAlignment(FlexAlignment.END, confirm);

    meeting.setLabel("Enter a meeting time:");

    meeting.onModify(event -> {
      String input = event.getText();
      try {
        if (input != null && !input.isEmpty()) {
          LocalTime.parse(input);
          confirm.setEnabled(true);
        } else {
          confirm.setEnabled(false);
        }
      } catch (DateTimeParseException ex) {
        confirm.setEnabled(false);
      }
    });

    confirm.onClick(e -> showToast("Meeting time confirmed!"));
  }

  private void showToast(String message) {
    Toast toast = new Toast(message);
    toast.setDuration(3000);
    toast.setTheme(Theme.SUCCESS);
    toast.open();
  }
}