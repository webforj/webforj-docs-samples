package com.webforj.samples.views.optiondialog.filechooser;

import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.optiondialog.FileChooserDialog;
import com.webforj.component.optiondialog.OptionDialog;
import com.webforj.component.optiondialog.MessageDialog;

@Route
@FrameTitle("File Chooser Basics")
public class FileChooserDialogBasicView extends Composite<Div> {

  public FileChooserDialogBasicView() {
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
