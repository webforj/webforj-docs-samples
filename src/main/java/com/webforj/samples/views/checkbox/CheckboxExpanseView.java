package com.webforj.samples.views.checkbox;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Expanse;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/checkboxstyles/expanse_styles.css")
@Route
@FrameTitle("Checkbox Expanses")
public class CheckboxExpanseView extends Composite<Div> {
  
  public CheckboxExpanseView() {
    getBoundComponent().addClassName("Frame");

    for (int i = Expanse.values().length - 1; i >= 0; i--) {
      CheckBox expanseCheckBox = new CheckBox(Expanse.values()[i].name());
      getBoundComponent().add(expanseCheckBox.setExpanse(Expanse.values()[i]));
    }

  }
}
