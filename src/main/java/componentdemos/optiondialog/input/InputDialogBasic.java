package componentdemos.optiondialog.input;

import com.webforj.App;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.optiondialog.InputDialog;
import com.webforj.component.optiondialog.OptionDialog;
import com.webforj.component.optiondialog.MessageDialog;

public class InputDialogBasic extends App {

  @Override
  public void run() throws WebforjException {
    String code = "7ANfB";
    String message = """
        <dwc-alert theme='warning'>
          <b style='color: inherit'>Unexpected bad things will happen if you don't read this!</b>
        </dwc-alert>
        <br/>
        This will permanently delete the repository, wiki, issues,
        comments, packages, secrets, workflow runs, and remove all collaborator associations.
        <br/><br/>
        To confirm, type <b>""" + code + "</b> in the box below";

    InputDialog dialog = new InputDialog(message, "Delete Repository", InputDialog.MessageType.ERROR);
    dialog.setMessageType(InputDialog.MessageType.PLAIN);
    dialog.setFirstButtonText("Delete Repository");
    dialog.setSecondButtonTheme(ButtonTheme.OUTLINED_GRAY);
    String input = dialog.show();

    if (input.equals(code)) {
      OptionDialog.showMessageDialog("Repository was deleted successfully", "Repository Deleted",
          MessageDialog.MessageType.INFO);
    } else {
      OptionDialog.showMessageDialog("Failed to delete the repository. Code entered is incorrect",
          "Repository Deletion Failed", MessageDialog.MessageType.ERROR);
    }
  }
}
