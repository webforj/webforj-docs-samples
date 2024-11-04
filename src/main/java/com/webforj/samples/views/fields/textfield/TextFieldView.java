package com.webforj.samples.views.fields.textfield;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.component.window.Frame;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Text Field Form")
public class TextFieldView extends Composite<FlexLayout> {

  public TextFieldView() {
    getBoundComponent().setMargin("var(--dwc-space-l)").setSpacing("var(--dwc-space-l)")
    .setDirection(FlexDirection.ROW).setWrap(FlexWrap.WRAP);
        
    TextField nameField = new TextField();
    nameField.setPlaceholder("Name").setType(TextField.Type.TEXT).setLabel("Enter Name")
    .setValue("John Doe");
        
    TextField emailField = new TextField();
    emailField.setPlaceholder("Email").setType(TextField.Type.EMAIL).setLabel("Enter Email")
    .setValue("example@email.com");
        
    TextField telField = new TextField();
    telField.setPlaceholder("Phone Number").setType(TextField.Type.TEL).setLabel("Enter Phone Number")
    .setValue("(123) 456-7890");
        
    TextField urlField = new TextField();
    urlField.setPlaceholder("URL").setType(TextField.Type.URL).setLabel("Enter URL")
    .setValue("https://www.example.com");
        
    TextField searchField = new TextField();
    searchField.setPlaceholder("Search").setType(TextField.Type.SEARCH).setLabel("Enter Your Search")
    .setValue("Search...");
    
    getBoundComponent().add(nameField, emailField, telField, urlField, searchField);

  }
}