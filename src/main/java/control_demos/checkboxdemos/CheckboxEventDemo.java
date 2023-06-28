package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.checkbox.CheckBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class CheckboxEventDemo extends App {
  
  CheckBox checkbox;

  @Override
  public void run() throws DwcjException {

    Frame panel = new Frame()
      .addClassName("Frame");
    checkbox = new CheckBox()
      .setText("Check Me!");
    panel.add(checkbox);

    checkbox.onCheck( e -> checkbox.setText("Checkbox is Checked!") );
    
    checkbox.onUncheck( e -> checkbox.setText("Checkbox is Unchecked!") );

  }
  
}
