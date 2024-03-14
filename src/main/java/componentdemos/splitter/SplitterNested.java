package componentdemos.splitter;

import com.webforj.App;
import com.webforj.component.layout.splitter.Splitter;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class SplitterNested extends App {

  @Override
  public void run() throws WebforjException {
    Frame mainFrame = new Frame();

    SplitterBox top = new SplitterBox("Top", SplitterBox.Theme.WARNING);
    SplitterBox bottom = new SplitterBox("Bottom", SplitterBox.Theme.SUCCESS);
    Splitter verticalSplitter = new Splitter(top, bottom);
    verticalSplitter.setOrientation(Splitter.Orientation.VERTICAL);

    SplitterBox master = new SplitterBox("Start", SplitterBox.Theme.INFO);
    Splitter horizontalSplitter = new Splitter(master, verticalSplitter);

    mainFrame.add(horizontalSplitter);
  }
}
