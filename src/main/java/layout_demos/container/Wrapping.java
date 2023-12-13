package layout_demos.container;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

public class Wrapping extends App {
  @Override
  public void run() throws DwcjException {

    Frame page = new Frame();
    Panel container = new Panel();
    container.setStyle("width", "200px")
        .setStyle("border", "1px black dotted");
    page.add(container);

    Button[] buttons = new Button[3];
    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new Button("Button " + (i + 1));
      if (i == 0) {
        buttons[i].setTheme(ButtonTheme.PRIMARY);
      }
    }

    FlexLayout buttonsLayout = FlexLayout.create(buttons)
        .horizontal()
        .wrap()
        .build();

    container.add(buttonsLayout);
  }
}
