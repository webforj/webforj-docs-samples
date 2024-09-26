package com.webforj.samples.views.table;

import java.util.List;
import java.util.stream.Collectors;
import com.webforj.App;
import com.webforj.component.table.Table;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class TableMultiSelection extends App {

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
