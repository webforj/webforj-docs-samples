package control_demos.stringeditdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.stringeditbox.StringEditBox;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/stringeditboxstyles/string_edit_styles.css")
public class StringEditLabelDemo extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    panel.add(new StringEditBox().setAttribute("label", "Example Label"));
  }
}