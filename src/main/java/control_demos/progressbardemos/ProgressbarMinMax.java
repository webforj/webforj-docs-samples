package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.progressbar.ProgressBar;

public class ProgressbarMinMax extends App{

    ProgressBar pb;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("width", "100%");
        panel.setStyle("height", "100%");
        

        pb = new ProgressBar();
        Label lb = new Label("Min set to 50, Max to 200");
        panel.add(lb, pb);

        lb.setStyle("justify-self", "center");
        lb.setStyle("align-self", "center");
        pb.setStyle("justify-self", "center");
        pb.setStyle("align-self", "center");
        pb.setStyle("width", "400px");
        pb.setText("100/200");
        pb.setMinimum(50);
        pb.setMaximum(200);
        pb.setValue(100);

        

    }
    
}
    