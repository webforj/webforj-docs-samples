package demos.IntervalDemos;

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

public class IntervalChangeDelayDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();

    Button restartInterval = new Button("Set Delay");

    float delay = 1f;
    double speedMin = 0.01;

    NumberField delaySpeed = new NumberField();
    delaySpeed.setMin(speedMin);
    delaySpeed.setPlaceholder("Delay Speed");
    delaySpeed.setStyle("width", "120px");
    delaySpeed.setStep(speedMin);

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

    restartInterval.addClickListener(e -> {
      if (delaySpeed.getValue() != null) {
        float pickedSpeed = delaySpeed.getValue().floatValue();
        interval.setDelay(pickedSpeed);
        interval.restart();
      } else {
        ConfirmDialog error = new ConfirmDialog("Please set a delay speed.", "Interval Demo");
        error.show();
      }
    });

    FlexLayout mainLayout = new FlexLayout(displayButton, delaySpeed, restartInterval)
        .setJustifyContent(FlexJustifyContent.CENTER);

    mainLayout
        .setMargin("10px")
        .setPadding("10px");

    window.add(mainLayout);

  }
}