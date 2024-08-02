// package componentdemos.fielddemos;

// import com.webforj.App;
// import com.webforj.annotation.InlineStyleSheet;
// // import com.webforj.component.HighlightableOnFocus;
// import com.webforj.component.field.ColorField;
// import com.webforj.component.field.DateField;
// import com.webforj.component.field.DateTimeField;
// import com.webforj.component.field.NumberField;
// import com.webforj.component.field.PasswordField;
// import com.webforj.component.field.TextField;
// import com.webforj.component.field.TimeField;
// import com.webforj.component.window.Frame;
// import com.webforj.exceptions.WebforjException;

// @InlineStyleSheet("context://css/progressbarstyles/demo_styles.css")
// public class FieldDemos extends App {

//   @Override
//   public void run() throws WebforjException {

//       Frame window = new Frame();

//       NumberField field = new NumberField();
//       // field.setValue(0d);
//       field.setText("0");
//       // field.setHighlightOnFocus(HighlightableOnFocus.Behavior.MOUSE);

//       window.add(
//         new ColorField(),
//         new DateField(),
//         new DateTimeField(),
//         field,
//         // new NumberField()
//         //   .setPlaceholder("0"),
//         new PasswordField(),
//         new TextField(),
//         new TimeField()
//       ).setStyle("display", "flex")
//        .setStyle("flex-direction", "column")
//        .setStyle("align-items", "center")
//        .setStyle("gap", "50px")
//        .setStyle("margin", "50px")
//        .setStyle("margin-left", "40vw")
//        .setWidth("200px");


//   }
// }

