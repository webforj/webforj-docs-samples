package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.progressbar.ProgressBar;

public class ProgressbarOrientation extends App{

    ProgressBar pb;
    ProgressBar pb2;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 2fr");
        panel.setStyle("padding", "10px 10px 10px 50px");
        panel.setStyle("gap", "50px");
        

        pb = new ProgressBar();
        pb2 = new ProgressBar();

        panel.add(pb2, pb);

        pb.setAttribute("orientation", "vertical");
        pb.setStyle("height", "400px");
        pb.setStyle("width", "30px");
        pb.setStyle("grid-column", "2");
        pb.setStyle("justify-self", "center");
        pb.setValue(75);
        pb.setMaximum(100);
        
        
        
        pb2.setStyle("width", "400px");
        pb2.setStyle("height", "30px");
        pb2.setStyle("align-self", "center");
        pb2.setStyle("grid-column", "1");
        pb2.setValue(75);
        pb2.setMaximum(100);



        

    }
    
}
    