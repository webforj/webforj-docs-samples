package addondemos.tabledemos;

import java.util.EventObject;
import org.dwcj.component.Composite;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.event.KeypressEvent;
import org.dwcj.component.field.TextField;
import org.dwcj.component.html.elements.H3;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.dispatcher.EventDispatcher;
import org.dwcj.dispatcher.EventListener;
import org.dwcj.dispatcher.ListenerRegistration;

/**
 * A component that allows the user to edit a MusicRecord title.
 */
public class TitleEditorComponent extends Composite<Dialog> {
  private EventDispatcher dispatcher = new EventDispatcher();
  private TextField titleField = new TextField("New Title");
  private FlexLayout footer = FlexLayout.create().align().end().build();
  private MusicRecord item;

  /**
   * Creates a new TitleEditorComponent.
   */
  public TitleEditorComponent() {
    Dialog dialog = getBoundComponent();
    dialog.setMaxWidth("400px");
    dialog.onOpen(ev -> titleField.focus());

    Button saveButton = new Button("Save", ev -> save());
    saveButton.setTheme(ButtonTheme.PRIMARY);

    Button cancelButton = new Button("Cancel", ev -> dialog.close());
    footer.add(saveButton, cancelButton);

    dialog.addToHeader(new H3("Edit Title"));
    dialog.add(titleField);
    dialog.addToFooter(footer);

    titleField.onKeypress(ev -> {
      if (ev.getKeyCode() == KeypressEvent.Key.ENTER) {
        save();
      }
    });
  }

  /**
   * Edit the title of the given MusicRecord.
   *
   * @param item the MusicRecord to edit
   */
  public void edit(MusicRecord item) {
    this.item = item;
    titleField.setText(item.getTitle());
    getBoundComponent().open();
  }

  /**
   * Adds a listener to the save event.
   *
   * @param listener the listener to add
   * @return a registration that can be used to remove the listener
   */
  public ListenerRegistration<SaveEvent> onSave(EventListener<SaveEvent> listener) {
    return dispatcher.addListener(SaveEvent.class, listener);
  }

  private void save() {
    item.setTitle(titleField.getText());
    getBoundComponent().close();
    dispatcher.dispatchEvent(new SaveEvent(this));
  }

  /**
   * An event that is dispatched when the user saves the title.
   */
  public class SaveEvent extends EventObject {

    public SaveEvent(Object source) {
      super(source);
    }

    public MusicRecord getItem() {
      return ((TitleEditorComponent) getSource()).item;
    }
  }
}
