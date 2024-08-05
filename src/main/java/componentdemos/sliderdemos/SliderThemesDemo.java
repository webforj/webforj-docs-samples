package componentdemos.sliderdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.Theme;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/theme_styles.css")
public class SliderThemesDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Slider sl1 = new Slider().setMax(100)
        .setMin(0)
        .setValue(50)
        .setTheme(Theme.DEFAULT)
        .setWidth("500px");

    Slider sl2 = new Slider().setMax(100)
        .setMin(0)
        .setValue(50)
        .setTheme(Theme.DANGER)
        .setWidth("500px");

    Slider sl3 = new Slider().setMax(100)
        .setMin(0)
        .setValue(50)
        .setTheme(Theme.GRAY)
        .setWidth("500px");

    Slider sl4 = new Slider().setMax(100)
        .setMin(0)
        .setValue(50)
        .setTheme(Theme.INFO)
        .setWidth("500px");

    Slider sl5 = new Slider().setMax(100)
        .setMin(0)
        .setValue(50)
        .setTheme(Theme.SUCCESS)
        .setWidth("500px");

    Slider sl6 = new Slider().setMax(100)
        .setMin(0)
        .setValue(50)
        .setTheme(Theme.WARNING)
        .setWidth("500px");

    window.add(
        new Label("<html><b>DEFAULT</b></html>"), sl1,
        new Label("<html><b>DANGER</b></html>"), sl2,
        new Label("<html><b>GRAY</b></html>"), sl3,
        new Label("<html><b>INFO</b></html>"), sl4,
        new Label("<html><b>SUCCESS</b></html>"), sl5,
        new Label("<html><b>WARNING</b></html>"), sl6);
  }
}
