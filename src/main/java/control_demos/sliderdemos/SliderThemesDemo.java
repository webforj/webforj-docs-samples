package control_demos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/theme_styles.css")
public class SliderThemesDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Slider sl1 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.DEFAULT);

    Slider sl2 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.DANGER);

    Slider sl3 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.GRAY);

    Slider sl4 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.INFO);

    Slider sl5 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.SUCCESS);

    Slider sl6 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.WARNING);

    panel.add(
        new Label("<html><b>DEFAULT</b></html>"), sl1,
        new Label("<html><b>DANGER</b></html>"), sl2,
        new Label("<html><b>GRAY</b></html>"), sl3,
        new Label("<html><b>INFO</b></html>"), sl4,
        new Label("<html><b>SUCCESS</b></html>"), sl5,
        new Label("<html><b>WARNING</b></html>"), sl6);
  }
}
