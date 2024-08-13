package componentdemos.sliderdemos;

import java.util.Map;
import static java.util.Map.entry;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/label_styles.css")
public class SliderLabelDemo extends App {
  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.addClassName("Frame");

    Slider sl1 = new Slider().setMax(100)
        .setMin(0);
    Slider sl2 = new Slider().setMax(100)
        .setMin(0);
    Slider sl3 = new Slider().setMax(100)
        .setMin(0);

    Map<Integer, String> mapMatch = Map.ofEntries(
        entry(0, "0"),
        entry(10, "10"),
        entry(20, "20"),
        entry(25, "25"),
        entry(30, "30"),
        entry(40, "40"),
        entry(50, "50"),
        entry(60, "60"),
        entry(70, "70"),
        entry(75, "75"),
        entry(80, "80"),
        entry(90, "90"),
        entry(100, "100"));

    Map<Integer, String> mapNoMatch = Map.ofEntries(
        entry(15, "15"),
        entry(35, "35"),
        entry(65, "65"),
        entry(85, "85"));

    window.add(
        new Label("<html><b>Labels applied with ticks disabled</b></html>")
            .setStyle("grid-column", "1")
            .setStyle("margin", "5px 0 0 10px"),
        sl1,
        new Label("<html><b>Labels applied to tick values</b></html>")
            .setStyle("grid-column", "1")
            .setStyle("margin", "5px 0 0 10px"),
        sl2,
        new Label("<html><b>Labels applied to non-tick values</b></html>")
            .setStyle("grid-column", "1")
            .setStyle("margin", "5px 0 0 10px"),
        sl3);

    sl1.setLabelsVisible(true)
        .setLabels(mapMatch)
        .setSnapToTicks(true);

    sl2.setTicksVisible(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10)
        .setLabelsVisible(true)
        .setLabels(mapMatch)
        .setSnapToTicks(true);

    sl3.setTicksVisible(true)
        .setMajorTickSpacing(50)
        .setMinorTickSpacing(10)
        .setLabelsVisible(true)
        .setLabels(mapNoMatch)
        .setSnapToTicks(true);
  }
}
