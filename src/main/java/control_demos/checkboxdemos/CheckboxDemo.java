package control_demos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.checkbox.CheckBox;
import org.dwcj.controls.checkbox.events.CheckBoxChangeEvent;
import org.dwcj.exceptions.DwcException;

public class CheckboxDemo extends App {
  @Override
  public void run() throws DwcException {

    AppPanel panel = new AppPanel();
    panel.setStyle("display", "inline-grid");
    panel.setStyle("grid-template-columns", "1fr");
    panel.setStyle("padding", "10px");
    panel.setStyle("gap", "50px");

    CheckBox cb1 = new CheckBox();
    cb1.setText("Checkbox 1").onChange(this::checkboxDisplay);
    CheckBox cb2 = new CheckBox();
    cb2.setText("Checkbox 2").onChange(this::checkboxDisplay);
    CheckBox cb3 = new CheckBox();
    cb3.setText("Checkbox 3").onChange(this::checkboxDisplay);

    panel.add(cb1, cb2, cb3);

  }

  void checkboxDisplay(CheckBoxChangeEvent ev) {
    String name = ev.getControl().getText();
    String isChecked = ev.getControl().isChecked() ? "on" : "off";
    App.msgbox(name + " has been checked " + isChecked);
  }

}
