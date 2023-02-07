package control_demos.sliderdemos;



import org.dwcj.App;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.slider.Slider;

public class SliderTickDemo extends App{

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

        // Map<Integer, String> map = Map.ofEntries(
        //     entry(0, "0"),
        //     entry(10, "10"),
        //     entry(20, "20"),
        //     entry(25, "25"),
        //     entry(30, "30"),
        //     entry(40, "40"),
        //     entry(50, "50"),
        //     entry(60, "60"),
        //     entry(70, "70"),
        //     entry(75, "75"),
        //     entry(80, "80"),
        //     entry(90, "90"),
        //     entry(100, "100")
        // );

        panel.add(
            new Label("<html><b>No Tick Snapping</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl1,
            new Label("<html><b>Tick Snapping</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl2
            );
        sl1.setPaintTicks(true);
        sl1.setMajorTickSpacing(50);
        sl1.setMinorTickSpacing(10);
        
        sl2.setPaintTicks(true);
        sl2.setMajorTickSpacing(50);
        sl2.setMinorTickSpacing(10);
        sl2.setSnapToTicks(true);
        // sl1.setPaintLabels(true);
        // sl1.setLabels(map);




        

    }
    
}
    