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
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.utilities.Assets;

public class TableOlympicWinners extends App {

  @Override
  public void run() throws DwcjException {

    Table<JsonObject> table = new Table<>();
    table.setStyle("width", "100vw");
    table.setStyle("height", "100vh");

    List<String> columnsList = Arrays.asList("athlete", "age", "country", "year", "sport", "gold",
        "silver", "bronze", "total");

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
    table.setClientSorting(true);

    List<JsonObject> data = new Gson().fromJson(
        Assets.contentOf(Assets.resolveContextUrl("context://data/olympic-winners.json")),
        new TypeToken<List<JsonObject>>() {});

    table.setItems(data);

    Frame mainFrame = new Frame();
    mainFrame.add(table);
  }
}
