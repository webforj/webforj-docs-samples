package componentdemos.optiondialog.fileupload;

import com.webforj.App;
import com.webforj.UploadedFile;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.optiondialog.FileUploadDialog;
import com.webforj.component.optiondialog.OptionDialog;
import com.webforj.component.optiondialog.MessageDialog;

public class FileUploadDialogBasic extends App {

  @Override
  public void run() throws WebforjException {
    FileUploadDialog dialog = new FileUploadDialog("Upload a file");
    dialog.setFileSystemAccess(false);
    UploadedFile file = dialog.show();
    if (file != null) {
      // Do something with the uploaded file
      file.delete();
      OptionDialog.showMessageDialog("File uploaded successfully", "File Uploaded", MessageDialog.MessageType.INFO);
    } else {
      OptionDialog.showMessageDialog("No file selected", "File Selection Failed", MessageDialog.MessageType.ERROR);
    }
  }
}
