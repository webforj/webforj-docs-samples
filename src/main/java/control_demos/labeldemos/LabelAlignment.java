package control_demos.labeldemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.label.Label;
import org.dwcj.component.HorizontalAlignment;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/labelstyles/alignment_styles.css")
public class LabelAlignment extends App {
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    Label l1 = new Label(
        "<html><b>LEFT-ALIGNED TEXT</b><br></br> Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
            +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit "
            +
            "esse cillum dolore eu fugiat nulla pariatur. </html>");

    Label l2 = new Label(
        "<html><b>CENTER-ALIGNED TEXT</b><br></br> Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
            +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit "
            +
            "esse cillum dolore eu fugiat nulla pariatur. </html>");

    Label l3 = new Label(
        "<html><b>RIGHT-ALIGNED TEXT</b><br></br> Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
            +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit "
            +
            "esse cillum dolore eu fugiat nulla pariatur. </html>");

    panel.add(l1, l2, l3);

    l1.setHorizontalAlignment(HorizontalAlignment.Alignment.LEFT);
    l2.setHorizontalAlignment(HorizontalAlignment.Alignment.MIDDLE);
    l3.setHorizontalAlignment(HorizontalAlignment.Alignment.RIGHT);
  }
}
