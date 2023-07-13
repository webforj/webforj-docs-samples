package control_demos.sliderdemos;

import java.util.Map;
import static java.util.Map.entry;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/inversion_styles.css")
public class SliderInversionDemo extends App {

  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Map<Integer, String> mapMatch = Map.ofEntries(
        entry(0, "0"),
        entry(50, "50"),
        entry(100, "100"));

    Slider sl1 = new Slider().setMaximum(100)
        .setMinimum(0);
    Slider sl2 = new Slider().setMaximum(100)
        .setMinimum(0);

    panel.add(new Label("<html><b>Original:</b></html>"), sl1,
        new Label("<html><b>Inverted:</b></html>"), sl2);

    sl1.setPaintTicks(true)
        .setMinorTickSpacing(10)
        .setPaintLabels(true)
        .setLabels(mapMatch);

    sl2.setPaintTicks(true)
        .setMinorTickSpacing(10)
        .setPaintLabels(true)
        .setLabels(mapMatch)
        .setAttribute("inverted", "true");
  }
}
