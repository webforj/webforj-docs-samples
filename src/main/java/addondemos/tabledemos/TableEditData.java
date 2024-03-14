package addondemos.tabledemos;

import com.webforj.App;
import com.webforj.component.table.Column;
import com.webforj.component.table.Table;
import com.webforj.component.table.renderer.VoidElementRenderer;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class TableEditData extends App {
  TitleEditorComponent editor = new TitleEditorComponent();
  Table<MusicRecord> table = new Table<>();

  @Override
  public void run() throws WebforjException {

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
