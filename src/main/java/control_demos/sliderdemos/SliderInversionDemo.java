package control_demos.sliderdemos;

import java.util.Map;
import static java.util.Map.entry;

import org.dwcj.App;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.slider.Slider;
import org.dwcj.controls.slider.Slider.Orientation;

public class SliderInversionDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "10px");
        panel.setStyle("width", "100%");
        panel.setStyle("justify-items", "center");

        Map<Integer, String> mapMatch = Map.ofEntries(
            entry(0, "0"),
            entry(50, "50"),
            entry(100, "100")
        );
        
        
        Slider sl1 = new Slider().setMaximum(100).setMinimum(0);        
        Slider sl2 = new Slider().setMaximum(100).setMinimum(0);
        
        panel.add(new Label("<html><b>Original:</b></html>"),sl1,new Label("<html><b>Inverted:</b></html>"),sl2);
        
        sl1.setStyle("width", "400px").setPaintTicks(true).setMinorTickSpacing(10).setPaintLabels(true).setLabels(mapMatch);
        
        sl2.setStyle("width", "400px").setPaintTicks(true).setMinorTickSpacing(10).setPaintLabels(true).setLabels(mapMatch).setAttribute("inverted","true");
    }
    
}
    