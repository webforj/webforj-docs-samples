package componentdemos.comboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.text.Label;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/comboboxstyles/demo_styles.css")
public class ChoiceBoxDemo extends App {

    ChoiceBox languageSelection;
    Label text;

    @Override
    public void run() throws DwcjAppInitializeException {
        Frame window = new Frame();
        window.addClassName("frame");

        text = new Label("Hello, World!");
        text.addClassName("text");
        languageSelection = new ChoiceBox();
        window.add(languageSelection, text);

        languageSelection.add("Hello, World!", "English");
        languageSelection.add("Hallo, Welt!", "German");
        languageSelection.add("Hola, Mundo!", "Spanish");
        languageSelection.add("Salut le Monde!", "French");
        languageSelection.add("Hallo, Wereld!", "Dutch"); 
        languageSelection.add("Dia dhaoibh, a dhomhain!", "Irish"); 

        languageSelection.onSelect(e -> {
          text.setText(e.getSelectedItem().getKey().toString());
        });

        languageSelection.setLabel("Language")
          .selectIndex(0);
    }
}
