package componentdemos.columnslayoutdemos;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.DateField;
import com.webforj.component.field.TextArea;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.columnslayout.ColumnsLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ColumnsLayoutAlignment extends App {
  TextField firstName = new TextField("First Name");
  TextField lastName = new TextField("Last Name");
  TextField email = new TextField("Email");
  DateField dateOfBirth = new DateField("Date of Birth");
  TextArea bio = new TextArea("Bio");
  CheckBox terms = new CheckBox("I agree to the terms and conditions");
  Button submit = new Button("Submit", ButtonTheme.PRIMARY);
  ColumnsLayout columnsLayout = new ColumnsLayout(
      firstName, lastName, email, dateOfBirth, bio, terms, submit);

  @Override
  public void run() throws WebforjException {
    columnsLayout.setSpan(bio, 2);
    columnsLayout.setSpan(terms, 2);

    columnsLayout.setColumn(submit, 2);
    columnsLayout.setHorizontalAlignment(submit, ColumnsLayout.Alignment.END);
    columnsLayout.setStyle("padding", "var(--dwc-space-xl)");

    Frame frame = new Frame();
    frame.setMaxWidth("60em");
    frame.setStyle("margin", "0 auto");
    frame.setStyle("overflow", "auto");
    frame.setStyle("height", "100dvh");
    frame.add(columnsLayout);
  }
}