package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Panel;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/disable_styles.css")
public class ButtonDisable extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Panel disabled = new Panel();
    disabled.addClassName("disabledButtons");

    window.add(disabled);

    Button defaultButton = new Button("DEFAULT DISABLED");
    Button primaryButton = new Button("PRIMARY DISABLED");
    Button successButton = new Button("SUCCESS DISABLED");
    Button dangerButton = new Button("DANGER DISABLED");
    Button defaultButton2 = new Button("DEFAULT");
    Button primaryButton2 = new Button("PRIMARY");
    Button successButton2 = new Button("SUCCESS");
    Button dangerButton2 = new Button("DANGER");

    disabled.add(defaultButton2,
        primaryButton2,
        successButton2,
        dangerButton2,
        defaultButton,
        primaryButton,
        successButton,
        dangerButton);

    defaultButton.setTheme(ButtonTheme.DEFAULT);
    defaultButton2.setTheme(ButtonTheme.DEFAULT);
    primaryButton.setTheme(ButtonTheme.PRIMARY);
    primaryButton2.setTheme(ButtonTheme.PRIMARY);
    successButton.setTheme(ButtonTheme.SUCCESS);
    successButton2.setTheme(ButtonTheme.SUCCESS);
    dangerButton.setTheme(ButtonTheme.DANGER);
    dangerButton2.setTheme(ButtonTheme.DANGER);

    defaultButton.setEnabled(false);
    primaryButton.setEnabled(false);
    successButton.setEnabled(false);
    dangerButton.setEnabled(false);
  }
}
