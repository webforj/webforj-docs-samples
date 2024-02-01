package componentdemos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/minmax_styles.css")
public class SliderMaxMinDemo extends App {
	
	Slider sl1 = new Slider();
	Slider sl2 = new Slider();
			
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    sl1.setMaximum(10)
    	.setMinimum(0)
    	.setValue(5);

    sl2.setMaximum(100)
        .setMinimum(0)
        .setValue(50);

    sl1.setStyle("width", "500px");
    sl2.setStyle("width", "500px");

    window.add(
        new Label("<html><b>Min 0, Max 10</b></html>"), sl1,
        new Label("<html><b>Min 0, Max 100</b></html>"), sl2);
  }
}
