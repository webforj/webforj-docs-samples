package componentdemos.sliderdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/tick_styles.css")
public class SliderTickDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Slider sl1 = new Slider().setMax(100).setMin(0);
    Slider sl2 = new Slider().setMax(100).setMin(0);

    sl1.setWidth("500px");
    sl2.setWidth("500px");

    window.add(
        new Label("<html><b>No Tick Snapping</b></html>"), sl1,
        new Label("<html><b>Tick Snapping</b></html>"), sl2);

    sl1.setTicksVisible(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10);

    sl2.setTicksVisible(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10)
        .setSnapToTicks(true);
  }
}
