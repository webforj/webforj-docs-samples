package componentdemos.toastdemos;

import com.webforj.App;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ToastTheme extends App {
  int counter = 1;
  Frame frame;
  String text = "Toast!";
  int duration = 3000;

  @Override
  public void run() throws WebforjException {
    
    frame = new Frame();
    frame.setStyle("padding", "1em");

    Button defaultButton = new Button("Default Toast", e -> Toast.show(text, duration, Theme.DEFAULT)).setTheme(ButtonTheme.DEFAULT);
    Button successButton = new Button("Success Toast", e -> Toast.show(text, duration, Theme.SUCCESS)).setTheme(ButtonTheme.SUCCESS);
    Button dangerButton  = new Button("Danger Toast",  e -> Toast.show(text, duration, Theme.DANGER)).setTheme(ButtonTheme.DANGER);
    Button warningButton = new Button("Warning Toast", e -> Toast.show(text, duration, Theme.WARNING)).setTheme(ButtonTheme.WARNING);
    Button infoButton    = new Button("Info Toast",    e -> Toast.show(text, duration, Theme.INFO)).setTheme(ButtonTheme.INFO);
    Button grayButton    = new Button("Gray Toast",    e -> Toast.show(text, duration, Theme.GRAY)).setTheme(ButtonTheme.GRAY);
    Button primaryButton = new Button("Primary Toast", e -> Toast.show(text, duration, Theme.PRIMARY)).setTheme(ButtonTheme.PRIMARY);
    
    FlexLayout flex = new FlexLayout().setWrap(FlexWrap.WRAP);

    flex.add(defaultButton);
    flex.add(successButton);
    flex.add(dangerButton);
    flex.add(warningButton);
    flex.add(infoButton);
    flex.add(grayButton);
    flex.add(primaryButton);
    frame.add(flex);
  }
}
