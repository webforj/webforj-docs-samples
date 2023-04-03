package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Panel;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/buttonstyles/disable_styles.css")
public class ButtonDisable extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Panel disabled = new Panel();
    disabled.addClassName("disabledButtons");

    panel.add(disabled);

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

    defaultButton.setTheme(Button.Theme.DEFAULT);
    defaultButton2.setTheme(Button.Theme.DEFAULT);
    primaryButton.setTheme(Button.Theme.PRIMARY);
    primaryButton2.setTheme(Button.Theme.PRIMARY);
    successButton.setTheme(Button.Theme.SUCCESS);
    successButton2.setTheme(Button.Theme.SUCCESS);
    dangerButton.setTheme(Button.Theme.DANGER);
    dangerButton2.setTheme(Button.Theme.DANGER);

    defaultButton.setEnabled(false);
    primaryButton.setEnabled(false);
    successButton.setEnabled(false);
    dangerButton.setEnabled(false);
  }
}
