package com.webforj.samples.views.checkbox;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.event.ToggleEvent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/checkbox/checkboxIndeterminate.css")
@Route
@FrameTitle("Checkbox Indeterminate")
public class CheckboxIndeterminateView extends Composite<FlexLayout> {

  CheckBox indeterminate = new CheckBox("Parent");
  CheckBox child1 = new CheckBox("Child 1");
  CheckBox child2 = new CheckBox("Child 2");

  public CheckboxIndeterminateView() {
    getBoundComponent().addClassName("Frame");

    indeterminate.setIndeterminate(true);
    indeterminate.addToggleListener(this::indeterminateToggle);

    child1.setChecked(false).addClassName("child-box")
        .addToggleListener(this::onCheck);

    child2.setChecked(true).addClassName("child-box")
        .addToggleListener(this::onCheck);

    getBoundComponent().add(indeterminate, child1, child2);
  }

  private void onCheck(ToggleEvent e) {
    if (child1.isChecked() && child2.isChecked()) {
      indeterminate.setChecked(true);
    } else {
      if (child1.isChecked() || child2.isChecked()) {
        indeterminate.setChecked(false);
        indeterminate.setIndeterminate(true);
      } else {
        indeterminate.setIndeterminate(false);
        indeterminate.setChecked(false);
      }
    }
  }

  private void indeterminateToggle(ToggleEvent e) {
    if (e.isToggled()) {
      child1.setChecked(true);
      child2.setChecked(true);
    } else {
      child1.setChecked(false);
      child2.setChecked(false);
    }
  }
}
