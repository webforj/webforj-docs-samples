package componentdemos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

/**
 * Application to show the disabled functionality of a button.
 */
@InlineStyleSheet("context://css/buttonstyles/disable_styles.css")
public class ButtonDisable extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Panel disabled = new Panel();
    disabled.addClassName("disabledButtons");

    window.add(disabled);

    Button defaultButtonDisabled = new Button("DEFAULT DISABLED");
    Button primaryButtonDisabled = new Button("PRIMARY DISABLED");
    Button successButtonDisabled = new Button("SUCCESS DISABLED");
    Button dangerButtonDisabled = new Button("DANGER DISABLED");
    Button defaultButton = new Button("DEFAULT");
    Button primaryButton = new Button("PRIMARY");
    Button successButton = new Button("SUCCESS");
    Button dangerButton = new Button("DANGER");

    disabled.add(defaultButton,
        primaryButton,
        successButton,
        dangerButton,
        defaultButtonDisabled,
        primaryButtonDisabled,
        successButtonDisabled,
        dangerButtonDisabled);

    defaultButtonDisabled.setTheme(ButtonTheme.DEFAULT);
    defaultButton.setTheme(ButtonTheme.DEFAULT);
    primaryButtonDisabled.setTheme(ButtonTheme.PRIMARY);
    primaryButton.setTheme(ButtonTheme.PRIMARY);
    successButtonDisabled.setTheme(ButtonTheme.SUCCESS);
    successButton.setTheme(ButtonTheme.SUCCESS);
    dangerButtonDisabled.setTheme(ButtonTheme.DANGER);
    dangerButton.setTheme(ButtonTheme.DANGER);

    defaultButtonDisabled.setEnabled(false);
    primaryButtonDisabled.setEnabled(false);
    successButtonDisabled.setEnabled(false);
    dangerButtonDisabled.setEnabled(false);
  }
}
