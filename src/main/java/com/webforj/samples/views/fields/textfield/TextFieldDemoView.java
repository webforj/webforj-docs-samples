package com.webforj.samples.views.fields.textfield;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fields/datefield/dateFieldDemo.css")
@Route
@FrameTitle("Text Field Demo")
public class TextFieldDemoView extends Composite<Div> {

  public TextFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    TextField emailField = new TextField()
        .setType(Type.EMAIL);
    TextField searchField = new TextField()
        .setType(Type.SEARCH);
    TextField telField = new TextField()
        .setType(Type.TEL);
    TextField textField = new TextField()
        .setType(Type.TEXT);
    TextField urlField = new TextField()
        .setType(Type.URL);

    getBoundComponent().add(emailField, searchField, telField, textField, urlField);
  }
}