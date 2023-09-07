package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.optioninput.RadioButtonGroup;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonGroupDemo extends App{

    @Override
    public void run() throws DwcjAppInitializeException {

        Frame window = new Frame();

        RadioButton sAgree = new RadioButton("Strongly Agree");
        RadioButton agree = new RadioButton("Agree");
        RadioButton neutral = new RadioButton("Neutral");
        RadioButton disagree = new RadioButton("Disagree");
        RadioButton sDisagree = new RadioButton("Strongly Disagree");

        RadioButtonGroup group = new RadioButtonGroup(sDisagree, disagree, neutral, agree, sAgree);

        group.setAttribute("label", "Choose an Option");

        FlexLayout layout = FlexLayout.create(group)
        .vertical()
        .wrap().wrap()
        .build()
        .addClassName("layout");
       
        window.add(layout);
    }
}
