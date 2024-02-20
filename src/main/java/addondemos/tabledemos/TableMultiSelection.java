package addondemos.tabledemos;

import java.util.List;
import java.util.stream.Collectors;
import org.dwcj.App;
import org.dwcj.addons.table.Table;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class TableMultiSelection extends App {

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
    table.setSelectionMode(Table.SelectionMode.MULTIPLE);

    table.onItemSelectionChange(ev -> {
      List<MusicRecord> records = ev.getSelectedItems();
      String msg = "There are no records selected";

      if (records.size() > 0) {
        msg = "<html> You have selected the following records"
            + records.stream().map(MusicRecord::getTitle).map(title -> "<li>" + title + "</li>")
                .collect(Collectors.joining("", "<ul>", "</ul>"))
            + "</html>";
      }

      msgbox(msg, 0, "Record Selection");
    });

    Frame mainFrame = new Frame();
    mainFrame.add(table);
  }
}
