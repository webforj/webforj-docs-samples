package control_demos.drawerdemos;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.label.Label;
import org.dwcj.component.numberfield.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class DrawerSize extends App{
 
  NumberField size;
  NumberField maxSize;

  Button submit;
  Button reset;

  @Override
  public void run() throws DwcjException {
  
    Frame app = new Frame();
    Drawer drawer = new Drawer();

    size = new NumberField("0").setAttribute("label", "Size:");
    maxSize = new NumberField("0").setAttribute("label", "Max Size:");
    submit = new Button("Submit")
      .onClick( e -> {
        if(!maxSize.getText().equals("0")){
          drawer.setMaxSize(maxSize.getText() + "px");
        }
        if(!size.getText().equals("0")){
          drawer.setSize(size.getText() + "px");
        }
      });

    reset = new Button("Reset")
      .onClick( e -> {
        drawer.setSize("16em").setMaxSize("100%");
      });
    app.add(drawer);
    drawer.open();
    drawer.getContent()
      .add(size, maxSize, submit, reset)
      .setStyle("height", "100%")
      .setStyle("display", "flex")
      .setStyle("flex-wrap", "wrap")
      .setStyle("align-content", "center")
      .setStyle("justify-content", "center");
  }
}
