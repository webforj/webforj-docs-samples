package layout_demos.splitter;

import com.webforj.App;
import com.webforj.component.layout.splitter.Splitter;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class SplitterBasic extends App {

  @Override
  public void run() throws WebforjException {
    Frame mainFrame = new Frame();

    SplitterBox master = new SplitterBox("Master", SplitterBox.Theme.INFO);
    SplitterBox detail = new SplitterBox("Detail", SplitterBox.Theme.SUCCESS);
    Splitter splitter = new Splitter(master, detail);

    mainFrame.add(splitter);
  }
}
