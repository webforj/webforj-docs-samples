package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.progressbar.ProgressBar;

public class ProgressbarIndeterminate extends App{

    ProgressBar pb;

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("width", "100%");
        panel.setStyle("height", "100%");
        

        pb = new ProgressBar();
        Div div = new Div();
        

        panel.add(div);
        div.setStyle("display", "grid");
        div.setStyle("justify-content", "center");
        div.setStyle("align-items", "center");
        div.setStyle("width", "100%");
        div.setStyle("height", "100%");
        div.add(pb);

        // pb.setAttribute("indeterminate", "true");
        pb.setIndeterminate(true);
        pb.setStyle("width", "400px");
        pb.setText("Syncing Files");


        

    }
    
}
    