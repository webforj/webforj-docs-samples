package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ToastPlacement extends App {
  int counter = 1;
  Frame frame;
  @Override
  public void run() throws WebforjException {
    frame = new Frame();
    frame.setStyle("padding", "1em");
    Toast toast = new Toast();

    Button topLeftButton     = new Button("Top Left",     e -> toast.setPlacement(Toast.Placement.TOP_LEFT));
    Button topButton         = new Button("Top",          e -> toast.setPlacement(Toast.Placement.TOP));
    Button topRightButton    = new Button("Top Right",    e -> toast.setPlacement(Toast.Placement.TOP_RIGHT));
    Button bottomButton      = new Button("Bottom",       e -> toast.setPlacement(Toast.Placement.BOTTOM));
    Button bottomLeftButton  = new Button("Bottom Left",  e -> toast.setPlacement(Toast.Placement.BOTTOM_LEFT));
    Button bottomRightButton = new Button("Bottom Right", e -> toast.setPlacement(Toast.Placement.BOTTOM_RIGHT));

    FlexLayout topLayout = new FlexLayout(topLeftButton, topButton, topRightButton).setJustifyContent(FlexJustifyContent.BETWEEN);
    FlexLayout bottomLayout = new FlexLayout(bottomLeftButton, bottomButton, bottomRightButton).setJustifyContent(FlexJustifyContent.BETWEEN);
    FlexLayout toastLayout = new FlexLayout(FlexDirection.COLUMN, topLayout, bottomLayout);
    toast.add(toastLayout);
    toast.setDuration(-1);
    toast.open();
  }
}
