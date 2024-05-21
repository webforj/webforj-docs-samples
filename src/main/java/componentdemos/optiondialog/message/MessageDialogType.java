package componentdemos.optiondialog.message;

import com.webforj.App;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.optiondialog.MessageDialog;
import com.webforj.component.optiondialog.OptionDialog;

public class MessageDialogType extends App {

  @Override
  public void run() throws WebforjException {
    OptionDialog.showMessageDialog(
        "Your session will expire in 5 minutes due to inactivity. Save your work now to prevent any data loss.",
        "Session is expiring", MessageDialog.MessageType.WARNING);
  }
}
