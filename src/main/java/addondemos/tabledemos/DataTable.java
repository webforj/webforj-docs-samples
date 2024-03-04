package addondemos.tabledemos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.Arrays;
import java.util.List;
import org.dwcj.App;
import org.dwcj.addons.table.Column;
import org.dwcj.addons.table.Table;
import org.dwcj.component.field.TextField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.navigator.Navigator;
import org.dwcj.component.window.Frame;
import org.dwcj.data.Paginator;
import org.dwcj.data.repository.CollectionRepository;
import org.dwcj.data.repository.Repository;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.utilities.Assets;

public class DataTable extends App {
  private String searchTerm = "";
  private Repository<JsonObject> repository;
  private Paginator paginator;

  @Override
  public void run() throws DwcjException {
    List<JsonObject> data = new Gson().fromJson(
        Assets.contentOf(Assets.resolveContextUrl("context://data/olympic-winners.json")),
        new TypeToken<List<JsonObject>>() {});

    repository = new CollectionRepository<>(data);
    repository.setFilter((JsonObject json) -> {
      String athlete = json.get("athlete").getAsString();
      return athlete.toLowerCase().contains(this.searchTerm);
    });

    paginator = new Paginator(repository);
    paginator.setMax(5);

    FlexLayout layout = FlexLayout.create(buildTableHeader(), buildTable(), buildTableFooter())
        .vertical().contentAlign().center().build().setStyle("padding", "var(--dwc-space-l)");

    Frame mainFrame = new Frame();
    mainFrame.add(layout);
  }

  FlexLayout buildTableHeader() {
    TextField search = new TextField(TextField.Type.SEARCH, "Search");
    search.setPlaceholder("Search by athlete ...");
    search.onModify(ev -> {
      this.searchTerm = ev.getText().toLowerCase();
      paginator.setCurrent(1);
      repository.commit();
    });

    ChoiceBox pages = new ChoiceBox("Entries per page");
    pages.insert("10", "25", "50", "100");
    pages.selectIndex(0);
    pages.onSelect(e -> {
      paginator.setSize(Integer.parseInt(e.getSelectedItem().getText()));
    });

    return FlexLayout.create(pages, search).horizontal().justify().between().build();
  }

  Table<JsonObject> buildTable() {
    Table<JsonObject> table = new Table<>();
    table.setStyle("height", "400px");

    List<String> columnsList = Arrays.asList("athlete", "age", "country", "year", "total");

    for (String column : columnsList) {
      table.addColumn(column, (JsonObject person) -> {
        JsonElement element = person.get(column);
        if (!element.isJsonNull()) {
          return element.getAsString();
        }

        return "";
      });
    }

    table.getColumns().forEach(column -> column.setSortable(true));
    table.getColumnById("athlete").setPinDirection(Column.PinDirection.LEFT).setMinWidth(200f);
    table.getColumnById("total").setPinDirection(Column.PinDirection.RIGHT);

    table.setRepository(repository);

    return table;
  }

  FlexLayout buildTableFooter() {
    Navigator pages = new Navigator(paginator, Navigator.Layout.PAGES);
    pages.setAutoDisable(true);

    Navigator preview = new Navigator(paginator, Navigator.Layout.PREVIEW);
    preview.setHideMainButtons(true);
    preview.setStyle("border", "0");
    preview.setText("`Showing ${startIndex + 1} to ${endIndex + 1} of ${totalItems} entries`");

    return FlexLayout.create(pages, preview).horizontal().justify().between().build();
  }
}
