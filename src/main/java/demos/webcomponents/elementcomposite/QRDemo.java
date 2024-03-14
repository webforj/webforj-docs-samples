package demos.webcomponents.elementcomposite;

import com.webforj.App;
import com.webforj.annotation.Attribute;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.annotation.JavaScript;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.html.elements.Div;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/* css */"""
  .frame{
    margin: 20px
  }
  """)
public class QRDemo extends App {

  QRCode qrCode = new QRCode();
  
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");
    Div test = new Div();
    test.add(qrCode);


    window.add(test);
  }

  /**
   * QRCode Generator using Shoelace QRCode component.
   */
  @JavaScript(
      value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.0.0-beta.87/dist/shoelace.js",
      attributes = {@Attribute(name = "type", value = "module")})
  @NodeName("sl-qr-code")
  public final class QRCode extends ElementComposite {

    /**
     * Create a new QRCode.
     */
    public QRCode() {
      super();
    }
  }
}