package addondemos.tabledemos;

import org.dwcj.App;
import org.dwcj.addons.table.Column;
import org.dwcj.addons.table.Table;
import org.dwcj.addons.table.renderer.ButtonRenderer;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class TableColumnPinning extends App {

  @Override
  public void run() throws DwcjException {

    Table<MusicRecord> table = new Table<>();
    table.setStyle("width", "100vw");
    table.setStyle("height", "100vh");

    table.addColumn("Number", MusicRecord::getNumber).setPinDirection(Column.PinDirection.LEFT);
    table.addColumn("Title", MusicRecord::getTitle);
    table.addColumn("Artist", MusicRecord::getArtist);
    table.addColumn("Tracks Number", MusicRecord::getNumberOfTracks);
    table.addColumn("Genre", MusicRecord::getMusicType);
    table.addColumn("Cost", record -> {
      return String.format("$%.2f", record.getCost());
    }).setAlignment(Column.Alignment.RIGHT);

    ButtonRenderer<MusicRecord> editRenderer = new ButtonRenderer<>("Edit", e -> {
      msgbox("You asked to edit the record", 0, "Edit Record");
    });
    table.addColumn(editRenderer).setAlignment(Column.Alignment.CENTER)
        .setPinDirection(Column.PinDirection.RIGHT);

    table.setRepository(Service.getMusicRecords());
    table.setRowHeight(42);

    Frame mainFrame = new Frame();
    mainFrame.add(table);
  }
}
