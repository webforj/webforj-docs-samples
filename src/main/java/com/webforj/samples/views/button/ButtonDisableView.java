package com.webforj.samples.views.button;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/*css */"""
  .window {
    display: flex;
    align-items: flex-end;
    margin: 20px;
    gap: 50px;
    flex-wrap: wrap;
  }
""")
@Route
@FrameTitle("BUtton Disable")
public class ButtonDisableView extends Composite<Div> {

  TextField email = new TextField();
  Button submit = new Button("Submit", ButtonTheme.PRIMARY);

  public ButtonDisableView() {
    getBoundComponent().addClassName("window");
    getBoundComponent().add(email, submit);
    getBoundComponent().setWidth("100%");

    email.setType(Type.EMAIL)
        .setLabel("Enter an email")
        .onModify(e -> {
          if(e.getText().contains("@")){
            submit.setEnabled(true);
          }
          else{
            submit.setEnabled(false);
          }
        });

    submit.setEnabled(false);
  }
}