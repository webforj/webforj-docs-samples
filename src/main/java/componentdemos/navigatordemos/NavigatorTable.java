package componentdemos.navigatordemos;


import org.dwcj.App;
import org.dwcj.addons.table.Table;
import org.dwcj.component.layout.flexlayout.FlexAlignment;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.navigator.Navigator;
import org.dwcj.component.window.Frame;
import org.dwcj.data.repository.Repository;
import org.dwcj.exceptions.DwcjException;

import addondemos.tabledemos.MusicRecord;
import addondemos.tabledemos.Service;

public class NavigatorTable extends App {

  @Override
  public void run() throws DwcjException {
    Repository<MusicRecord> repo = Service.getMusicRecords();

    Navigator nav = new Navigator(repo, Navigator.Layout.PAGES);
    nav.setAutoDisable(true);
    nav.getPaginator().setMax(5);

    Table<MusicRecord> table = new Table<>();
    table.setStyle("height", "400px");

    table.addColumn("Number", MusicRecord::getNumber);
    table.addColumn("Title", MusicRecord::getTitle);
    table.addColumn("Artist", MusicRecord::getArtist);
    table.addColumn("Genre", MusicRecord::getMusicType);
    table.addColumn("Cost", MusicRecord::getCost);
    table.setRepository(repo);

    FlexLayout layout = FlexLayout.create(table, nav).vertical().build();
    layout.setItemAlignment(FlexAlignment.END, nav);

    Frame mainFrame = new Frame();
    mainFrame.add(layout);
  }
}
