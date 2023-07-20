package component_demos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/minmax_styles.css")
public class SliderMaxMinDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Slider sl1 = new Slider().setMaximum(10)
        .setMinimum(0)
        .setValue(5);

    Slider sl2 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50);

    sl1.setStyle("width", "500px");
    sl2.setStyle("width", "500px");

    panel.add(
        new Label("<html><b>Min 0, Max 10</b></html>"), sl1,
        new Label("<html><b>Min 0, Max 100</b></html>"), sl2);
  }
}
