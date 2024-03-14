package componentdemos.radiobuttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.optioninput.RadioButton.Activation;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonActivation extends App{
  @Override
  public void run() throws WebforjException {
      Frame window = new Frame();
      window.addClassName("frame");

      RadioButton autoActivateOne = new RadioButton("Auto Activated");
      autoActivateOne.setActivation(Activation.AUTO)
        .focus();

      RadioButton autoActivateTwo = new RadioButton("Auto Activated");
      autoActivateTwo.setActivation(Activation.AUTO);

      RadioButton manualActivateOne = new RadioButton("Manually Activated");
      RadioButton manualActivateTwo = new RadioButton("Manually Activated");
     
      window.add(autoActivateOne, autoActivateTwo, manualActivateOne, manualActivateTwo);
  }
}
