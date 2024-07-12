package demos;

import com.webforj.Interval;
import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optiondialog.ConfirmDialog;
import com.webforj.component.window.Frame;
import com.webforj.component.field.NumberField;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;

import java.util.ArrayList;
import java.util.ListIterator;

public class IntervalDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();

    // Creates the buttons with icons and labels//
    Button startInterval = new Button(/*html */"""
        <html>
            <dwc-icon name=\"player-play\"></dwc-icon>
            Play
        </html>
        """);
    startInterval.setEnabled(false);

    Button stopInterval = new Button(/*html */"""
        <html>
            <dwc-icon name=\"player-pause\"></dwc-icon>
            Pause
        </html>
        """);

    Button restartInterval = new Button(/*html */"""
        <html>
            <dwc-icon name=\"settings-automation\"></dwc-icon>
            Set Delay
        </html>
        """);

    // Creates the NumberField to chose the Interval delay//
    // Note: Fractional seconds are allowed to millisecond resolution for an
    // Interval delay//
    float delay = 1f;
    double speedMin = 0.01;

    NumberField delaySpeed = new NumberField();
    delaySpeed.setMin(speedMin);
    delaySpeed.setPlaceholder("Delay Speed");
    delaySpeed.setStyle("width", "120px");
    delaySpeed.setStep(speedMin);

    // Creates an array of different icons to loop through on the displayButton
    // during the Interval event//
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

    // Creates the Interval that starts on run//
    Interval interval = new Interval(delay, listener);
    interval.start();

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
      if (delaySpeed.getValue() != null) {
        startInterval.setEnabled(false);
        stopInterval.setEnabled(true);
        float pickedSpeed = delaySpeed.getValue().floatValue();
        interval.setDelay(pickedSpeed);
        interval.restart();
      } else {
        ConfirmDialog error = new ConfirmDialog("Please set a delay speed.", "Interval Demo");
        error.show();
      }
    });

    FlexLayout mainLayout = new FlexLayout(startInterval, stopInterval, displayButton, delaySpeed, restartInterval)
        .setJustifyContent(FlexJustifyContent.CENTER);

    mainLayout
        .setMargin("10px")
        .setPadding("10px");

    window.add(mainLayout);

  }
}
