package componentdemos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(id = "login-form", value = /* css */"""
  .loginForm {
    background-color: #263238;
    background-image: url(https://images.pling.com/img/00/00/59/97/06/1588511/1c58fba17fc4c48cd52cf17dd3f36556396e73e34a3d37e5aec6098ccdb01f3d1867.jpg);
    background-size: 100% 100%;
    background-repeat: no-repeat;
  }
""")
@InlineStyleSheet("context://css/dialogstyles/dialog_styles.css")
public class DialogBackdropBlur extends App {

  private Dialog dialog = new Dialog();
  private Button backgroundBlur = new Button("Toggle Background Blur");

  @Override
  public void run() throws DwcjException {
    Frame p = new Frame();
    p.add(dialog);
    dialog.addClassName("loginForm");
    dialog.addToHeader(new Label("Background Blur"));
    dialog.addToContent(backgroundBlur);
    dialog.setCloseable(false);
    dialog.open();
    backgroundBlur.setStyle("display", "flex")
        .setStyle("justify-content", "center")
        .onClick(e -> dialog.setBlurred(!dialog.isBlurred()));
  }
}
