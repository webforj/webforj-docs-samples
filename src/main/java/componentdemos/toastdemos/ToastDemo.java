package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.Expanse;
import com.webforj.component.button.Button;
import com.webforj.component.field.NumberField;
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
    NumberField durationField = new NumberField("Duration", 3000.0);
    durationField.setStep(100.0);
    toastButton = new Button("Make Toast", e -> {
      Toast.show("Toast Notification " + counter++, durationField.getValue().intValue());
    });
    
    toastButton.setExpanse(Expanse.LARGE);
    durationField.setExpanse(Expanse.LARGE);
    frame.add(durationField);
    frame.add(toastButton);
  }
}
