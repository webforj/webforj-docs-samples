package componentdemos.drawerdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/drawerstyles/styles.css")
public class DrawerSize extends App {

  Drawer drawer = new Drawer();
  NumberField size = new NumberField("0");
  NumberField maxSize = new NumberField("0");
  Button submit = new Button("Submit");
  Button reset = new Button("Reset");

  @Override
  public void run() throws DwcjException {

    Frame app = new Frame();
    app.add(drawer);

    size.setLabel("Size:");
    maxSize.setLabel("Max Size:");

    submit.setStyle("margin", "10px");
    submit.onClick(e -> {
      if (!maxSize.getText().equals("0")) {
        drawer.setMaxSize(maxSize.getText() + "px");
      }
      if (!size.getText().equals("0")) {
        drawer.setSize(size.getText() + "px");
      }
    });

    reset.setStyle("margin", "10px")
        .onClick(e -> drawer.setSize("16em").setMaxSize("100%"));

    FlexLayout inputs = FlexLayout.create()
        .vertical()
        .justify().start()
        .build()
        .setSpacing("10px");

    FlexLayout buttons = FlexLayout.create()
        .justify().center()
        .build()
        .setSpacing("10px");

    inputs.add(size, maxSize);
    buttons.add(submit, reset);

    drawer.add(inputs, buttons);
    drawer.addClassName("drawer");
    drawer.open();
  }
}
