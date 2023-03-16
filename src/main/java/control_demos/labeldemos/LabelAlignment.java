package control_demos.labeldemos;

import org.dwcj.interfaces.TextAlignable;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.exceptions.DwcAppInitializeException;

@InlineStyleSheet("context://css/labelstyles/alignment_styles.css")
public class LabelAlignment extends App{

    @Override
    public void run() throws DwcAppInitializeException { 

        AppPanel panel = new AppPanel();
        panel.addClassName("appPanel");
        
        Label l1 = new Label("<html><b>LEFT-ALIGNED TEXT</b><br></br> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </html>");
        Label l2 = new Label("<html><b>CENTER-ALIGNED TEXT</b><br></br> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </html>");
        Label l3 = new Label("<html><b>RIGHT-ALIGNED TEXT</b><br></br> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </html>");
        panel.add(l1,l2,l3);
        l1.setTextAlignment(TextAlignable.Alignment.LEFT);
        l2.setTextAlignment(TextAlignable.Alignment.MIDDLE);
        l3.setTextAlignment(TextAlignable.Alignment.RIGHT);


    }
    
    }
    