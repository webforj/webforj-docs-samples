package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.field.TextField;
import org.dwcj.component.field.TextField.Type;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/*css */"""
  .window {
    display: flex;
    align-items: flex-end;
    margin: 20px;
    gap: 50px;
    width: 100%;
    flex-wrap: wrap;
  }
""")
public class ButtonDisable extends App {

  TextField email = new TextField();
  Button submit = new Button("Submit");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("window");
    window.add(email, submit);

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

    submit.setTheme(ButtonTheme.PRIMARY)
        .setEnabled(false);
  }
}