package control_demos.sliderdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.slider.Slider;

public class SliderDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        Slider sl1 = new Slider().setMaximum(100).setMinimum(0);
        sl1.setStyle("width", "400px");

        panel.add(sl1);



        

    }
    
}
    