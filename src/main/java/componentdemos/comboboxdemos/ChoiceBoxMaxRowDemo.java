package componentdemos.comboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.button.Button;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/comboboxstyles/demo_styles.css")
public class ChoiceBoxMaxRowDemo extends App {
  
  ChoiceBox demoBox;
  NumberField numberField;
  Button select;
  
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    demoBox = new ChoiceBox();
    numberField = new NumberField();
    select = new Button("Submit");

    window.add(demoBox, numberField, select);

    demoBox.setLabel("States");

    select.onClick( e -> {
      demoBox.setMaxRowCount(Integer.valueOf(numberField.getText()));
    });


    demoBox.add(new ListItem("AL", "Alabama"));
    demoBox.add(new ListItem("AK", "Alaska"));
    demoBox.add(new ListItem("AZ", "Arizona"));
    demoBox.add(new ListItem("AR", "Arkansas"));
    demoBox.add(new ListItem("CA", "California"));
    demoBox.add(new ListItem("CO", "Colorado"));
    demoBox.add(new ListItem("CT", "Connecticut"));
    demoBox.add(new ListItem("DE", "Delaware"));
    demoBox.add(new ListItem("FL", "Florida"));
    demoBox.add(new ListItem("GA", "Georgia"));
    demoBox.add(new ListItem("HI", "Hawaii"));
    demoBox.add(new ListItem("ID", "Idaho"));
    demoBox.add(new ListItem("IL", "Illinois"));
    demoBox.add(new ListItem("IN", "Indiana"));
    demoBox.add(new ListItem("IA", "Iowa"));
    demoBox.add(new ListItem("KS", "Kansas"));
    demoBox.add(new ListItem("KY", "Kentucky"));
    demoBox.add(new ListItem("LA", "Louisiana"));
    demoBox.add(new ListItem("ME", "Maine"));
    demoBox.add(new ListItem("MD", "Maryland"));
    demoBox.add(new ListItem("MA", "Massachusetts"));
    demoBox.add(new ListItem("MI", "Michigan"));
    demoBox.add(new ListItem("MN", "Minnesota"));
    demoBox.add(new ListItem("MS", "Mississippi"));
    demoBox.add(new ListItem("MO", "Missouri"));
    demoBox.add(new ListItem("MT", "Montana"));
    demoBox.add(new ListItem("NE", "Nebraska"));
    demoBox.add(new ListItem("NV", "Nevada"));
    demoBox.add(new ListItem("NH", "New Hampshire"));
    demoBox.add(new ListItem("NJ", "New Jersey"));
    demoBox.add(new ListItem("NM", "New Mexico"));
    demoBox.add(new ListItem("NY", "New York"));
    demoBox.add(new ListItem("NC", "North Carolina"));
    demoBox.add(new ListItem("ND", "North Dakota"));
    demoBox.add(new ListItem("OH", "Ohio"));
    demoBox.add(new ListItem("OK", "Oklahoma"));
    demoBox.add(new ListItem("OR", "Oregon"));
    demoBox.add(new ListItem("PA", "Pennsylvania"));
    demoBox.add(new ListItem("RI", "Rhode Island"));
    demoBox.add(new ListItem("SC", "South Carolina"));
    demoBox.add(new ListItem("SD", "South Dakota"));
    demoBox.add(new ListItem("TN", "Tennessee"));
    demoBox.add(new ListItem("TX", "Texas"));
    demoBox.add(new ListItem("UT", "Utah"));
    demoBox.add(new ListItem("VT", "Vermont"));
    demoBox.add(new ListItem("VA", "Virginia"));
    demoBox.add(new ListItem("WA", "Washington"));
    demoBox.add(new ListItem("WV", "West Virginia"));
    demoBox.add(new ListItem("WI", "Wisconsin"));
    demoBox.add(new ListItem("WY", "Wyoming"));
  }
}
