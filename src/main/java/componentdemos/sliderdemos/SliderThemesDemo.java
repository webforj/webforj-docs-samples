package componentdemos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.element.Element;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/theme_styles.css")
public class SliderThemesDemo extends App {
	
	 Slider sl1 = new Slider();
	 Slider sl2 = new Slider();
	 Slider sl3 = new Slider();
	 Slider sl4 = new Slider();
	 Slider sl5 = new Slider();
	 Slider sl6 = new Slider();
			 
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    sl1.setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.DEFAULT);

    sl2.setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.DANGER);

    sl3.setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.GRAY);

    sl4.setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.INFO);

    sl5.setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.SUCCESS);

    sl6.setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.WARNING);

    window.add(
        new Element("<html><b>DEFAULT</b></html>"), sl1,
        new Element("<html><b>DANGER</b></html>"), sl2,
        new Element("<html><b>GRAY</b></html>"), sl3,
        new Element("<html><b>INFO</b></html>"), sl4,
        new Element("<html><b>SUCCESS</b></html>"), sl5,
        new Element("<html><b>WARNING</b></html>"), sl6);
  }
}
