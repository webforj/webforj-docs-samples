// package componentdemos.drawerdemos;

// import com.webforj.App;
// import com.webforj.annotation.InlineStyleSheet;
// import com.webforj.component.button.Button;
// import com.webforj.component.drawer.Drawer;
// import com.webforj.component.field.NumberField;
// import com.webforj.component.layout.flexlayout.FlexLayout;
// import com.webforj.component.window.Frame;
// import com.webforj.exceptions.WebforjException;

// @InlineStyleSheet("context://css/drawerstyles/styles.css")
// public class DrawerSize extends App {

//   Drawer drawer = new Drawer();
//   NumberField size = new NumberField("0");
//   NumberField maxSize = new NumberField("0");
//   Button submit = new Button("Submit");
//   Button reset = new Button("Reset");

//   @Override
//   public void run() throws WebforjException {

//     Frame app = new Frame();
//     app.add(drawer);

//     size.setLabel("Size:");
//     maxSize.setLabel("Max Size:");

//     submit.setStyle("margin", "10px");
//     submit.onClick(e -> {
//       if (!maxSize.getText().equals("0")) {
//         drawer.setMaxSize(maxSize.getText() + "px");
//       }
//       if (!size.getText().equals("0")) {
//         drawer.setSize(size.getText() + "px");
//       }
//     });

//     reset.setStyle("margin", "10px")
//         .onClick(e -> drawer.setSize("16em").setMaxSize("100%"));

//     FlexLayout inputs = FlexLayout.create()
//         .vertical()
//         .justify().start()
//         .build()
//         .setSpacing("10px");

//     FlexLayout buttons = FlexLayout.create()
//         .justify().center()
//         .build()
//         .setSpacing("10px");

//     inputs.add(size, maxSize);
//     buttons.add(submit, reset);

//     drawer.add(inputs, buttons);
//     drawer.addClassName("drawer");
//     drawer.open();
//   }
// }
