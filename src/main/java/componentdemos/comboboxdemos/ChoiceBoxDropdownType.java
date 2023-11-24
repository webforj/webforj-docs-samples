package componentdemos.comboboxdemos;

import java.util.ArrayList;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ChoiceBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet(/* css */"""

    :root{
        /*Overriding list item color to make hover more noticeable*/
        --bbj-list-item-color: #393D48; 
    }

    .frame {
        display: flex;
        margin: 20px 0 0 20px;
        width: 200px;
    }

    [data-dropdown-for="demo-dropdown-type"]::part(list){
        transition: transform 0.3s ease; /* Smooth transition for the transform effect */
        overflow: hidden;
      }

    [data-dropdown-for="demo-dropdown-type"]::part(item) {
    transition: transform 0.3s ease, background-color 0.3s ease;
}

[data-dropdown-for="demo-dropdown-type"]::part(item):hover{
    transition: transform 0.3s ease; /* Smooth transition for the transform effect */
    transform: scale(1.2) translateX(10px); /* Scale up the list item on hover */
    cursor: pointer; /* Change cursor to indicate interactivity */
    }
      """)
public class ChoiceBoxDropdownType extends App {

    @Override
    public void run() throws DwcjException {
        Frame window = new Frame();
        window.addClassName("frame");

        ChoiceBox demoBox = new ChoiceBox();
        window.add(demoBox);
        
        ArrayList<ListItem> categories = new ArrayList<>();
        categories.add(new ListItem("Electronics","Electronics"));
        categories.add(new ListItem("Health and Beauty","Health and Beauty"));
        categories.add(new ListItem("Fashion","Fashion"));
        categories.add(new ListItem("Kitchen","Kitchen"));
        categories.add(new ListItem("Furniture","Furniture"));
        categories.add(new ListItem("Pet Supplies","Pet Supplies"));
        categories.add(new ListItem("Toys and Games","Toys and Games"));
        
        demoBox.setDropdownType("demo-dropdown-type");
        demoBox.insert(categories)
            .selectIndex(0);
    }
}
