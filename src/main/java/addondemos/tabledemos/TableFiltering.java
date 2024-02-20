package addondemos.tabledemos;

import org.dwcj.App;
import org.dwcj.addons.table.Table;
import org.dwcj.component.field.TextField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.data.repository.Repository;
import org.dwcj.exceptions.DwcjException;

public class TableFiltering extends App {
  private String searchTerm = "";

  @Override
  public void run() throws DwcjException {
    Repository<MusicRecord> repository = Service.getMusicRecords();
    repository.setFilter((MusicRecord r) -> {
      String title = r.getTitle();
      return title.toLowerCase().contains(this.searchTerm);
    });

    TextField searchField = buildSearchField(repository);
    Table<MusicRecord> table = buildTable(repository);

    FlexLayout layout =
        FlexLayout.create().vertical().contentAlign().center().build().setStyle("height", "500px");
    layout.add(searchField, table);

    Frame mainFrame = new Frame();
    mainFrame.setStyle("padding", "30px").add(layout);
  }

  TextField buildSearchField(Repository<MusicRecord> repository) {
    TextField search = new TextField(TextField.Type.SEARCH, "Search");
    search.setPlaceholder("Search by title ...");
    search.onModify(ev -> {
      this.searchTerm = ev.getText().toLowerCase();
      repository.commit();
    });

    return search;
  }

  Table<MusicRecord> buildTable(Repository<MusicRecord> repository) {
    Table<MusicRecord> table = new Table<>();

    table.addColumn("Title", MusicRecord::getTitle);
    table.addColumn("Artist", MusicRecord::getArtist);
    table.addColumn("Genre", MusicRecord::getMusicType);
    table.addColumn("Cost", MusicRecord::getCost);

    table.setRepository(repository);

    return table;
  }
}
