package com.webforj.samples.views.fields.colorfield;

import java.awt.Color;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.event.ModifyEvent;
import com.webforj.component.field.ColorField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet("context://css/fields/colorfield/colorFieldDemo.css")
@Route
@FrameTitle("Color Field Demo")
public class ColorFieldView extends Composite<FlexLayout> {

  ColorField colorField;
  Color[] tetradic = new Color[4];
  Div[] colors;

  public ColorFieldView() {
    getBoundComponent().setDirection(FlexDirection.COLUMN).setAlignment(FlexAlignment.CENTER)
    .setJustifyContent(FlexJustifyContent.CENTER).setSpacing("var(--dwc-space-l")
    .setMargin("var(--dwc-space-m)");

    colorField = new ColorField();
    colorField.setWidth("200px")
        .setLabel("Choose a color:")
        .onModify(this::tetradicColor);

    colors = new Div[4];
    for (int i = 0; i <= 3; i++) {
      colors[i] = new Div();
      colors[i].addClassName("colorDiv");
    }

    FlexLayout colorDisplay = FlexLayout.create(colors)
        .horizontal()
        .justify().center()
        .align().center()
        .build();
    
    colorDisplay.setSpacing("20px");

    Paragraph title = new Paragraph("Tetradic complementary colors:");

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

  private void setBackgroundColor(Div colorPanel, Color color) {
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