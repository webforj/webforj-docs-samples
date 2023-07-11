package control_demos.drawerdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.maskednumberfield.MaskedNumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/drawerstyles/drawer_size.css")
public class DrawerSize extends App {

  MaskedNumberField size;
  MaskedNumberField maxSize;

  Button submit;
  Button reset;

  @Override
  public void run() throws DwcjException {

    Frame app = new Frame();
    Drawer drawer = new Drawer();
    app.add(drawer);

    size = new MaskedNumberField("0").setAttribute("label", "Size:");
    maxSize = new MaskedNumberField("0").setAttribute("label", "Max Size:");

    submit = new Button("Submit")
        .onClick(e -> {
          if (!maxSize.getText().equals("0")) {
            drawer.setMaxSize(maxSize.getText() + "px");
          }
          if (!size.getText().equals("0")) {
            drawer.setSize(size.getText() + "px");
          }
        })
        .setStyle("margin", "10px");

    reset = new Button("Reset")
        .onClick(e -> {
          drawer.setSize("16em").setMaxSize("100%");
        })
        .setStyle("margin", "10px");

    Panel inputs = new Panel();
    Panel buttons = new Panel();

    inputs.add(size, maxSize)
        .addClassName("inputs");
    buttons.add(submit, reset)
        .addClassName("buttons");

    drawer.open();
    drawer.getContent()
        .add(inputs, buttons)
        .addClassName("drawer");
  }
}
