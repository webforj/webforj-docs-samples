package layout_demos.container;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

public class Spacing extends App {
  @Override
  public void run() throws DwcjException {

    Frame page = new Frame();
    Panel container = new Panel()
        .setStyle("width", "200px")
        .setStyle("border", "1px black dotted");
    page.add(container);

    Button[] buttons = new Button[3];
    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new Button("Button " + (i + 1));
      if (i == 0) {
        buttons[i].setTheme(Button.Theme.PRIMARY);
      }
    }

    FlexLayout buttonsLayout = FlexLayout.create(buttons)
        .horizontal()
        .wrap()
        .contentAlign().around()
        .justify().end()
        .build();

    container.add(buttonsLayout);
  }
}
