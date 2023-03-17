package control_demos.numericboxdemos;

import org.dwcj.App;
import org.dwcj.annotations.InlineStyleSheet;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.exceptions.DwcException;
import org.dwcj.controls.numericbox.NumericBox;

@InlineStyleSheet("context://css/numericboxstyles/demo_styles.css")
public class NumericboxDemo extends App {

  NumericBox nb;

  @Override
  public void run() throws DwcException {
    AppPanel panel = new AppPanel();
    panel.addClassName("appPanel");
    nb = new NumericBox();
    panel.add(nb);
  }
}