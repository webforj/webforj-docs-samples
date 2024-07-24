package componentdemos.busyindicatordemos;

import com.webforj.App;
import com.webforj.BusyIndicator;
import com.webforj.Interval;
import com.webforj.component.Theme;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;

public class BusyIndicatorDemo extends App {
  private int retry = 1;

  @Override
  public void run() throws WebforjException {

    // Advance configurations
    BusyIndicator indicator = getBusyIndicator();
    indicator.setText("Initiating spoon pending sequence... Hold tight! This will take 3 seconds.");

    Interval interval = new Interval(3f, new EventListener<Interval.ElapsedEvent>() {
      @Override
      public void onEvent(Interval.ElapsedEvent event) {
        if (retry <= 1) {
          indicator.getSpinner().setTheme(Theme.WARNING).setSpeed(200)
              .setExpanse(SpinnerExpanse.LARGE);
          indicator.setText(
              "Attempt 1: Still trying to bend the spoon... It's trickier than it looks!, Trying harder...");
        } else if (retry == 2) {
          indicator.getSpinner().setTheme(Theme.DANGER);
          indicator.setText(
              "Attempt 2: Spoon bending failed... Maybe it’s magic-proof. Let's stop here.");
        } else {
          event.getInterval().stop();
          indicator.getSpinner().setTheme(Theme.SUCCESS);
          indicator.setText(
              "Demo complete! Remember, it's not about bending spoons, it's about having fun!");
        }

        retry++;
      }
    });

    indicator.open();
    interval.start();
  }
}
