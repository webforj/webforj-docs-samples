package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.spinner.Spinner;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ToastDemo extends App {

  Toast t = new Toast("", -1, Theme.GRAY);

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.add(t);
    t.add(
        new Spinner(),
        new Paragraph("System update failed. Restoring to the previous state."),
        new Button("Stop", ButtonTheme.DANGER, e -> t.close()));
    t.open();
  }
}
