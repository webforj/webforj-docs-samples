package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.field.TimeField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import java.time.LocalTime;

@InlineStyleSheet("context://css/fieldstyles/time_field_styles.css")
public class TimeFieldDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("main__window");

    TimeField reminder = new TimeField("Set Reminder:", LocalTime.now());
    reminder.addClassName("time__input");

    window.add(reminder);
  }

}
