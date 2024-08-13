package componentdemos.sliderdemos;

import java.util.Map;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.Theme;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/demo_styles.css")
public class SliderDemo extends App {

  Slider slider = new Slider();

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    slider.setLabels(Map.of(0, "Off", 30, "Small", 50, "Medium", 80, "Large", 100, "X-Large"));
    slider.setLabelsVisible(true);
    slider.setTicksVisible(true);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(2);
    slider.setAllowMajorLabelsOverlap(true);
    slider.setTooltipText("'Current Value:' + x");
    slider.setTooltipVisibleOnSlideOnly(true);
    slider.setFilled(true);
    slider.setTheme(Theme.WARNING);
    slider.setSize(600, 150);
    slider.onValueChange((x) -> {
      console().log("Value changed to: " + x.getValue());
    });
    
    window.add(slider);
    window.setStyle("display", "flex");
    window.setStyle("justify-content", "center");
    window.setStyle("margin-top", "20px");
  }

}
