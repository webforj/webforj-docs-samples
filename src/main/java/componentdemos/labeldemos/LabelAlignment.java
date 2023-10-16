package componentdemos.labeldemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.text.Label;
import org.dwcj.concern.HasHorizontalAlignment;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/labelstyles/alignment_styles.css")
public class LabelAlignment extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

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

    window.add(l1, l2, l3);

    l1.setHorizontalAlignment(HasHorizontalAlignment.Alignment.LEFT);
    l2.setHorizontalAlignment(HasHorizontalAlignment.Alignment.MIDDLE);
    l3.setHorizontalAlignment(HasHorizontalAlignment.Alignment.RIGHT);
  }
}
