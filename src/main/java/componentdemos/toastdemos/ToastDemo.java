package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ToastDemo extends App {
  int counter = 1;
  @Override
  public void run() throws WebforjException {
    
    Frame frame = new Frame();
    frame.add(new Button("Make Toast", e -> {
      Toast.show("Toast Notification " + counter++);
    }));
  }
}
