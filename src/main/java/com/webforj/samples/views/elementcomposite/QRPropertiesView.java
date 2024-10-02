package com.webforj.samples.views.elementcomposite;

import java.awt.Color;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.annotation.JavaScript;
import com.webforj.component.Composite;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.html.elements.Div;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@InlineStyleSheet(/* css */"""
  .frame{
    margin: 20px
  }
  """)
@Route
@FrameTitle("QR Properties")
public class QRPropertiesView extends Composite<Div> {
  
  QRCode qrCode = new QRCode("www.dwcj.org");

  public QRPropertiesView() {
    getBoundComponent().addClassName("frame");

    getBoundComponent().add(qrCode);

    /* Setting the properties */
    qrCode.setSize(200);
    qrCode.setColor("#0059B8");
  }

  /**
   * QRCode Generator using Shoelace QRCode component.
   */
  @JavaScript(
      value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.0.0-beta.87/dist/shoelace.js",
      attributes = {@Attribute(name = "type", value = "module")})
  @NodeName("sl-qr-code")
  public final class QRCode extends ElementComposite {
  
    private final PropertyDescriptor<String> VALUE = PropertyDescriptor.property("value", "");
    private final PropertyDescriptor<Integer> SIZE = PropertyDescriptor.property("size", 128);
    private final PropertyDescriptor<String> COLOR = PropertyDescriptor.property("fill", "#000000");
  
    /**
     * Create a new QRCode.
     */
    public QRCode() {
      super();
    }
  
    public QRCode(String value) {
      super();
      this.setValue(value);
    }
  
    public QRCode(String value, int size) {
      super();
      this.setValue(value);
      this.setSize(size);
    }
  
    public String getValue() {
      return get(VALUE);
    }
  
    public QRCode setValue(String value) {
      set(VALUE, value);
      return this;
    }
  
    public int getSize() {
      return get(SIZE);
    }

    public QRCode setSize(int size) {
      set(SIZE, size);
      return this;
    }
  
    public Color getColor() {
      String hex = get(COLOR);
      return Color.decode(hex);
    }

    public QRCode setColor(Color color) {
      String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
      set(COLOR, hex);
      return this;
    }

    public QRCode setColor(String color) {
      set(COLOR, color);
      return this;
    }
  }
}