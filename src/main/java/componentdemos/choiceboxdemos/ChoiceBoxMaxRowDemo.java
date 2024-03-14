package componentdemos.choiceboxdemos;

import java.util.ArrayList;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.button.Button;
import com.webforj.component.field.NumberField;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/* css */"""
.frame {
  display: flex;
  flex-direction: column;
  margin: 20px 0 0 20px;
  gap: 20px;
  width: 200px;
}
""")
public class ChoiceBoxMaxRowDemo extends App {
  
  ChoiceBox demoBox = new ChoiceBox("States");
  NumberField numberField = new NumberField("Number of Rows");
  Button select = new Button("Apply");
  
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");
    window.add(demoBox, numberField, select);

    select.onClick(e -> {
      demoBox.setMaxRowCount(Integer.valueOf(numberField.getText()));
    });

    ArrayList<ListItem> states = new ArrayList<>();
    states.add(new ListItem("AL", "Alabama"));
    states.add(new ListItem("AK", "Alaska"));
    states.add(new ListItem("AZ", "Arizona"));
    states.add(new ListItem("AR", "Arkansas"));
    states.add(new ListItem("CA", "California"));
    states.add(new ListItem("CO", "Colorado"));
    states.add(new ListItem("CT", "Connecticut"));
    states.add(new ListItem("DE", "Delaware"));
    states.add(new ListItem("FL", "Florida"));
    states.add(new ListItem("GA", "Georgia"));
    states.add(new ListItem("HI", "Hawaii"));
    states.add(new ListItem("ID", "Idaho"));
    states.add(new ListItem("IL", "Illinois"));
    states.add(new ListItem("IN", "Indiana"));
    states.add(new ListItem("IA", "Iowa"));
    states.add(new ListItem("KS", "Kansas"));
    states.add(new ListItem("KY", "Kentucky"));
    states.add(new ListItem("LA", "Louisiana"));
    states.add(new ListItem("ME", "Maine"));
    states.add(new ListItem("MD", "Maryland"));
    states.add(new ListItem("MA", "Massachusetts"));
    states.add(new ListItem("MI", "Michigan"));
    states.add(new ListItem("MN", "Minnesota"));
    states.add(new ListItem("MS", "Mississippi"));
    states.add(new ListItem("MO", "Missouri"));
    states.add(new ListItem("MT", "Montana"));
    states.add(new ListItem("NE", "Nebraska"));
    states.add(new ListItem("NV", "Nevada"));
    states.add(new ListItem("NH", "New Hampshire"));
    states.add(new ListItem("NJ", "New Jersey"));
    states.add(new ListItem("NM", "New Mexico"));
    states.add(new ListItem("NY", "New York"));
    states.add(new ListItem("NC", "North Carolina"));
    states.add(new ListItem("ND", "North Dakota"));
    states.add(new ListItem("OH", "Ohio"));
    states.add(new ListItem("OK", "Oklahoma"));
    states.add(new ListItem("OR", "Oregon"));
    states.add(new ListItem("PA", "Pennsylvania"));
    states.add(new ListItem("RI", "Rhode Island"));
    states.add(new ListItem("SC", "South Carolina"));
    states.add(new ListItem("SD", "South Dakota"));
    states.add(new ListItem("TN", "Tennessee"));
    states.add(new ListItem("TX", "Texas"));
    states.add(new ListItem("UT", "Utah"));
    states.add(new ListItem("VT", "Vermont"));
    states.add(new ListItem("VA", "Virginia"));
    states.add(new ListItem("WA", "Washington"));
    states.add(new ListItem("WV", "West Virginia"));
    states.add(new ListItem("WI", "Wisconsin"));
    states.add(new ListItem("WY", "Wyoming"));
    
    demoBox.insert(states);
    demoBox.selectIndex(0);
  }
}
