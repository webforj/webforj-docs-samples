package addondemos.tabledemos;

import com.webforj.App;
import com.webforj.component.table.Table;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class TableColumnComparator extends App {

  @Override
  public void run() throws WebforjException {

    Table<MusicRecord> table = new Table<>();
    table.setStyle("width", "100vw");
    table.setStyle("height", "100vh");

    table.addColumn("Number", MusicRecord::getNumber).setComparator((a, b) -> {
      return Integer.parseInt(a.getNumber()) - Integer.parseInt(b.getNumber());
    });
    table.addColumn("Title", MusicRecord::getTitle);
    table.addColumn("Artist", MusicRecord::getArtist);
    table.addColumn("Genre", MusicRecord::getMusicType);
    table.addColumn("Cost", MusicRecord::getCost);

    table.getColumns().forEach(column -> column.setSortable(true));
    table.setRepository(Service.getMusicRecords());

    Frame mainFrame = new Frame();
    mainFrame.add(table);
  }
}
