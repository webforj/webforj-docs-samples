package componentdemos.dateeditboxdemos;

import org.dwcj.App;
import org.dwcj.component.maskeddatefield.MaskedDateField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

public class DateEditBoxDemo extends App {

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame window = new Frame();
    window.setStyle("display", "inline-grid");
    window.setStyle("grid-template-columns", "1fr");
    window.setStyle("padding", "10px");
    window.setStyle("gap", "50px");

    MaskedDateField d1 = new MaskedDateField();

    window.add(d1);

    d1.setAttribute("visible-calender-icon", "true");

  }

}
