package control_demos.buttondemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.button.Button;
import org.dwcj.exceptions.DwcException;

@InlineStyleSheet("context://css/buttonstyles/expanse_styles.css")
public class ButtonExpanses extends App {
  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    Div container = new Div().addClassName("container");
    panel.addClassName("appPanel");

    Button be1 = new Button("XSMALL").setExpanse(Button.Expanse.XSMALL);
    Button be2 = new Button("SMALL").setExpanse(Button.Expanse.SMALL);
    Button be3 = new Button("MEDIUM").setExpanse(Button.Expanse.MEDIUM);
    Button be4 = new Button("LARGE").setExpanse(Button.Expanse.LARGE);
    Button be5 = new Button("XLARGE").setExpanse(Button.Expanse.XLARGE);

    panel.add(container);
    container.add(be1, be2, be3, be4, be5);
  }
}
