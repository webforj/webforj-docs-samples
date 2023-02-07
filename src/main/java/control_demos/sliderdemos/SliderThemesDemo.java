package control_demos.sliderdemos;

import org.dwcj.App;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.slider.Slider;

public class SliderThemesDemo extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "10px");
        panel.setStyle("width", "100%");
        panel.setStyle("justify-items", "center");

        Slider sl1 = new Slider().setMaximum(100).setMinimum(0).setValue(50).setTheme(Slider.Theme.DEFAULT);
        Slider sl2 = new Slider().setMaximum(100).setMinimum(0).setValue(50).setTheme(Slider.Theme.DANGER);
        Slider sl3 = new Slider().setMaximum(100).setMinimum(0).setValue(50).setTheme(Slider.Theme.GRAY);
        Slider sl4 = new Slider().setMaximum(100).setMinimum(0).setValue(50).setTheme(Slider.Theme.INFO);
        Slider sl5 = new Slider().setMaximum(100).setMinimum(0).setValue(50).setTheme(Slider.Theme.SUCCESS);
        Slider sl6 = new Slider().setMaximum(100).setMinimum(0).setValue(50).setTheme(Slider.Theme.WARNING);
        sl1.setStyle("width", "500px");
        sl2.setStyle("width", "500px");
        sl3.setStyle("width", "500px");
        sl4.setStyle("width", "500px");
        sl5.setStyle("width", "500px");
        sl6.setStyle("width", "500px");

        

        panel.add(
            new Label("<html><b>DEFAULT</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl1,
            new Label("<html><b>DANGER</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl2,
            new Label("<html><b>GRAY</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl3,
            new Label("<html><b>INFO</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl4,
            new Label("<html><b>SUCCESS</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl5,
            new Label("<html><b>WARNING</b></html>").setStyle("grid-column", "1").setStyle("margin", "5px 0 0 10px"), sl6
            );




        

    }
    
}
    