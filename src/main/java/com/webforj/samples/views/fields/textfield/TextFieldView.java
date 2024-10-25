package com.webforj.samples.views.fields.textfield;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Text Field Form")
public class TextFieldView extends Composite<FlexLayout> {

  public TextFieldView() {
    getBoundComponent().setMargin("var(--dwc-space-l)").setSpacing("var(--dwc-space-l)")
    .setDirection(FlexDirection.ROW);
        
    TextField nameField = new TextField();
    nameField.setPlaceholder("Name").setType(TextField.Type.TEXT);
        
    TextField emailField = new TextField();
    emailField.setPlaceholder("Email").setType(TextField.Type.EMAIL);
        
    TextField telField = new TextField();
    telField.setPlaceholder("Phone Number").setType(TextField.Type.TEL);
        
    TextField urlField = new TextField();
    urlField.setPlaceholder("URL").setType(TextField.Type.URL);
        
    TextField searchField = new TextField();
    searchField.setPlaceholder("Search").setType(TextField.Type.SEARCH);
    
    getBoundComponent().add(nameField, emailField, telField, urlField, searchField);

  }
}
