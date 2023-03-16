package control_demos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/demo_styles.css")
public class SliderDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        Slider sl1 = new Slider().setMaximum(100).setMinimum(0);
        panel.add(sl1);
    }
    
}
    