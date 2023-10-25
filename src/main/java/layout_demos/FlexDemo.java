package layout_demos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.field.PasswordField;
import org.dwcj.component.field.TextField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.maskednumberfield.MaskedNumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/flexstyles/form_styles.css")
public class FlexDemo extends App {

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
  public void run() throws DwcjException {

    Frame page = new Frame();

    email = new TextField().setLabel("Email");
    password = new PasswordField().setLabel("Password");
    firstName = new TextField().setLabel("First Name");
    lastName = new TextField().setLabel("Last Name");
    address = new TextField().setLabel("Address");
    city = new TextField().setLabel("City");
    zip = new MaskedNumberField().setAttribute("label", "Zip");

    populateStates();
    submit = new Button("Submit").setTheme(ButtonTheme.PRIMARY);
    cancel = new Button("Cancel").setTheme(ButtonTheme.DEFAULT);

    FlexLayout mainLayout = FlexLayout.create()
        .vertical()
        .build()
        .addClassName("main__layout");

    FlexLayout rowOne = FlexLayout.create(email, password)
        .horizontal()
        .wrap().wrap()
        .build();

    FlexLayout rowTwo = FlexLayout.create(firstName, lastName)
        .horizontal()
        .wrap().wrap()
        .build();

    FlexLayout rowThree = FlexLayout.create(city, states, zip)
        .horizontal()
        .wrap().wrap()
        .build();
    rowThree.setItemBasis("50%", city);
    rowThree.setItemBasis("30%", states);
    zip.setStyle("width", "50px");

    FlexLayout rowFour = FlexLayout.create(cancel, submit)
        .horizontalReverse()
        .build();

    mainLayout.add(rowOne, rowTwo, address, rowThree, rowFour);
    page.add(mainLayout);
  }

  private void populateStates() {
    states = new ChoiceBox().selectIndex(0).setLabel("State").setMaxRowCount(7);
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
