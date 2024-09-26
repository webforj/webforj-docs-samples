package com.webforj.samples.views.fields.passwordfield;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.field.PasswordField;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
@Route
@FrameTitle("Password Field Demo")
public class PasswordFieldDemoView extends Composite<Div> {

  public PasswordFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    PasswordField passwordField = new PasswordField();
    passwordField.addClassName("date__input");
    passwordField.setLabel("Enter your Password:");
    passwordField.setPlaceholder("Password");

    getBoundComponent().add(passwordField);
  }
}