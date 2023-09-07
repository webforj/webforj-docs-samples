package componentdemos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/tick_styles.css")
public class SliderTickDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Slider sl1 = new Slider().setMaximum(100).setMinimum(0);
    Slider sl2 = new Slider().setMaximum(100).setMinimum(0);

    window.add(
        new Label("<html><b>No Tick Snapping</b></html>"), sl1,
        new Label("<html><b>Tick Snapping</b></html>"), sl2);

    sl1.setPaintTicks(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10);

    sl2.setPaintTicks(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10)
        .setSnapToTicks(true);
  }
}
