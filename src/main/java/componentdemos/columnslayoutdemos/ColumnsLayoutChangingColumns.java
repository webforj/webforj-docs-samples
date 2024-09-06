package componentdemos.columnslayoutdemos;

import java.util.List;

import com.webforj.component.layout.columnslayout.ColumnsLayout;
import com.webforj.component.layout.columnslayout.ColumnsLayout.Breakpoint;
import com.webforj.App;
import com.webforj.component.optioninput.RadioButton;
import com.webforj.component.optioninput.RadioButtonGroup;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ColumnsLayoutChangingColumns extends App{
  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();    

    RadioButton agree = new RadioButton("Agree");
    RadioButton neutral = new RadioButton("Neutral");
    RadioButton disagree = new RadioButton("Disagree");

    RadioButtonGroup group = new RadioButtonGroup(agree, neutral, disagree);
    
    List<Breakpoint> breaks = List.of(
      new Breakpoint("one", 0, 1),
      new Breakpoint("three", 500, 3));

    ColumnsLayout layout = new ColumnsLayout(breaks, group, agree, neutral, disagree);
    
    frame.add(layout);
    frame.setStyle("margin", "20px");
  }
}
