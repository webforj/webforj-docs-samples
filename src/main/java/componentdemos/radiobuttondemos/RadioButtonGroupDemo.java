package componentdemos.radiobuttondemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.optioninput.RadioButtonGroup;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonGroupDemo extends App{

    @Override
    public void run() throws WebforjException {

        Frame window = new Frame();
        window.addClassName("frame");

        RadioButton sAgree = new RadioButton("Strongly Agree");
        RadioButton agree = new RadioButton("Agree");
        RadioButton neutral = new RadioButton("Neutral");
        RadioButton disagree = new RadioButton("Disagree");
        RadioButton sDisagree = new RadioButton("Strongly Disagree");

        RadioButtonGroup group = new RadioButtonGroup(sDisagree, disagree, neutral, agree, sAgree);

        FlexLayout layout = FlexLayout.create(group,sDisagree, disagree, neutral, agree, sAgree)
        .vertical()
        .wrap().wrap()
        .build()
        .addClassName("layout");
       
        window.add(layout);
    }
}
