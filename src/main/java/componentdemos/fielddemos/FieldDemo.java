package componentdemos.fielddemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.event.ModifyEvent;
import com.webforj.component.field.ColorField;
import com.webforj.component.field.DateField;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TimeField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;


@InlineStyleSheet("context://css/flexstyles/form_styles.css")
public class FieldDemo extends App {
  private final TextField firstName;
  private final TextField lastName;
  private final TextField email;
  private final TextField telephone;
  private final DateField testDate;
  private final TimeField testTime;
  private final ColorField preferredColor;
  private final TextField remarks;
  private final Button submit;
  private final Button cancel;

  public FieldDemo() {
    firstName = new TextField(TextField.Type.TEXT,"First Name")
      .setRequired(true);
    lastName = new TextField(TextField.Type.TEXT,"Last Name")
      .setRequired(true);
    email = new TextField(TextField.Type.EMAIL, "E-Mail")
      .setRequired(true);
    telephone = new TextField(TextField.Type.TEL, "Tel. Number")
      .setPlaceholder("optional");
    testDate = new DateField("Date of Test drive")
      .setRequired(true);
    testTime = new TimeField("Time of Test drive")
      .setRequired(true)
      .setMin(LocalTime.of(9, 0))
      .setMax(LocalTime.of(17, 0));
    preferredColor = new ColorField("Preferred Color:");
    remarks = new TextField(TextField.Type.TEXT, "Remarks:")
      .setPlaceholder("optional")
      .setSpellCheck(true);
    submit = new Button("Submit")
      .setEnabled(false)
      .setTheme(ButtonTheme.PRIMARY);
    cancel = new Button("Cancel")
      .setTheme(ButtonTheme.DEFAULT);
  }

  @Override
  public void run() throws WebforjException {
    LocalDate date = LocalDate.now();
    LocalTime now = LocalTime.now();
    if(now.isBefore(testTime.getMin())) {
      testTime.setValue(testTime.getMin());
    } else if (now.isAfter(testTime.getMax())) {
      date = date.plusDays(1);
      testTime.setValue(testTime.getMin());
    } else {
      testTime.setValue(now);
    }
    testDate.setValue(date);

    firstName.onModify(this::verify);
    lastName.onModify(this::verify);
    email.onModify(this::verify);
    testDate.onModify(this::verify);
    testTime.onModify(this::verify);

    submit.addClickListener(e -> {
      Dialog dialog = new Dialog()
        .addToHeader(new Div("We received your order."));
      dialog.add(new Div("A test drive is reserved for you on the %s at %s."));
      Button close = new Button("Close");
      dialog.addToFooter(close);
      close.addClickListener(x -> dialog.close());
      dialog.open();
    });

    cancel.addClickListener(e -> {
      Dialog dialog = new Dialog()
        .addToHeader(new Div("Warning!"))
        .setTheme(Theme.WARNING);
      dialog.add(new Div("If you proceed your inputs will be deleted!"));
      Button confirm = new Button("Confirm")
        .setTheme(ButtonTheme.DANGER);
      Button stop = new Button("Return")
        .setTheme(ButtonTheme.GRAY);
      confirm.addClickListener(x -> {
        clear();
        dialog.close();
      });
      stop.addClickListener(x -> dialog.close());
      dialog.open();
    });

    FlexLayout mainLayout = FlexLayout.create()
      .vertical()
      .build()
      .addClassName("main__layout");
    FlexLayout rowOne = FlexLayout.create(firstName, lastName)
      .horizontal()
      .wrap().wrap()
      .build();
    FlexLayout rowTwo = FlexLayout.create(email, telephone)
      .horizontal()
      .wrap().wrap()
      .build();
    FlexLayout rowThree = FlexLayout.create(testDate, testTime)
        .horizontal()
        .wrap().wrap()
        .build();
    FlexLayout rowFour = FlexLayout.create(submit, cancel)
      .horizontal()
      .build();

    mainLayout.add(rowOne, rowTwo, rowThree, preferredColor, remarks, rowFour);
    Frame page = new Frame();
    page.add(mainLayout);
  }

  private void verify(ModifyEvent e) {
    if(firstName.getText().isEmpty()) {
      submit.setEnabled(false);
      return;
    }
    if(lastName.getText().isEmpty()) {
      submit.setEnabled(false);
      return;
    }
    if(!email.getText().contains("@") || email.getText().isEmpty()) {
      submit.setEnabled(false);
      return;
    }
    if(testDate.getValue().isBefore(LocalDate.now())) {
      submit.setEnabled(false);
      return;
    }
    if(testTime.getValue().isBefore(testTime.getMin())) {
      submit.setEnabled(false);
      return;
    }
    if(testTime.getValue().isAfter(testTime.getMax())) {
      submit.setEnabled(false);
      return;
    }
    submit.setEnabled(true);
  }

  private void clear() {
    LocalDate date = LocalDate.now();
    LocalTime now = LocalTime.now();
    if(now.isBefore(testTime.getMin())) {
      testTime.setValue(testTime.getMin());
    } else if (now.isAfter(testTime.getMax())) {
      date = date.plusDays(1);
      testTime.setValue(testTime.getMin());
    } else {
      testTime.setValue(now);
    }
    testDate.setValue(date);

    firstName.setValue("");
    lastName.setValue("");
    email.setValue("");
    telephone.setValue("");
    preferredColor.setValue(new Color(255, 0, 0));
    remarks.setValue("");
    submit.setEnabled(false);
  }

}
