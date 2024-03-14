package componentdemos.checkboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.event.ToggleEvent;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/checkboxstyles/indeterminate_styles.css")
public class CheckboxIndeterminate extends App {
  
  CheckBox indeterminate = new CheckBox("Parent");
  CheckBox child1 = new CheckBox("Child 1");
  CheckBox child2 = new CheckBox("Child 2");
  
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    indeterminate.setIndeterminate(true);
    indeterminate.addToggleListener(this::indeterminateToggle);

    child1.setChecked(false)
        .addClassName("child-box")
        .addToggleListener(this::onCheck);


    child2.setChecked(true)
        .addClassName("child-box")
        .addToggleListener(this::onCheck);

    window.add(indeterminate, child1, child2);
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
  
  private void indeterminateToggle(ToggleEvent e) {
    if(e.isToggled()){
      child1.setChecked(true);
      child2.setChecked(true);
    }
    else{
      child1.setChecked(false);
      child2.setChecked(false);
    }
  }
}
