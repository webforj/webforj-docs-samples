package demos.webcomponents.elementcomposite;

import org.dwcj.App;
import org.dwcj.annotation.Attribute;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.annotation.JavaScript;
import org.dwcj.component.element.ElementComposite;
import org.dwcj.component.element.annotation.NodeName;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/* css */"""
  .frame{
    margin: 20px
  }
  """)
public class QRDemo extends App {
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("frame");

    QRCode qrCode = new QRCode();

    window.add(qrCode);
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

    /**
     * Create a new QRCode.
     */
    public QRCode() {
      super();
    }
  }
}