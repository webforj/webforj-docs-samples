package componentdemos.checkboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

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
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");
    window.add(checkbox);

    checkbox.onCheck(e -> checkbox.setText("You have accepted the Terms and Conditions"));
    checkbox.onUncheck(e -> checkbox.setText("Please check to accept the Terms and Conditions"));
  }
}
