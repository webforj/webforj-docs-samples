package componentdemos.progressbar;

import com.webforj.App;
import com.webforj.Interval;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.progressbar.ProgressBar;
import com.webforj.component.window.Frame;
import com.webforj.dispatcher.EventListener;
import com.webforj.exceptions.WebforjException;

public class ProgressBarOrientation extends App {
  Button start = new Button("<html><dwc-icon name='player-play'></dwc-icon></<html> Start");
  Button pause = new Button("<html><dwc-icon name='player-pause'></dwc-icon></<html> Pause");
  Button reset = new Button("<html><dwc-icon name='refresh'></dwc-icon></<html> Reset");
  ProgressBar bar = new ProgressBar(15, "Reactor Heating Up: {{x}}%");
  FlexLayout buttonContainer = FlexLayout.create(start, pause, reset).vertical().build();
  FlexLayout layout = FlexLayout.create(buttonContainer, bar).horizontal().build()
      .setMaxWidth("320px")
      .setStyle("margin", "0 auto")
      .setStyle("padding", "20px");

  @Override
  public void run() throws WebforjException {
    Interval interval = new Interval(0.1f, new EventListener<Interval.ElapsedEvent>() {
      @Override
      public void onEvent(Interval.ElapsedEvent event) {
        Integer progress = bar.getValue() + 1;
        bar.setValue(progress);

        if (progress >= bar.getMax()) {
          event.getInterval().stop();
          start.setEnabled(false);
          pause.setEnabled(false);
          bar.setAnimated(false);
        }
      }
    });

    bar.setWidth("160px")
        .setHeight("125px")
        .setTheme(Theme.SUCCESS)
        .setValue(25)
        .setOrientation(ProgressBar.Orientation.VERTICAL)
        .setStriped(true)
        .setAnimated(true)
        .onValueChange(e -> {
          if (e.getValue() >= 25 && e.getValue() < 75) {
            bar.setTheme(Theme.WARNING);
          } else if (e.getValue() >= 75) {
            bar.setTheme(Theme.DANGER);
          } else {
            bar.setTheme(Theme.SUCCESS);
          }
        });

    start.onClick(e -> {
      bar.setAnimated(true);
      start.setEnabled(false);
      pause.setEnabled(true);

      interval.start();
    });

    pause.setEnabled(false);
    pause.onClick(e -> {
      bar.setAnimated(false);
      start.setEnabled(true);
      pause.setEnabled(false);

      interval.stop();
    });

    reset.onClick(e -> {
      bar.setValue(0);
      bar.setAnimated(true);
      start.setEnabled(false);
      pause.setEnabled(true);

      interval.restart();
    });

    Frame window = new Frame();
    window.add(layout);
  }
}
