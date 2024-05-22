package componentdemos.optiondialog.confirm;

import com.webforj.App;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.Theme;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.optiondialog.ConfirmDialog;

public class ConfirmDialogConstructor extends App {

  @Override
  public void run() throws WebforjException {
    ConfirmDialog dialog = new ConfirmDialog(
        "Are you sure you want to delete this file. This action cannot be reverted?", "Deletion",
        ConfirmDialog.OptionType.OK_CANCEL, ConfirmDialog.MessageType.QUESTION);
    dialog.setTheme(Theme.DANGER);
    dialog.setButtonTheme(ConfirmDialog.Button.FIRST, ButtonTheme.DANGER);
    dialog.setButtonTheme(ConfirmDialog.Button.SECOND, ButtonTheme.OUTLINED_GRAY);
    dialog.show();
  }
}
