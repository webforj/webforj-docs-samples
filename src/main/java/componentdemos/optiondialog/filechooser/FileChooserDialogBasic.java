package componentdemos.optiondialog.filechooser;

import com.webforj.App;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.optiondialog.FileChooserDialog;
import com.webforj.component.optiondialog.OptionDialog;
import com.webforj.component.optiondialog.MessageDialog;

public class FileChooserDialogBasic extends App {

  @Override
  public void run() throws WebforjException {
    FileChooserDialog dialog = new FileChooserDialog("Choose Directory to save", "/usr2/bbx/demos",
        FileChooserDialog.SelectionMode.DIRECTORIES);
    dialog.setRestricted(true);
    String directory = dialog.show();
    if (directory != null) {
      OptionDialog.showMessageDialog("Directory selected: " + directory, "Directory Selected",
          MessageDialog.MessageType.INFO);
    } else {
      OptionDialog.showMessageDialog("No directory selected", "Directory Selection Failed",
          MessageDialog.MessageType.ERROR);
    }
  }
}
