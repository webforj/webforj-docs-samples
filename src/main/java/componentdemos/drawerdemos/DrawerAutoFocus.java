package componentdemos.drawerdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.drawer.Drawer;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerAutoFocus extends App {

  private final Drawer drawer;
  private final CheckBox checkbox;
  private final Button show;

  public DrawerAutoFocus() {
    drawer = new Drawer();
    checkbox = new CheckBox("Checkbox auto-focused");
    show = new Button("Display Drawer")
      .setEnabled(false);
  }


  @Override
  public void run() throws WebforjException {

    Frame app = new Frame();
    app.add(drawer);
    drawer.open();
    drawer.add(checkbox);
    drawer.addClassName("drawer");
    drawer.setAutofocus(true);
    drawer.onClose(e -> show.setEnabled(true));
    show.addClickListener(e -> {
      drawer.open();
      show.setEnabled(false);
    });
  }
}
