package componentdemos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.event.ToggleEvent;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/indeterminate_styles.css")
public class CheckboxIndeterminate extends App {
  
  CheckBox indeterminate; 
  CheckBox child1;  
  CheckBox child2;  
  
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    indeterminate = new CheckBox().setText("Parent").setIndeterminate(true);
    child1 = new CheckBox();
    child1.setText("Child 1")
        .setChecked(false)
        .addToggleListener(this::onCheck)
        .addClassName("child-box");

    child2 = new CheckBox();
    child2.setText("Child 2")
        .setChecked(true)
        .addToggleListener(this::onCheck)
        .addClassName("child-box");

    panel.add(indeterminate, child1, child2);
  }

  private void onCheck(ToggleEvent e) {
    if (child1.isChecked() && child2.isChecked()) {
      indeterminate.setChecked(true);
    }
    else {
      if (child1.isChecked() || child2.isChecked()) {
        indeterminate.setChecked(false);
        indeterminate.setIndeterminate(true);
      }
      else {
        indeterminate.setIndeterminate(false);
        indeterminate.setChecked(false);
      }
    }
  }

}
