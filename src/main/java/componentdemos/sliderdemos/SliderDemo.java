package componentdemos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import org.dwcj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/demo_styles.css")
public class SliderDemo extends App {
	
	Slider sl1 = new Slider();

    @Override
    public void run() throws DwcjException {

        Frame window = new Frame();
        window.addClassName("Frame");
        
        sl1.setMaximum(100).setMinimum(0);   
        window.add(sl1);
    }

}
