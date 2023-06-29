package control_demos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/demo_styles.css")
public class SliderDemo extends App {

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame panel = new Frame();
        panel.addClassName("Frame");

        Slider sl1 = new Slider().setMaximum(100).setMinimum(0);
        panel.add(sl1);
    }

}
