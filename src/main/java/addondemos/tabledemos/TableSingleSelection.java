package addondemos.tabledemos;

import com.webforj.App;
import com.webforj.component.table.Table;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class TableSingleSelection extends App {

  @Override
  public void run() throws WebforjException {

    Table<MusicRecord> table = new Table<>();
    table.setWidth("100vw");
    table.setHeight("100vw");

    table.addColumn("Number", MusicRecord::getNumber);
    table.addColumn("Title", MusicRecord::getTitle);
    table.addColumn("Artist", MusicRecord::getArtist);
    table.addColumn("Genre", MusicRecord::getMusicType);
    table.addColumn("Cost", MusicRecord::getCost);

    table.setRepository(Service.getMusicRecords());
    table.setSelectionMode(Table.SelectionMode.SINGLE);

    table.onItemSelect((ev) -> {
      msgbox("You have selected " + ev.getItem().getTitle() + " by " + ev.getItem().getArtist(), 0,
          "Record Selection");
    });

    Frame mainFrame = new Frame();
    mainFrame.add(table);
  }
}
