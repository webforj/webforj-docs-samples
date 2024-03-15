package componentdemos.splitter;

import com.webforj.App;
import com.webforj.Page;
import com.webforj.component.button.Button;
import com.webforj.component.element.Element;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.splitter.Splitter;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class SplitterAutoSave extends App {

  @Override
  public void run() throws WebforjException {

    SplitterBox topLeft = new SplitterBox("Top Left", SplitterBox.Theme.PRIMARY);
    SplitterBox topRight = new SplitterBox("Top Right", SplitterBox.Theme.INFO);
    Splitter topSplitter = new Splitter("topSplitter", topLeft, topRight);
    topSplitter.setPositionRelative(30);
    topSplitter.setAutosave(true);

    SplitterBox bottomLeft = new SplitterBox("Bottom Left", SplitterBox.Theme.SUCCESS);
    SplitterBox bottomRight = new SplitterBox("Bottom Right", SplitterBox.Theme.WARNING);
    Splitter bottomSplitter = new Splitter("bottomSplitter", bottomLeft, bottomRight);
    bottomSplitter.setPositionRelative(75);
    bottomSplitter.setAutosave(true);

    Splitter masterSplitter = new Splitter("masterSplitter", topSplitter, bottomSplitter);
    masterSplitter.setOrientation(Splitter.Orientation.VERTICAL);
    masterSplitter.setAutosave(true);

    Button clearState = new Button("Clear State");
    clearState.addClickListener(e -> {
      topSplitter.cleanState();
      bottomSplitter.cleanState();
      masterSplitter.cleanState();
      Page.getCurrent().reload();
    });

    Element reload = new Element("dwc-icon-button");
    reload.setAttribute("name", "reload");
    reload.setAttribute("theme", "primary");
    reload.addEventListener("click", e -> Page.getCurrent().reload());

    FlexLayout toolbar = FlexLayout.create(reload, clearState).horizontal().build();
    FlexLayout layout = FlexLayout.create(toolbar, masterSplitter).vertical().build();
    layout.setStyle("padding", "var(--dwc-space-m)");
    layout.setItemAlignment(FlexAlignment.END, toolbar);

    Frame mainFrame = new Frame();
    mainFrame.add(layout);
  }
}
