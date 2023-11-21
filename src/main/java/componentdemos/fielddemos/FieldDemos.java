package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
// import org.dwcj.component.HighlightableOnFocus;
import org.dwcj.component.field.ColorField;
import org.dwcj.component.field.DateField;
import org.dwcj.component.field.DateTimeField;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.field.PasswordField;
import org.dwcj.component.field.TextField;
import org.dwcj.component.field.TimeField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/progressbarstyles/demo_styles.css")
public class FieldDemos extends App {

  @Override
  public void run() throws DwcjException {

      Frame window = new Frame();

      NumberField field = new NumberField();
      // field.setValue(0d);
      field.setText("0");
      // field.setHighlightOnFocus(HighlightableOnFocus.Behavior.MOUSE);

      window.add(
        new ColorField(),
        new DateField(),
        new DateTimeField(),
        field,
        // new NumberField()
        //   .setPlaceholder("0"),
        new PasswordField(),
        new TextField(),
        new TimeField()
      ).setStyle("display", "flex")
       .setStyle("flex-direction", "column")
       .setStyle("align-items", "center")
       .setStyle("gap", "50px")
       .setStyle("margin", "50px")
       .setStyle("margin-left", "40vw")
       .setStyle("width", "200px");


  }
}

