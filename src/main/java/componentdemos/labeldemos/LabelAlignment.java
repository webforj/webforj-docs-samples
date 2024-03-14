package componentdemos.labeldemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.text.Label;
import com.webforj.concern.HasHorizontalAlignment;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/labelstyles/alignment_styles.css")
public class LabelAlignment extends App {
  @Override
  public void run() throws WebforjException {
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
