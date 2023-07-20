package componentdemos.dateeditboxdemos;

import org.dwcj.App;
import org.dwcj.component.maskeddatefield.MaskedDateField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

public class DateEditBoxDemo extends App {

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame window = new Frame();
    panel.setStyle("display", "inline-grid");
    panel.setStyle("grid-template-columns", "1fr");
    panel.setStyle("padding", "10px");
    panel.setStyle("gap", "50px");

    MaskedDateField d1 = new MaskedDateField();

    panel.add(d1);

    d1.setAttribute("visible-calender-icon", "true");

  }

}
