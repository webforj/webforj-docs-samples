package componentdemos.spinnerdemos;

import com.webforj.App;
import com.webforj.component.Theme;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.spinner.Spinner;
import com.webforj.component.spinner.SpinnerExpanse;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.icons.DwcIcon;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;

public class SpinnerDemo extends App {

  Spinner spinner = new Spinner(Theme.PRIMARY, SpinnerExpanse.SMALL);

  H3 title = new H3("Complete your job application:");
  Icon position = TablerIcon.create("checks");
  Icon location = TablerIcon.create("checks");
  Paragraph resume = new Paragraph("Uploading your resume");


  @Override
  public void run() throws WebforjException {

    Frame window = new Frame();
    window.setStyle("margin-left", "20px");
    position.setStyle("color", "green");
    location.setStyle("color", "green");

    FlexLayout positionLayout = new FlexLayout(position, new Paragraph("Select the position you wish to apply for"));
    FlexLayout locationLayout = new FlexLayout(location, new Paragraph("Provide your current location details"));
    FlexLayout spinnerLayout = new FlexLayout(spinner, resume);

    FlexLayout items =  FlexLayout.create(title, positionLayout, locationLayout, spinnerLayout)
    .vertical()
    .build();
    window.add(items);

    Icon test = DwcIcon.ARROW_UP.create();
    window.add(test);
    
  }
}