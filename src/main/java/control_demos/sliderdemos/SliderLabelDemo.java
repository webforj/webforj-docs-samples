package control_demos.sliderdemos;

import java.util.Map;
import static java.util.Map.entry;

import org.dwcj.App;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.slider.Slider;

public class SliderLabelDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "10px");
        panel.setStyle("width", "100%");
        panel.setStyle("justify-items", "center");
        

        Slider sl1 = new Slider().setMaximum(100).setMinimum(0);
        sl1.setStyle("width", "500px");
        Slider sl2 = new Slider().setMaximum(100).setMinimum(0);
        sl2.setStyle("width", "500px");
        Slider sl3 = new Slider().setMaximum(100).setMinimum(0);
        sl3.setStyle("width", "500px");

        Map<Integer, String> mapMatch = Map.ofEntries(
            entry(0, "0"),
            entry(10, "10"),
            entry(20, "20"),
            entry(25, "25"),
            entry(30, "30"),
            entry(40, "40"),
            entry(50, "50"),
            entry(60, "60"),
            entry(70, "70"),
            entry(75, "75"),
            entry(80, "80"),
            entry(90, "90"),
            entry(100, "100")
        );

        Map<Integer, String> mapNoMatch = Map.ofEntries(
            entry(15, "15"),
            entry(35, "35"),
            entry(65, "65"),
            entry(85, "85")
        );

        panel.add(
        new Label("<html><b>Labels applied with ticks disabled</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl1,
            new Label("<html><b>Labels applied to tick values</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl2,
            new Label("<html><b>Labels applied to non-tick values</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl3
            );
        
        sl1.setPaintLabels(true);
        sl1.setLabels(mapMatch);
        sl1.setSnapToTicks(true);

        sl2.setPaintTicks(true);
        sl2.setMajorTickSpacing(50);
        sl2.setMinorTickSpacing(10);
        sl2.setPaintLabels(true);
        sl2.setLabels(mapMatch);
        sl2.setSnapToTicks(true);

        sl3.setPaintTicks(true);
        sl3.setMajorTickSpacing(50);
        sl3.setMinorTickSpacing(10);
        sl3.setPaintLabels(true);
        sl3.setLabels(mapNoMatch);
        sl3.setSnapToTicks(true);
        



        

    }
    
}
    