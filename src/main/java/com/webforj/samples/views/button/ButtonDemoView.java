package com.webforj.samples.views.button;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * Simple demo application to display button functionality.
 */
@InlineStyleSheet("context://css/button/buttonDemo.css")
@Route
@FrameTitle("Button Demo")
public class ButtonDemoView extends Composite<FlexLayout> {

  Button clear;
  Button submit;
  TextField firstName;
  TextField lastName;
  TextField email;

  public ButtonDemoView() {

    getBoundComponent().setDirection(FlexDirection.COLUMN).setSpacing("var(--dwc-space-l)")
        .setAlignment(FlexAlignment.CENTER).setMargin("var(--dwc-space-l)").setHeight("100dvh");
    clear = new Button("Clear", ButtonTheme.DEFAULT, e -> {
      firstName.setText("");
      lastName.setText("");
      email.setText("");
    });

    submit = new Button("Submit", ButtonTheme.PRIMARY,
        e -> showMessageDialog("Welcome to the application " + firstName.getText() + " " + lastName.getText() + "!"));

    firstName = new TextField(Type.TEXT, "First Name", "Jason");
    lastName = new TextField(Type.TEXT, "Last Name", "Turner");
    email = new TextField(Type.EMAIL, "E-mail:", "turner.jason@email.com");

    FlexLayout firstRow = FlexLayout.create(firstName, lastName)
        .justify().center()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row");

    FlexLayout secondRow = FlexLayout.create(email)
        .justify().center()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row");

    FlexLayout thirdRow = FlexLayout.create(submit, clear)
        .justify().end()
        .wrap()
        .build()
        .setSpacing("20px")
        .addClassName("row", "buttons");

    getBoundComponent().add(firstRow, secondRow, thirdRow);
  }
}