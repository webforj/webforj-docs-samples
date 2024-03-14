package layout_demos.container;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.component.window.Panel;
import com.webforj.exceptions.WebforjException;

public class Wrapping extends App {
  @Override
  public void run() throws WebforjException {

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
