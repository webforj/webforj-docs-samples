package control_demos.labeldemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.label.Label;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.HorizontalAlignment;


@InlineStyleSheet("context://css/labelstyles/text_styles.css")
public class LabelSample extends App {
  @Override
  public void run() throws DwcjException {
    Frame app = new Frame();
    app.addClassName("Frame");

    Label myLabel = new Label("Hover over me!");
    myLabel.setHorizontalAlignment(HorizontalAlignment.Alignment.MIDDLE);
    
    myLabel.addMouseEnterListener( e -> {
      myLabel.setText("Mouse Entered at X coordinate: " + e.getScreenX() + " and Y coordinate: " + e.getScreenY());
    });

    myLabel.addMouseExitListener( e -> {
      myLabel.setText("Hover over me!");
    });

    app.add(myLabel);
  }
}
