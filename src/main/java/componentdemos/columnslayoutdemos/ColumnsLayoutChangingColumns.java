package componentdemos.columnslayoutdemos;

import java.util.List;

import com.webforj.component.layout.columnslayout.ColumnsLayout;
import com.webforj.component.layout.columnslayout.ColumnsLayout.Breakpoint;
import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class ColumnsLayoutChangingColumns extends App{
  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();    

    Button home = new Button("Home", ButtonTheme.PRIMARY);
    home.setMaxWidth("150px");
    Button inbox = new Button("Inbox");
    inbox.setMaxWidth("150px");
    Button settings = new Button("Settings");
    settings.setMaxWidth("150px");
    
    List<Breakpoint> breaks = List.of(
      new Breakpoint("one", 0, 1),
      new Breakpoint("three", 500, 3));

    ColumnsLayout layout = new ColumnsLayout(breaks, home, inbox, settings);
    
    frame.add(layout);
    frame.setStyle("margin", "10px 20%");
  }
}
