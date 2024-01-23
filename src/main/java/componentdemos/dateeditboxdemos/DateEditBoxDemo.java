package componentdemos.dateeditboxdemos;

import org.dwcj.App;
import org.dwcj.component.maskeddatefield.MaskedDateField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DateEditBoxDemo extends App {
	
	MaskedDateField d1 = new MaskedDateField();

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.setStyle("display", "inline-grid");
    window.setStyle("grid-template-columns", "1fr");
    window.setStyle("padding", "10px");
    window.setStyle("gap", "50px");

    window.add(d1);

    d1.setAttribute("visible-calender-icon", "true");

  }

}
