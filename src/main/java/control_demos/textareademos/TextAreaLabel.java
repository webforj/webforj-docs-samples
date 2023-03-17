package control_demos.textareademos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textarea.TextArea;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaLabel extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");
    panel.add(new TextArea().setAttribute("label", "Example Label"));
  }
}