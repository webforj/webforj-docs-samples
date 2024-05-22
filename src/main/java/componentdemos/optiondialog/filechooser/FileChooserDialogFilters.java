package componentdemos.optiondialog.filechooser;

import java.util.ArrayList;
import java.util.List;

import com.webforj.App;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.optiondialog.FileChooserDialog;
import com.webforj.component.optiondialog.FileChooserFilter;
import com.webforj.component.optiondialog.OptionDialog;
import com.webforj.component.optiondialog.MessageDialog;

public class FileChooserDialogFilters extends App {

  @Override
  public void run() throws WebforjException {
    List<FileChooserFilter> filters = new ArrayList<>();
    filters.add(new FileChooserFilter("All Files", "*.*"));
    filters.add(new FileChooserFilter("Text Files (*.txt)", "*.txt"));
    filters.add(new FileChooserFilter("Java Files (*.java)", "*.java"));
    filters.add(new FileChooserFilter("Image Files (*.png, *.jpg, *.jpeg)",
        "*.png;*.jpg;*.jpeg"));

    FileChooserDialog dialog = new FileChooserDialog("Choose a file to download", "/Users/habof/bbx", filters);
    dialog.setRestricted(true);
    dialog.setGridView(true);
    String file = dialog.show();

    if (file != null) {
      OptionDialog.showMessageDialog("File selected: " + file, "File Selected", MessageDialog.MessageType.INFO);
    } else {
      OptionDialog.showMessageDialog("No file selected", "File Selection Failed", MessageDialog.MessageType.ERROR);
    }
  }
}
