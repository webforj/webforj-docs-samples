package componentdemos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/*css */"""
  .frame {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 50px;
    margin: 10px;
  }  
""")
public class CheckboxEventDemo extends App {

  CheckBox checkbox = new CheckBox("Please check to accept the Terms and Conditions");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");
    window.add(checkbox);

    checkbox.onCheck(e -> checkbox.setText("You have accepted the Terms and Conditions"));
    checkbox.onUncheck(e -> checkbox.setText("Please check to accept the Terms and Conditions"));
  }
}
