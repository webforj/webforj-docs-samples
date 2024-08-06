package demos.IntervalDemos;

import com.webforj.Interval;
import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optiondialog.ConfirmDialog;
import com.webforj.component.window.Frame;
import com.webforj.component.field.NumberField;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class IntervalDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();

    // Creates the buttons with icons and labels//
    Button startInterval = new Button();
    startInterval.setHtml("<dwc-icon name='player-play' expanse='m'></dwc-icon> Start");
    startInterval.setEnabled(false);
    startInterval.setMinSize("20vw","5vw");
    startInterval.setStyle("font-size","2vw");

    Button stopInterval = new Button();
    stopInterval.setHtml("<dwc-icon name='player-pause' expanse='m'></dwc-icon> Stop");
    stopInterval.setMinSize("20vw","5vw");
    stopInterval.setStyle("font-size","2vw");

    Button restartInterval = new Button();
    restartInterval.setHtml("<dwc-icon name='settings-automation' expanse='m'></dwc-icon> Set Delay");
    restartInterval.setMinSize("20vw","5vw");
    restartInterval.setStyle("font-size","2vw");

    // Creates the NumberField to chose the Interval delay//
    // Note: Fractional seconds are allowed to millisecond resolution for an
    // Interval delay//
    float delay = 1f;
    double speedMin = 0.01;

    NumberField delaySpeed = new NumberField();
    delaySpeed.setLabel("Delay Speed");
    delaySpeed.setMin(speedMin);
    delaySpeed.setStep(speedMin);
    delaySpeed.setMinSize("20vw","5vw");
    delaySpeed.setStyle("font-size","1.75vw");

    // Creates an array of different icons to loop through on the displayButton
    // during the Interval event//
    List<String> display = Arrays.asList(
      "<dwc-icon name='baby-carriage' expanse='3xl'></dwc-icon>",
      "<dwc-icon name='skateboarding' expanse='3xl'></dwc-icon>",
      "<dwc-icon name='run' expanse='3xl'></dwc-icon>",
      "<dwc-icon name='old' expanse='3xl'></dwc-icon>"
    );

    Button displayButton = new Button().setTheme(ButtonTheme.OUTLINED_PRIMARY);
    displayButton.setWidth("10vw");
    displayButton.setMinSize("60px","5vw");
    displayButton.setStyle("font-size","2vw");

    final ListIterator<String>[] displayIterator = new ListIterator[]{display.listIterator(0)};

    EventListener<Interval.ElapsedEvent> listener = (e -> {
      if (displayIterator[0].hasNext()) {
        displayButton.setHtml(displayIterator[0].next());
      }
      else {
        // Resets the iterator to the start and displays the first item
        displayIterator[0] = display.listIterator(0);
        displayButton.setHtml(displayIterator[0].next());
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
        .setJustifyContent(FlexJustifyContent.CENTER)
        .setAlignment(FlexAlignment.END);

    mainLayout
        .setMargin("10px")
        .setPadding("10px");

    window.add(mainLayout);

  }
}
