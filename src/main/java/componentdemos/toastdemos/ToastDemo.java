package componentdemos.toastdemos;
import com.webforj.App;
import com.webforj.component.window.Frame;
import com.webforj.component.toast.Toast;
import com.webforj.exceptions.WebforjException;
public class ToastDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    Toast toast = new Toast("Toasty!",5);
  }
}

