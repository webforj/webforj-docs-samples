package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.progressbar.ProgressBar;

public class ProgressbarThemes extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.setStyle("display", "flex");
        panel.setStyle("flex-direction", "column");
        panel.setStyle("width", "100%");
        panel.setStyle("height", "100%");
        panel.setStyle("justify-content", "center");
        panel.setStyle("align-items", "center");
        panel.setStyle("gap", "20px");
        

        ProgressBar pb1 = new ProgressBar();
        ProgressBar pb2 = new ProgressBar();
        ProgressBar pb3 = new ProgressBar();
        ProgressBar pb4 = new ProgressBar();
        // ProgressBar pb5 = new ProgressBar();
        ProgressBar pb6 = new ProgressBar();
        ProgressBar pb7 = new ProgressBar();

        panel.add(pb1,pb2,pb3,pb4,pb6,pb7);

        pb1.setAttribute("theme","default").setStyle("width", "400px").setMaximum(100).setValue(80).setText("DEFAULT");
        pb2.setAttribute("theme","danger").setStyle("width", "400px").setMaximum(100).setValue(70).setText("DANGER");
        pb3.setAttribute("theme","gray").setStyle("width", "400px").setMaximum(100).setValue(60).setText("GRAY");
        pb4.setAttribute("theme","info").setStyle("width", "400px").setMaximum(100).setValue(50).setText("INFO");
        // pb5.setAttribute("theme","primary").setStyle("width", "400px").setMaximum(100).setValue(40).setText("PRIMARY");
        pb6.setAttribute("theme","success").setStyle("width", "400px").setMaximum(100).setValue(30).setText("SUCCESS");
        pb7.setAttribute("theme","warning").setStyle("width", "400px").setMaximum(100).setValue(20).setText("WARNING");

        

    }
    
}
    