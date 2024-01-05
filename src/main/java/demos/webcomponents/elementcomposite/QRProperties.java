package demos.webcomponents.elementcomposite;

import java.awt.Color;

import org.dwcj.App;
import org.dwcj.annotation.Attribute;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.annotation.JavaScript;
import org.dwcj.component.element.ElementComposite;
import org.dwcj.component.element.PropertyDescriptor;
import org.dwcj.component.element.annotation.NodeName;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/* css */"""
  .frame{
    margin: 20px
  }
  """)
public class QRProperties extends App {
  
  QRCode qrCode = new QRCode("www.dwcj.org");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    window.add(qrCode);

    /* Setting the properties */
    qrCode.setSize(200);
    qrCode.setColor("#0059B8");
  }

  /**
   * QRCode Generator using Shoelace QRCode component.
   *
   * @author Hyyan Abo Fakher
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