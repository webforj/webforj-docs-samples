package componentdemos.buttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

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
  public void run() throws WebforjException {
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