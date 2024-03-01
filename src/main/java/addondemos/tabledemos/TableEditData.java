package addondemos.tabledemos;

import org.dwcj.App;
import org.dwcj.addons.table.Column;
import org.dwcj.addons.table.Table;
import org.dwcj.addons.table.renderer.VoidElementRenderer;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

public class TableEditData extends App {
  TitleEditorComponent editor = new TitleEditorComponent();
  Table<MusicRecord> table = new Table<>();

  @Override
  public void run() throws DwcjException {

    table.setStyle("width", "100vw");
    table.setStyle("height", "100vh");
    table.addColumn("Number", MusicRecord::getNumber).setPinDirection(Column.PinDirection.LEFT);
    table.addColumn("Title", MusicRecord::getTitle);
    table.addColumn("Artist", MusicRecord::getArtist);
    table.addColumn("Genre", MusicRecord::getMusicType);

    VoidElementRenderer<MusicRecord> editRenderer =
        new VoidElementRenderer<>("dwc-icon-button", ev -> {
          editor.edit(ev.getItem());
        });
    editRenderer.setAttribute("name", "pencil-pin");

    table.addColumn(editRenderer).setAlignment(Column.Alignment.CENTER)
        .setPinDirection(Column.PinDirection.RIGHT);

    table.setRepository(Service.getMusicRecords());
    table.setRowHeight(42);

    editor.onSave(ev -> {
      table.getRepository().commit(ev.getItem());
    });

    Frame mainFrame = new Frame();
    mainFrame.add(table, editor);
  }
}
