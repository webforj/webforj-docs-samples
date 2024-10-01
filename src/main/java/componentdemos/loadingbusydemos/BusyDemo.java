package componentdemos.loadingbusydemos;

import com.webforj.App;
import com.webforj.BusyIndicator;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css */"""
    .window {
      margin: 20px;
    }
    """)
public class BusyDemo extends App {

    @Override
    public void run() throws WebforjException {
        Frame window = new Frame();
        window.addClassName("window");

        FlexLayout formLayout = new FlexLayout();
        formLayout.setJustifyContent(FlexJustifyContent.CENTER); 
        formLayout.setAlignment(FlexAlignment.CENTER);  
        formLayout.setDirection(FlexDirection.COLUMN);

        TextField nameField = new TextField("Name");
        TextField emailField = new TextField("Email");

        Button submitButton = new Button("Submit", e -> showBusyIndicator());
        submitButton.setTheme(ButtonTheme.PRIMARY);

        formLayout.add(nameField, emailField, submitButton);

        window.add(formLayout);

        showBusyIndicator();
    }

    private void showBusyIndicator() {
        BusyIndicator busyIndicator = getBusyIndicator();
        
        busyIndicator.setText("Submitting form... Please wait.")
                     .setBackdropVisible(true);
        busyIndicator.getSpinner().setTheme(Theme.PRIMARY); 

        busyIndicator.open();
    }
}
