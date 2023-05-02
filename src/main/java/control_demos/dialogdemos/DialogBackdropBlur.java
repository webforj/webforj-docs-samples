package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.label.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(id = "login-form", value = "" +
    ".loginForm {" +
    "   background-color: #263238;" +
    "   background-image: url(https://images.pling.com/img/00/00/59/97/06/1588511/1c58fba17fc4c48cd52cf17dd3f36556396e73e34a3d37e5aec6098ccdb01f3d1867.jpg);"
    +
    "   background-size: 100% 100%;" +
    "   background-repeat: no-repeat;" +
    "}")

@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogBackdropBlur extends App {
  Dialog dialog;

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    dialog = new Dialog();
    p.add(dialog);
    dialog.addClassName("loginForm");

    dialog.getHeader().add(new Label("Background Blur"));
    dialog.getContent().add(new Button("Toggle Background Blur")
      .onClick(this::buttonClick))
      .setStyle("display","flex")
      .setStyle("justify-content", "center");

    dialog.setCloseable(false);
    dialog.show();
  }

  private void buttonClick(ButtonClickEvent ev) {
    dialog.setBlurred(!dialog.isBlurred());
  }
}
