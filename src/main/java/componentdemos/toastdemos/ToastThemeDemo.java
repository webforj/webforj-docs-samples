package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/toaststyles/toastthemedemo_styles.css")
public class ToastThemeDemo extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    frame.addClassName("window");
    
    Toast updateToast = new Toast("The application has a new update available", -1, Theme.DEFAULT);
    updateToast.addClassName("custom-theme");
    
    Button laterButton = new Button("Later");
    laterButton.addClassName("laterButton");
    
    Button updateButton = new Button("Update Now");  
    updateButton.addClassName("updateButton");
    
    updateToast.add(laterButton, updateButton);
    updateToast.open();
  }

}
