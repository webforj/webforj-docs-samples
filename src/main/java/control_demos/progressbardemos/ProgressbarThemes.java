package control_demos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcAppInitializeException;

import org.dwcj.controls.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/theme_styles.css")

public class ProgressbarThemes extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");

        ProgressBar pb1 = new ProgressBar();
        ProgressBar pb2 = new ProgressBar();
        ProgressBar pb3 = new ProgressBar();
        ProgressBar pb4 = new ProgressBar();
        ProgressBar pb6 = new ProgressBar();
        ProgressBar pb7 = new ProgressBar();

        panel.add(pb1,pb2,pb3,pb4,pb6,pb7);

        pb1.setAttribute("theme","default").setMaximum(100).setValue(80).setText("DEFAULT");
        pb2.setAttribute("theme","danger").setMaximum(100).setValue(70).setText("DANGER");
        pb3.setAttribute("theme","gray").setMaximum(100).setValue(60).setText("GRAY");
        pb4.setAttribute("theme","info").setMaximum(100).setValue(50).setText("INFO");
        pb6.setAttribute("theme","success").setMaximum(100).setValue(30).setText("SUCCESS");
        pb7.setAttribute("theme","warning").setMaximum(100).setValue(20).setText("WARNING");
    }
    
}
    