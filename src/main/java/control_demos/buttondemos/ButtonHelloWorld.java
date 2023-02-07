package control_demos.buttondemos;
import org.dwcj.App;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;

import org.dwcj.exceptions.DwcAppInitializeException;


public class ButtonHelloWorld extends App {
    
    private TextBox edFirstname;
    private TextBox edLastname;

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();

        //Initial styling for the application panel
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr 2fr");
        panel.setStyle("gap", "20px");
        panel.setStyle("left", "20px");
        panel.setStyle("top", "20px");
        panel.setStyle("border", "1px dotted");
        panel.setStyle("padding", "10px");

        // Adding some labels and TextBox controls to use in the demonstration

        panel.add(new Label("Firstname:"));
        edFirstname = new TextBox();
        panel.add(edFirstname);

        panel.add(new Label("Lastname:"));
        edLastname = new TextBox("");
        panel.add(edLastname);


        
        //Creating the button and using the parameterized constructor for initial text
        Button helloBtn = new Button("Display Name");

        //adding the button to our application panel
        panel.add(helloBtn);

        //Setting the theme, expanse and text alignment using the Button's enum values
        helloBtn.setTheme(Button.Theme.PRIMARY);
        helloBtn.setExpanse(Button.Expanse.LARGE);
        helloBtn.setVerticalAlignment(Button.TextVerticalAlignment.CENTER);

        //Setting a click event for the first button
        helloBtn.onClick(this::onHelloButtonPush);
        
        

        //Repeating the above functionality for the second button
        Button deleteBtn = new Button("Clear Text");
        panel.add(deleteBtn);
        deleteBtn.setTheme(Button.Theme.DANGER);
        deleteBtn.setExpanse(Button.Expanse.LARGE);
        deleteBtn.setVerticalAlignment(Button.TextVerticalAlignment.CENTER);
        deleteBtn.onClick(this::onDeleteButtonPush);
        
        
        
        //Styling for both buttons
        helloBtn.setStyle("grid-column", "1 / span 2");
        helloBtn.setStyle("width", "100%");
        deleteBtn.setStyle("grid-column", "1 / span 2");
        deleteBtn.setStyle("width", "100%");
        
    }
        
    //Implementing behavior for the first button
    private void onHelloButtonPush(ButtonClickEvent ev) {
        String text = edFirstname.getText() + " " + edLastname.getText();
        App.msgbox(text, 0, "Hello World");
    } 
    
    //Implementing behavior for the second button
    private void onDeleteButtonPush(ButtonClickEvent ev) {
        edFirstname.setText("");
        edLastname.setText("");
    } 
}