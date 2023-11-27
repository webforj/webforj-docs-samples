package componentdemos.fielddemos;

import java.awt.Color;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.event.ModifyEvent;
import org.dwcj.component.field.ColorField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.text.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/color_field_styles.css")
public class ColorFieldDemo extends App {

  ColorField colorField;
  Color[] tetradic = new Color[4];
  Panel[] colors;

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    colorField = new ColorField();
    colorField.addClassName("color__field")
        .setLabel("Choose a color:")
        .onModify(this::tetradicColor);

    colors = new Panel[4];
    for (int i = 0; i <= 3; i++) {
      colors[i] = new Panel()
          .addClassName("color__panel");
    }

    FlexLayout colorDisplay = FlexLayout.create(colors)
        .horizontal()
        .justify().center()
        .align().center()
        .build()
        .addClassName("display__panel");
    colorDisplay.setSpacing("20px");

    Label title = new Label("Tetradic compliment colors:");

    colorField.setValue(Color.RED);
    tetradicColor(null);

    window.add(colorField, title, colorDisplay);
  }

  private void tetradicColor(ModifyEvent e) {
    Color selected = colorField.getValue();
    setBackgroundColor(colors[0], selected);
    int baseHue = getHue(selected);
    for (int i = 1; i <= 3; i++) {
      int hue = (baseHue + i * 60) % 360;
      setBackgroundColor(colors[i], Color.getHSBColor(hue / 360.0f, getSaturation(selected), getBrightness(selected)));
    }
  }

  private void setBackgroundColor(Panel colorPanel, Color color) {
    colorPanel.setStyle("background-color", "rgb(" + String.valueOf(color.getRed()) +
        "," + String.valueOf(color.getGreen()) +
        "," + String.valueOf(color.getBlue()) +
        ")");
  }

  private static int getHue(Color color) {
    float[] hsbValues = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
    return (int) (hsbValues[0] * 360);
  }

  private static float getSaturation(Color color) {
    float[] hsbValues = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
    return hsbValues[1];
  }

  private static float getBrightness(Color color) {
    float[] hsbValues = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
    return hsbValues[2];
  }
}