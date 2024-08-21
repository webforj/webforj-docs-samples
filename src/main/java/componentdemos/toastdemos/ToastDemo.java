package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.Expanse;
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

    toastButton = new Button("Make Toast", e -> {
      Toast.show("Toast Notification " + counter++);
    });
    
    toastButton.setExpanse(Expanse.LARGE);
    frame.add(toastButton);
  }
}
