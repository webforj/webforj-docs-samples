package componentdemos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.concern.HasTextPosition.Position;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.exceptions.DwcjException;

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
  public void run() throws DwcjException {
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
