package componentdemos.sliderdemos;

import java.util.Map;
import static java.util.Map.entry;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.slider.Slider;
import org.dwcj.component.slider.Slider.Orientation;

@InlineStyleSheet("context://css/sliderstyles/orientation_styles.css")
public class SliderOrientationDemo extends App {
	
	 Slider sl1 = new Slider();
	 Slider sl2 = new Slider();
			 
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Map<Integer, String> mapMatch = Map.ofEntries(
        entry(0, "0"),
        entry(50, "50"),
        entry(100, "100"));

    sl1.setMaximum(100)
        .setMinimum(0);
    sl2.setMaximum(100)
        .setMinimum(0);

    window.add(sl1, sl2);

    sl1.setStyle("width", "400px")
        .setPaintTicks(true)
        .setMinorTickSpacing(10)
        .setPaintLabels(true)
        .setLabels(mapMatch);

    sl2.setOrientation(Orientation.VERTICAL)
        .setStyle("padding-left", "40px")
        .setPaintTicks(true)
        .setMinorTickSpacing(10)
        .setPaintLabels(true)
        .setLabels(mapMatch);
  }
}
