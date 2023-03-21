package control_demos.textareademos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.textarea.TextArea;

@InlineStyleSheet("context://css/textareastyles/text_area_styles.css")
public class TextAreaExpanse extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");

    Div wrapper = new Div();

    TextArea t1 = new TextArea().setExpanse(TextArea.Expanse.XSMALL)
      .setAttribute("placeholder", "XSMALL")
      .setStyle("padding-right", "10px");

    TextArea t2 = new TextArea().setExpanse(TextArea.Expanse.SMALL)
      .setAttribute("placeholder", "SMALL")
      .setStyle("padding-right", "10px");

    TextArea t3 = new TextArea().setExpanse(TextArea.Expanse.MEDIUM)
      .setAttribute("placeholder", "MEDIUM")
      .setStyle("padding-right", "10px");

    TextArea t4 = new TextArea().setExpanse(TextArea.Expanse.LARGE)
      .setAttribute("placeholder", "LARGE")
      .setStyle("padding-right", "10px");
      
    TextArea t5 = new TextArea().setExpanse(TextArea.Expanse.XLARGE)
      .setAttribute("placeholder", "XLARGE")
      .setStyle("padding-right", "10px");

    panel.add(wrapper);
    wrapper.add(t1, t2, t3, t4, t5);
  }
}