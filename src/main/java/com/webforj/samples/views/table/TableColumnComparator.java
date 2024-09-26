package com.webforj.samples.views.table;

import com.webforj.App;
import com.webforj.component.table.Table;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class TableColumnComparator extends App {

  @Override
  public void run() throws WebforjException {

    Table<MusicRecord> table = new Table<>();
    table.setWidth("100vw");
    table.setHeight("100vw");

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
