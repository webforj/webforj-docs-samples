package componentdemos.comboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.text.Label;
import org.dwcj.exceptions.DwcjAppInitializeException;

@InlineStyleSheet("context://css/comboboxstyles/demo_styles.css")
public class ChoiceBoxDemo extends App {

    ChoiceBox languageSelection = new ChoiceBox("Language");
    Label text = new Label("Hello, World!");

    @Override
    public void run() throws DwcjAppInitializeException {
        Frame window = new Frame();
        window.addClassName("frame");

        text = new Label("Hello, World!");
        text.addClassName("text");
        window.add(languageSelection, text);

        String[] hellos = {"Hello, World!", "Hallo, Welt!", "Hola, Mundo!", "Salut le Monde!", "Hallo, Wereld!", "Dia dhaoibh, a dhomhain!"};

        languageSelection.add("English", "English");
        languageSelection.add("German", "German");
        languageSelection.add("Spanish", "Spanish");
        languageSelection.add("French", "French");
        languageSelection.add("Dutch", "Dutch"); 
        languageSelection.add("Irish", "Irish");
        languageSelection.selectIndex(0);
        
        languageSelection.onSelect(e -> {
          text.setText(hellos[e.getSelectedIndex()]);
        });
    }
}
