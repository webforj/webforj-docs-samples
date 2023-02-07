package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import java.lang.Math;

import org.dwcj.controls.progressbar.ProgressBar;

public class ProgressbarPlaceholders extends App{

    ProgressBar pb;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");
        

        pb = new ProgressBar();

        panel.add(pb);

        pb.setStyle("width", "400px");
        pb.setMaximum(200);

        pb.setText("{{x}} , {{value}}");
        

        

    }
    
}
    