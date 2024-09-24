package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.Expanse;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ToastDemo extends App {
  int counter = 1;
  Button toastButton;
  Frame frame;

  @Override
  public void run() throws WebforjException {
    frame = new Frame();
    frame.setStyle("padding", "1em");
    Button saveButton = new Button("Save Changes", e -> {
      Toast.show("Changes saved!", Theme.SUCCESS);
    });

    saveButton.setExpanse(Expanse.LARGE);
    frame.add(saveButton);
  }
}
