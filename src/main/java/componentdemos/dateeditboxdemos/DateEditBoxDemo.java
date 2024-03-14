package componentdemos.dateeditboxdemos;

import com.webforj.App;
import com.webforj.component.maskeddatefield.MaskedDateField;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class DateEditBoxDemo extends App {
	
	MaskedDateField d1 = new MaskedDateField();

  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.setStyle("display", "inline-grid");
    window.setStyle("grid-template-columns", "1fr");
    window.setStyle("padding", "10px");
    window.setStyle("gap", "50px");

    window.add(d1);

    d1.setAttribute("visible-calender-icon", "true");

  }

}
