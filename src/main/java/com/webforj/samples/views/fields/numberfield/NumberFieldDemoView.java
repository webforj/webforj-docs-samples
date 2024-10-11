package com.webforj.samples.views.fields.numberfield;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.NumberField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fields/datefield/dateFieldDemo.css")
@Route
@FrameTitle("Number Field Demo")
public class NumberFieldDemoView extends Composite<Div> {

  public NumberFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    NumberField numField = new NumberField();
    numField.addClassName("date__input");
    numField.setLabel("Quantity:");

    getBoundComponent().add(numField);
  }
}