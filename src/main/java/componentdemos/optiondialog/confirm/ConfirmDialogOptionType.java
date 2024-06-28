package componentdemos.optiondialog.confirm;

import com.webforj.App;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.optiondialog.ConfirmDialog;
import com.webforj.component.optiondialog.OptionDialog;
import com.webforj.component.optiondialog.MessageDialog;

public class ConfirmDialogOptionType extends App {

  @Override
  public void run() throws WebforjException {
    ConfirmDialog dialog = new ConfirmDialog(
        "There are unsaved changes. Do you want to discard or save them?", "Unsaved changes",
        ConfirmDialog.OptionType.CUSTOM, ConfirmDialog.MessageType.WARNING);
    dialog.setFirstButtonText("Discard");
    dialog.setFirstButtonTheme(ButtonTheme.WARNING);
    dialog.setSecondButtonText("Save");
    dialog.setSecondButtonTheme(ButtonTheme.OUTLINED_GRAY);
    ConfirmDialog.Result result = dialog.show();

    if (result == ConfirmDialog.Result.FIRST_CUSTOM_BUTTON) {
      OptionDialog.showMessageDialog("Changes discarded", "Discarded", "Got it");
    } else {
      OptionDialog.showMessageDialog(
          "Changes saved", "Saved", "Got it", MessageDialog.MessageType.INFO);
    }
  }
}
