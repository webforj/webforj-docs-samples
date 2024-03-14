package componentdemos.checkboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.concern.HasTextPosition.Position;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.optioninput.CheckBox;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet(/*css */"""
  .frame {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 50px;
    margin: 10px;
  }  
""")
public class CheckboxHorizontalText extends App {
  
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("frame");

    FlexLayout rightAligned = FlexLayout.create()
    .vertical()
    .build()
    .setStyle("width", "100px");
    
    FlexLayout leftAligned = FlexLayout.create()
    .vertical()
    .align().end()
    .build()
    .setStyle("width", "100px");

    rightAligned.add(
      new CheckBox("Daily", true),
      new CheckBox("Weekly"),
      new CheckBox("Bi-Weekly"),
      new CheckBox("Monthly"),
      new CheckBox("Annually")
    );
    
    leftAligned.add(
      new CheckBox("Daily", true).setTextPosition(Position.LEFT),
      new CheckBox("Weekly").setTextPosition(Position.LEFT),
      new CheckBox("Bi-Weekly").setTextPosition(Position.LEFT),
      new CheckBox("Monthly").setTextPosition(Position.LEFT),
      new CheckBox("Annually").setTextPosition(Position.LEFT)
    );

    window.add(rightAligned, leftAligned);
  }
}
