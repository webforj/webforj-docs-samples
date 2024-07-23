package demos.IntervalDemos;

import com.webforj.Interval;
import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;

import java.util.ArrayList;
import java.util.ListIterator;

public class IntervalStartStopRestartDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();

    Button startInterval = new Button("Start");

    Button stopInterval = new Button("Stop");

    Button restartInterval = new Button("Restart");

    String baby = """
        <html>
            <dwc-icon name=\"baby-carriage\"></dwc-icon>
        </html>
        """;

    String kid = """
        <html>
            <dwc-icon name=\"skateboarding\"></dwc-icon>
        </html>
        """;

    String adult = """
        <html>
            <dwc-icon name=\"run\"></dwc-icon>
        </html>
        """;

    String old = """
        <html>
            <dwc-icon name=\"old\"></dwc-icon>
        </html>
        """;

    ArrayList<String> display = new ArrayList<>();

    display.add(baby);
    display.add(kid);
    display.add(adult);
    display.add(old);

    ListIterator<String> displayIterator = display.listIterator(0);

    Button displayButton = new Button().setTheme(ButtonTheme.OUTLINED_PRIMARY);
    displayButton.setStyle("width", "70px");

    EventListener<Interval.ElapsedEvent> listener = (e -> {
      if (displayIterator.hasNext()) {
        displayButton.setText(displayIterator.next());
      }
      // Loops back to the beginning of the array//
      else {
        displayIterator.previous();
        displayIterator.previous();
        displayIterator.previous();
        displayButton.setText(display.get(0));
      }
    });

    float delay = 1f;
    Interval interval = new Interval(delay, listener);

    startInterval.addClickListener(e -> {
      startInterval.setEnabled(false);
      stopInterval.setEnabled(true);
      interval.start();
    });

    stopInterval.addClickListener(e -> {
      startInterval.setEnabled(true);
      stopInterval.setEnabled(false);
      interval.stop();
    });

    restartInterval.addClickListener(e -> {
      startInterval.setEnabled(false);
      stopInterval.setEnabled(true);
      interval.restart();
    });

    FlexLayout mainLayout = new FlexLayout(startInterval, stopInterval, displayButton, restartInterval)
        .setJustifyContent(FlexJustifyContent.CENTER);

    mainLayout
        .setMargin("10px")
        .setPadding("10px");

    window.add(mainLayout);

  }
}
