package control_demos.dialogdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;


@InlineStyleSheet(id = "login-form", value = "" +
".loginForm {" +
      "   background-color: #263238;" +
      "   background-image: url(https://images.pling.com/img/00/00/59/97/06/1588511/1c58fba17fc4c48cd52cf17dd3f36556396e73e34a3d37e5aec6098ccdb01f3d1867.jpg);" +
      "   background-size: 100% 100%;" +
      "   background-repeat: no-repeat;" +
      "}"
)
public class DialogBackdropBlur extends App {
    Dialog dialog;

    @Override
    public void run() throws DwcException{
        AppPanel p = new AppPanel();
        dialog = new Dialog();
        p.add(dialog);
        dialog.addClassName("loginForm");

        dialog.getHeader().add(new Label("Header"));
        dialog.getContent().add(new Button("Toggle Background Blur").onClick(this::buttonClick));
        dialog.getFooter().add(new Label("Footer"));
        dialog.setCloseable(false);
        dialog.show();
    }

    private void buttonClick(ButtonClickEvent ev){
        dialog.setBlurred(!dialog.isBlurred());
    }
}
