package com.webforj.samples.views.checkbox;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/*css */"""
  .frame {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 50px;
    margin: 10px;
  }  
""")
@Route
@FrameTitle("Checkbox Event")
public class CheckboxEventView extends Composite<Div> {

  CheckBox checkbox = new CheckBox("Please check to accept the Terms and Conditions");

  public CheckboxEventView() {
    getBoundComponent().addClassName("frame");
    getBoundComponent().add(checkbox);

    checkbox.onCheck(e -> checkbox.setText("You have accepted the Terms and Conditions"));
    checkbox.onUncheck(e -> checkbox.setText("Please check to accept the Terms and Conditions"));
  }
}
