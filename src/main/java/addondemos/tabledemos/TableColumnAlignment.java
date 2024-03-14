package addondemos.tabledemos;

import com.webforj.App;
import com.webforj.component.table.Table;
import com.webforj.component.table.Column;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class TableColumnAlignment extends App {

  @Override
  public void run() throws WebforjException {

    Table<MusicRecord> table = new Table<>();
    table.setStyle("width", "100vw");
    table.setStyle("height", "100vh");

    table.addColumn("Number", MusicRecord::getNumber);
    table.addColumn("Title", MusicRecord::getTitle);
    table.addColumn("Genre", MusicRecord::getMusicType);
    table.addColumn("Cost", record -> {
      return String.format("$%.2f", record.getCost());
    }).setAlignment(Column.Alignment.RIGHT);

    table.setRepository(Service.getMusicRecords());

    Frame mainFrame = new Frame();
    mainFrame.add(table);
  }
}
