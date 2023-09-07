package componentdemos.checkboxdemos;
// package control_demos.checkboxdemos;

// import org.dwcj.App;
// import org.dwcj.component.window.Frame;
// import org.dwcj.component.optioninput.CheckBox;

// import org.dwcj.component.checkbox.event.CheckBoxChangeEvent;
// import org.dwcj.exceptions.DwcjException;

// public class CheckboxDemo extends App {
// @Override
// public void run() throws DwcjException {

// Frame window = new Frame();
// window.setStyle("display", "inline-grid");
// window.setStyle("grid-template-columns", "1fr");
// window.setStyle("padding", "10px");
// window.setStyle("gap", "50px");

// CheckBox cb1 = new CheckBox();
// cb1.setText("Checkbox 1").onChange(this::checkboxDisplay);
// CheckBox cb2 = new CheckBox();
// cb2.setText("Checkbox 2").onChange(this::checkboxDisplay);
// CheckBox cb3 = new CheckBox();
// cb3.setText("Checkbox 3").onChange(this::checkboxDisplay);

// window.add(cb1, cb2, cb3);

// }

// void checkboxDisplay(CheckBoxChangeEvent ev) {
// String name = ev.getControl().getText();
// String isChecked = ev.getControl().isChecked() ? "on" : "off";
// App.msgbox(name + " has been checked " + isChecked);
// }

// }
