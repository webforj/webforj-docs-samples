package componentdemos.optiondialog.input;

import com.webforj.App;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.optiondialog.InputDialog;
import com.webforj.component.optiondialog.OptionDialog;
import com.webforj.component.optiondialog.MessageDialog;

public class InputDialogType extends App {
  InputDialog dialog;

  @Override
  public void run() throws WebforjException {
    dialog = new InputDialog(
        "This page is restricted. Please enter your password to continue.",
        "Restricted access.",
        InputDialog.InputType.PASSWORD);

    dialog.setFirstButtonText("Continue");
    dialog.setSecondButtonText("Cancel");
    dialog.setFirstButtonTheme(ButtonTheme.PRIMARY);

    tryLogin();
  }

  public void tryLogin() {
    String result = dialog.show();

    if (result != null && !result.isEmpty()) {
      OptionDialog.showMessageDialog("Access granted", "Welcome", "Got it", MessageDialog.MessageType.INFO);
    } else {
      OptionDialog.showMessageDialog("Access denied", "Access denied", "Try again", MessageDialog.MessageType.ERROR);
      tryLogin();
    }
  }
}
