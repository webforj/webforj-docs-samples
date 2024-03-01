package addondemos.tabledemos;

import org.dwcj.App;
import org.dwcj.addons.table.Table;
import org.dwcj.addons.table.renderer.Renderer;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/* css */"""
      .table {
        width: 100vw;
        height: 100vh;
      }

      .table::part(avatar-renderer) {
        display: flex;
        align-items: center;
        gap: 10px;
      }

      .table::part(avatar-img) {
        border-radius: 50%;
      }

      .table::part(avatar-text) {
        display: flex;
        flex-direction: column;
      }

      .table::part(avatar-subtext) {
        font-size: 0.8em;
        color: var(--dwc-color-gray-text-light);
      }

      .table::part(badge-low) {
        color: var(--dwc-color-success-text);
      }

      .table::part(badge-high) {
        color: var(--dwc-color-danger-text);
      }
    """)
public class TableRichContent extends App {

  @Override
  public void run() throws DwcjException {

    Table<MusicRecord> table = new Table<>();
    table.addClassName("table");

    table.addColumn("Title", MusicRecord::getTitle).setHidden(true);
    table.addColumn("Artist", MusicRecord::getArtist).setHidden(true);
    table.addColumn("Title & Artist", new AvatarRenderer());
    table.addColumn("Genre", MusicRecord::getMusicType);
    table.addColumn("Cost", MusicRecord::getCost).setRenderer(new BadgeRenderer());

    table.setRepository(Service.getMusicRecords());
    table.setSelectionMode(Table.SelectionMode.MULTIPLE);
    table.setRowHeight(45);

    Frame mainFrame = new Frame();
    mainFrame.add(table);
  }

  class AvatarRenderer extends Renderer<MusicRecord> {
    @Override
    public String build() {
      return /* html */"""
          <%
          const artist = cell.row.getValue('Artist');
          const title = cell.row.getValue('Title');
          %>
          <div part='avatar-renderer'>
            <img
              part='avatar-img'
              src='https://i.pravatar.cc/32?u=<%= encodeURIComponent(artist) %>' />
            <div part="avatar-text">
              <%= title %>
              <div part="avatar-subtext">
                <%= artist %>
              </div>
            </div>
          </div>
          """;
    }
  }

  class BadgeRenderer extends Renderer<MusicRecord> {
    @Override
    public String build() {
      return /* html */"""
          <span part='badge badge-<%= cell.value > 7 ? "high" : "low" %>'>
            <%= cell.value %>
          </span>
          """;
    }
  }
}
