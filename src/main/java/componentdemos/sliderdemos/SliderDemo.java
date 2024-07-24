package componentdemos.sliderdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/demo_styles.css")
public class SliderDemo extends App {

    @Override
    public void run() throws WebforjException {

        Frame window = new Frame();
        window.addClassName("Frame");

        Slider sl1 = new Slider().setMax(100).setMin(0);
        window.add(sl1);
    }

}
