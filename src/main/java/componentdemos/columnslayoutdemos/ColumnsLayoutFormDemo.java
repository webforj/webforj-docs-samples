package componentdemos.columnslayoutdemos;

import java.util.List;

import com.webforj.component.layout.columnslayout.ColumnsLayout;
import com.webforj.component.layout.columnslayout.ColumnsLayout.Breakpoint;
import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.MaskedNumberField;
import com.webforj.component.field.PasswordField;
import com.webforj.component.field.TextField;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ColumnsLayoutFormDemo extends App {

  TextField email;
  PasswordField password;
  TextField firstName;
  TextField lastName;
  TextField address;
  TextField city;
  ChoiceBox states;
  MaskedNumberField zip;
  Button submit;
  Button cancel;

  @Override
  public void run() throws WebforjException {

    Frame frame = new Frame();

    email = new TextField("Email");
    password = new PasswordField("Password");
    firstName = new TextField("First Name");
    lastName = new TextField("Last Name");
    address = new TextField("Address");
    city = new TextField("City");
    zip = new MaskedNumberField("Zip");

    populateStates();

    submit = new Button("Submit", ButtonTheme.PRIMARY);
    cancel = new Button("Cancel", ButtonTheme.DEFAULT);

    ColumnsLayout layoutOne = new ColumnsLayout(email, password, firstName, lastName, address)
        .setSpan(address, 2)
        .setSpacing(10);

    List<Breakpoint> listButtonsBreaks = List.of(
        new Breakpoint("small", 100, 1),
        new Breakpoint("medium", 150, 2));

    ColumnsLayout layoutButtons = new ColumnsLayout(listButtonsBreaks, submit, cancel);

    List<Breakpoint> listBreaks = List.of(
        new Breakpoint("small", 200, 1),
        new Breakpoint("medium", 400, 2),
        new Breakpoint("large", 800, 4),
        new Breakpoint("xlarge", 1250, 4));

    ColumnsLayout layoutTwo = new ColumnsLayout(listBreaks, city, states, zip, layoutButtons)
        .setSpan(city, "large", 2)
        .setSpan(layoutButtons, "large", 2)
        .setColumn(layoutButtons, "large", 3)
        .setVerticalAlignment(layoutButtons, ColumnsLayout.Alignment.END)
        .setSpacing(10);

    frame.setStyle("margin", "10px 20%");
    frame.add(layoutOne, layoutTwo);
  }

  private void populateStates() {
    states = new ChoiceBox("State").setMaxRowCount(7);
    states.add("AL", "Alabama");
    states.add("AK", "Alaska");
    states.add("AZ", "Arizona");
    states.add("AR", "Arkansas");
    states.add("CA", "California");
    states.add("CO", "Colorado");
    states.add("CT", "Connecticut");
    states.add("DE", "Delaware");
    states.add("FL", "Florida");
    states.add("GA", "Georgia");
    states.add("HI", "Hawaii");
    states.add("ID", "Idaho");
    states.add("IL", "Illinois");
    states.add("IN", "Indiana");
    states.add("IA", "Iowa");
    states.add("KS", "Kansas");
    states.add("KY", "Kentucky");
    states.add("LA", "Louisiana");
    states.add("ME", "Maine");
    states.add("MD", "Maryland");
    states.add("MA", "Massachusetts");
    states.add("MI", "Michigan");
    states.add("MN", "Minnesota");
    states.add("MS", "Mississippi");
    states.add("MO", "Missouri");
    states.add("MT", "Montana");
    states.add("NE", "Nebraska");
    states.add("NV", "Nevada");
    states.add("NH", "New Hampshire");
    states.add("NJ", "New Jersey");
    states.add("NM", "New Mexico");
    states.add("NY", "New York");
    states.add("NC", "North Carolina");
    states.add("ND", "North Dakota");
    states.add("OH", "Ohio");
    states.add("OK", "Oklahoma");
    states.add("OR", "Oregon");
    states.add("PA", "Pennsylvania");
    states.add("RI", "Rhode Island");
    states.add("SC", "South Carolina");
    states.add("SD", "South Dakota");
    states.add("TN", "Tennessee");
    states.add("TX", "Texas");
    states.add("UT", "Utah");
    states.add("VT", "Vermont");
    states.add("VA", "Virginia");
    states.add("WA", "Washington");
    states.add("WV", "West Virginia");
    states.add("WI", "Wisconsin");
    states.add("WY", "Wyoming");
  }
}
