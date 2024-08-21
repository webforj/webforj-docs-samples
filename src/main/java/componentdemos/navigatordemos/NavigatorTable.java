package componentdemos.navigatordemos;


import com.webforj.App;
import com.webforj.component.table.Table;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.navigator.Navigator;
import com.webforj.component.window.Frame;
import com.webforj.data.repository.Repository;
import com.webforj.exceptions.WebforjException;

import addondemos.tabledemos.MusicRecord;
import addondemos.tabledemos.Service;

public class NavigatorTable extends App {

  @Override
  public void run() throws WebforjException {
    Repository<MusicRecord> repo = Service.getMusicRecords();

    Navigator nav = new Navigator(repo, Navigator.Layout.PAGES);
    nav.setAutoDisable(true);
    nav.getPaginator().setMax(5);
    nav.setStyle("margin-right", "20px");

    Table<MusicRecord> table = new Table<>();
    table.setHeight("400px");

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
