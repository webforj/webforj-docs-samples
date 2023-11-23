package componentdemos.comboboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.component.text.Label;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.exceptions.DwcjException;

import java.util.ArrayList;
import java.util.Random;

@InlineStyleSheet(/* css */ """
  .frame {
    display: flex;
    flex-direction: column;
    gap: 10px;
    margin: 20px;
    padding: 20px;
  }
  .button {
    align-self: center;
    margin-top: 10px;
  }
    """)

public class ChoiceBoxTwo extends App {

  ChoiceBox employees = new ChoiceBox("Select Employee");
  ChoiceBox departmentChoice = new ChoiceBox("Department");
  Button submitButton = new Button("Assign Department");
  Dialog dialog = new Dialog();
  String employeeName;
  String department;

    @Override
    public void run() throws DwcjException {
        Frame window = new Frame();
        window.addClassName("frame");

        populateEmployeeNames();
        departmentChoice.add("HR", "HR");
        departmentChoice.add("IT", "IT");
        departmentChoice.add("Marketing", "Marketing");
        departmentChoice.add("Finance", "Finance");
        departmentChoice.selectIndex(0);
        
        submitButton.addClassName("button");
        submitButton.onClick(this::assignDepartment);
        
        dialog.getHeader().add(new Label("Assignment Confirmation"));
        dialog.getContent().add(new Label("Employee department updated"));
        dialog.getFooter().add(new Button("OK"));

        window.add(employees, departmentChoice, submitButton, dialog);
    }

    private void populateEmployeeNames() {
        String[] firstNames = {"Max", "Sophia", "Lukas", "Emma", "Felix", "Hannah"};
        String[] lastNames = {"Müller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer"};
        ArrayList<ListItem> employeeEntries = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String name = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
            employeeEntries.add(new ListItem(name));
        }
        employees.insert(employeeEntries);
    }

    private void assignDepartment(ButtonClickEvent e) {
      dialog.show();
    }
}
