package control_demos.sliderdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;
import org.dwcj.controls.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/tick_styles.css")

public class SliderTickDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");        

        Slider sl1 = new Slider().setMaximum(100).setMinimum(0);
        Slider sl2 = new Slider().setMaximum(100).setMinimum(0);

        panel.add(
            new Label("<html><b>No Tick Snapping</b></html>"), sl1,
            new Label("<html><b>Tick Snapping</b></html>"), sl2
        );

        sl1.setPaintTicks(true)
            .setMajorTickSpacing(50)
            .setMinorTickSpacing(10);
        
        sl2.setPaintTicks(true)
            .setMajorTickSpacing(50)
            .setMinorTickSpacing(10)
            .setSnapToTicks(true);  
            
    }
    
}
    