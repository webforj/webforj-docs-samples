package demos.webcomponents.elementcomposite;

import java.awt.Color;
import java.util.Map;

import com.webforj.App;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.annotation.JavaScript;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.event.ComponentEvent;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/* css */"""
  .frame{
    display: flex;
    flex-direction: column;
    gap: 10px;
    margin: 20px
  }
  """)
public class QREvent extends App {
  
  Div label = new Div("Click Me!");
  QRCode qrCode = new QRCode("www.dwcj.org");

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");

    window.add(label, qrCode);
    qrCode.setSize(200);
    qrCode.setColor("#000");

    /* Adding an onClick event */
    qrCode.onClick(e -> msgbox("Client X:" + e.getClientX()));
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

      /* Adding the onClick registration method */
      public ListenerRegistration<ClickEvent> onClick(EventListener<ClickEvent> listener) {
      return addEventListener(ClickEvent.class, listener);
    }

  }

  /* Creating a click event. */
  @EventName("click")
  @EventOptions(data = {@EventOptions.EventData(key = "clientX", exp = "event.clientX")})
  public static class ClickEvent extends ComponentEvent<QRCode> {

    public ClickEvent(QRCode source, Map<String, Object> detail) {
      super(source, detail);
    }

    public int getClientX() {
      return (int) getEventMap().get("clientX");
    }
  }
}