package componentdemos.comboboxdemos;

import java.util.ArrayList;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.layout.flexlayout.FlexAlignment;
import org.dwcj.component.layout.flexlayout.FlexContentAlignment;
import org.dwcj.component.layout.flexlayout.FlexDirection;
import org.dwcj.component.layout.flexlayout.FlexJustifyContent;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.layout.flexlayout.FlexWrap;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.progressbar.ProgressBar;
import org.dwcj.component.slider.Slider;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.concern.HasExpanse;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_styles.css")
@InlineStyleSheet(/* css */"""
      .layout__drawer{
        display: flex;
        flex-direction: column;
        align-items: center;
      }

      .drawer__options{
        padding: 2em 10px 0 10px;
      }

      .content__components{
        height: 100%;
      }
    """)
public class ChoiceBoxDemo extends App {

  ChoiceBox appThemes = new ChoiceBox("App Themes");
  ChoiceBox componentThemes = new ChoiceBox("Component Themes");
  ChoiceBox expanses = new ChoiceBox("Expanses");

  Button demoButton = new Button("Button");
  CheckBox demoCheckBox = new CheckBox("CheckBox");
  RadioButton demoRadioButton = new RadioButton("Radio Button");
  RadioButton demoSwitch = new RadioButton("Switch");
  Slider demoSlider = new Slider();
  ProgressBar demoProgressBar = new ProgressBar();

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    AppLayout demo = new AppLayout();
    window.add(demo);

    // Header
    demo.getHeader().addClassName("layout__header")
        .add(new Label(/* html */"""
              <html>
                <bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button>
              </html>
            """),
            new Label("DWCJ Application")
                .addClassName("layout__header--title"));

    Panel drawer = demo.getDrawer();
    drawer.addClassName("app-layout-drawer");

    // Drawer's logo container and logo
    drawer.add(new Panel().addClassName("drawer__logo").add(
        new Label(/* html */"""
            <html>
              <img src='https://i.ibb.co/1n4n1Nh/logo.png'></img>
            </html>
            """)));

    // Drawer's Menu
    FlexLayout options = new FlexLayout()
        .setDirection(FlexDirection.COLUMN)
        .setAlignContent(FlexContentAlignment.CENTER)
        .setSpacing("2rem");
    drawer.add(options);
    options.addClassName("drawer__options");
    options.add(appThemes, componentThemes, expanses);

    populateAppThemes();
    populateComponentThemes();
    populateExpaneses();

    appThemes.onSelect(e -> {
      App.setTheme((Theme) e.getSelectedItem().getKey());
    });

    componentThemes.onSelect(e -> {
      demoButton.setTheme(ButtonTheme.valueOf(e.getSelectedItem().getText().toUpperCase()));
      demoSlider.setAttribute("theme", e.getSelectedItem().getText());
      demoProgressBar
          .setAttribute("theme", e.getSelectedItem().getText());
    });

    HasExpanse[] expanseArray = { demoButton, demoCheckBox, demoRadioButton, demoSwitch };
    expanses.onSelect(e -> {
      for (HasExpanse component : expanseArray) {
        component.setExpanse((Expanse) e.getSelectedItem().getKey());
      }
    });

    // Content
    FlexLayout components = new FlexLayout()
        .setAlignment(FlexAlignment.CENTER)
        .setJustifyContent(FlexJustifyContent.CENTER)
        .setWrap(FlexWrap.WRAP)
        .setSpacing("2rem");
    demo.setContent(components);
    components.addClassName("content__components");
    demoSwitch.setSwitch(true);
    components.add(demoButton, demoCheckBox, demoRadioButton, demoSwitch, demoSlider, demoProgressBar);
    demoProgressBar.setValue(50);
  }

  private void populateAppThemes() {
    ArrayList<ListItem> themes = new ArrayList<>();
    for (Theme theme : Theme.values()) {
      themes.add(new ListItem(theme, theme.getValue()));
    }
    this.appThemes.insert(themes)
        .selectKey(Theme.LIGHT);
  }

  private void populateComponentThemes() {
    ArrayList<ListItem> themes = new ArrayList<>();
    for (org.dwcj.component.Theme theme : org.dwcj.component.Theme.values()) {
      themes.add(new ListItem(theme, theme.getValue()));
    }
    this.componentThemes.insert(themes)
        .selectKey(org.dwcj.component.Theme.DEFAULT);
  }

  private void populateExpaneses() {
    ArrayList<ListItem> expanses = new ArrayList<>();
    for (Expanse expanse : Expanse.values()) {
      expanses.add(new ListItem(expanse, expanse.getValue()));
    }
    this.expanses.insert(expanses)
        .selectKey(Expanse.NONE)
        .get(Expanse.NONE)
        .setText("none");
  }
}
