package com.webforj.samples.views.fields.colorfield;

import java.awt.Color;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.event.ModifyEvent;
import com.webforj.component.field.ColorField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.text.Label;
import com.webforj.component.window.Panel;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fieldstyles/colorFieldDemo.css")
@Route
@FrameTitle("Color Field Demo")
public class ColorFieldDemoView extends Composite<Div> {

  ColorField colorField;
  Color[] tetradic = new Color[4];
  Panel[] colors;

  public ColorFieldDemoView() {
    getBoundComponent().addClassName("main__window");

    colorField = new ColorField();
    colorField.addClassName("color__field")
        .setLabel("Choose a color:")
        .onModify(this::tetradicColor);

    colors = new Panel[4];
    for (int i = 0; i <= 3; i++) {
      colors[i] = new Panel();
          colors[i].addClassName("color__panel");
    }

    FlexLayout colorDisplay = FlexLayout.create(colors)
        .horizontal()
        .justify().center()
        .align().center()
        .build()
        .addClassName("display__panel");
    colorDisplay.setSpacing("20px");

    Label title = new Label("Tetradic complementary colors:");

    colorField.setValue(Color.RED);
    tetradicColor(null);

    getBoundComponent().add(colorField, title, colorDisplay);
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