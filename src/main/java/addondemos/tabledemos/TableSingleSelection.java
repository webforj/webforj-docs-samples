package addondemos.tabledemos;

import org.dwcj.App;
import org.dwcj.addons.table.Table;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class TableSingleSelection extends App {

  @Override
  public void run() throws DwcjException {

    Table<MusicRecord> table = new Table<>();
    table.setStyle("width", "100vw");
    table.setStyle("height", "100vh");

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
