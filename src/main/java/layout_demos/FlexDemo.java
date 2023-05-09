package layout_demos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.field.Field;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.numberfield.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/flexstyles/form_styles.css")
public class FlexDemo extends App{

  Field email;
  Field password;
  Field firstName;
  Field lastName;
  Field address;
  Field city;
  ChoiceBox states;
  NumberField zip;
  Button submit;
  Button cancel;
  
  @Override
  public void run() throws DwcjException{

    Frame page = new Frame();
    email = new Field().setAttribute("placeholder", "Email");
    password = new Field().setAttribute("placeholder", "Password")
      .setAttribute("type", "password");
    firstName = new Field().setAttribute("placeholder", "First Name");
    lastName = new Field().setAttribute("placeholder", "Last Name");
    address = new Field().setAttribute("placeholder", "Address");
    city = new Field().setAttribute("placeholder", "City");
    zip = new NumberField().setAttribute("placeholder", "Zip");
    populateStates();
    submit = new Button("Submit").setTheme(Button.Theme.PRIMARY);
    cancel = new Button("Cancel").setTheme(Button.Theme.DEFAULT);
    
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

  private void populateStates(){
    states = new ChoiceBox().selectIndex(0);
      states.addItem("AL", "Alabama");
      states.addItem("AK", "Alaska");
      states.addItem("AZ", "Arizona");
      states.addItem("AR", "Arkansas");
      states.addItem("CA", "California");
      states.addItem("CO", "Colorado");
      states.addItem("CT", "Connecticut");
      states.addItem("DE", "Delaware");
      states.addItem("FL", "Florida");
      states.addItem("GA", "Georgia");
      states.addItem("HI", "Hawaii");
      states.addItem("ID", "Idaho");
      states.addItem("IL", "Illinois");
      states.addItem("IN", "Indiana");
      states.addItem("IA", "Iowa");
      states.addItem("KS", "Kansas");
      states.addItem("KY", "Kentucky");
      states.addItem("LA", "Louisiana");
      states.addItem("ME", "Maine");
      states.addItem("MD", "Maryland");
      states.addItem("MA", "Massachusetts");
      states.addItem("MI", "Michigan");
      states.addItem("MN", "Minnesota");
      states.addItem("MS", "Mississippi");
      states.addItem("MO", "Missouri");
      states.addItem("MT", "Montana");
      states.addItem("NE", "Nebraska");
      states.addItem("NV", "Nevada");
      states.addItem("NH", "New Hampshire");
      states.addItem("NJ", "New Jersey");
      states.addItem("NM", "New Mexico");
      states.addItem("NY", "New York");
      states.addItem("NC", "North Carolina");
      states.addItem("ND", "North Dakota");
      states.addItem("OH", "Ohio");
      states.addItem("OK", "Oklahoma");
      states.addItem("OR", "Oregon");
      states.addItem("PA", "Pennsylvania");
      states.addItem("RI", "Rhode Island");
      states.addItem("SC", "South Carolina");
      states.addItem("SD", "South Dakota");
      states.addItem("TN", "Tennessee");
      states.addItem("TX", "Texas");
      states.addItem("UT", "Utah");
      states.addItem("VT", "Vermont");
      states.addItem("VA", "Virginia");
      states.addItem("WA", "Washington");
      states.addItem("WV", "West Virginia");
      states.addItem("WI", "Wisconsin");
      states.addItem("WY", "Wyoming");
  }

}
