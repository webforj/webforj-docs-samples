package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TimeField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import java.time.LocalTime;

@InlineStyleSheet("""
    .window {
      display: flex;
      align-items: flex-end;
      margin: 20px;
      gap: 50px;
      width: 100%;
      flex-wrap: wrap;
    }
    """)
public class TimeFieldMinMax extends App {
  private final TimeField meeting;
  private final Button confirm;

  public TimeFieldMinMax() {
    meeting = new TimeField(LocalTime.of(12, 30));
    confirm = new Button("Confirm");
    confirm.setTheme(ButtonTheme.PRIMARY);
  }

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("window");
    window.add(meeting, confirm);

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
        console().log(meeting.getValue() + "");
      });
  }
}
