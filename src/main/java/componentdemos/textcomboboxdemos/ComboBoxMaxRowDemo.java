package componentdemos.textcomboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
import org.dwcj.component.event.ListenerRegistration;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.list.ComboBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/comboboxstyles/demo_styles.css")
public class ComboBoxMaxRowDemo extends App {
  
  ComboBox demoBox;
  NumberField numberField;
  Button select;
  
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    demoBox = new ComboBox();
    numberField = new NumberField();
    select = new Button("Apply");

    window.add(demoBox, numberField, select);

    demoBox.setLabel("States");
    numberField.setLabel("Number of Rows");

    select.onClick( e -> {
      demoBox.setMaxRowCount(Integer.valueOf(numberField.getText()));
    });



    // UPDATE TO CREATE A LIST OF STRINGS AND USE INSERT METHOD INSTEAD

    demoBox.add("AL", "Alabama");
    demoBox.add("AK", "Alaska");
    demoBox.add("AZ", "Arizona");
    demoBox.add("AR", "Arkansas");
    demoBox.add("CA", "California");
    demoBox.add("CO", "Colorado");
    demoBox.add("CT", "Connecticut");
    demoBox.add("DE", "Delaware");
    demoBox.add("FL", "Florida");
    demoBox.add("GA", "Georgia");
    demoBox.add("HI", "Hawaii");
    demoBox.add("ID", "Idaho");
    demoBox.add("IL", "Illinois");
    demoBox.add("IN", "Indiana");
    demoBox.add("IA", "Iowa");
    demoBox.add("KS", "Kansas");
    demoBox.add("KY", "Kentucky");
    demoBox.add("LA", "Louisiana");
    demoBox.add("ME", "Maine");
    demoBox.add("MD", "Maryland");
    demoBox.add("MA", "Massachusetts");
    demoBox.add("MI", "Michigan");
    demoBox.add("MN", "Minnesota");
    demoBox.add("MS", "Mississippi");
    demoBox.add("MO", "Missouri");
    demoBox.add("MT", "Montana");
    demoBox.add("NE", "Nebraska");
    demoBox.add("NV", "Nevada");
    demoBox.add("NH", "New Hampshire");
    demoBox.add("NJ", "New Jersey");
    demoBox.add("NM", "New Mexico");
    demoBox.add("NY", "New York");
    demoBox.add("NC", "North Carolina");
    demoBox.add("ND", "North Dakota");
    demoBox.add("OH", "Ohio");
    demoBox.add("OK", "Oklahoma");
    demoBox.add("OR", "Oregon");
    demoBox.add("PA", "Pennsylvania");
    demoBox.add("RI", "Rhode Island");
    demoBox.add("SC", "South Carolina");
    demoBox.add("SD", "South Dakota");
    demoBox.add("TN", "Tennessee");
    demoBox.add("TX", "Texas");
    demoBox.add("UT", "Utah");
    demoBox.add("VT", "Vermont");
    demoBox.add("VA", "Virginia");
    demoBox.add("WA", "Washington");
    demoBox.add("WV", "West Virginia");
    demoBox.add("WI", "Wisconsin");
    demoBox.add("WY", "Wyoming");
  }
}
