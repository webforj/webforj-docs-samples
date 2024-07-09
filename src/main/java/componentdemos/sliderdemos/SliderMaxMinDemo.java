package componentdemos.sliderdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.html.elements.Div;
import com.webforj.component.text.Label;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/minmax_styles.css")
public class SliderMaxMinDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Slider sl1 = new Slider().setMaximum(10)
        .setMinimum(0)
        .setValue(5);
    Div div1 = new Div("Value: 5");
    sl1.onScroll(__ -> div1.setText("Value: " + sl1.getValue()));

    Slider sl2 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50);
    Div div2 = new Div("Value: 50");
    sl2.onScroll(__ -> div2.setText("Value: " + sl2.getValue()));

    sl1.setStyle("width", "500px");
    sl2.setStyle("width", "500px");

    window.add(
        new Label("<html><b>Min 0, Max 10</b></html>"), sl1, div1,
        new Label("<html><b>Min 0, Max 100</b></html>"), sl2, div2
    );
  }
}
