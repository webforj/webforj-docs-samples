package control_demos.textareademos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textarea.TextArea;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaSpellcheck extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    TextArea t1 = new TextArea().setAttribute("spellcheck", "true")
      .setAttribute("placeholder","Enter misspelled text");

    panel.add(t1);
  }
}
