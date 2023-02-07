package control_demos.comboboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.AppPanel;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.controls.combobox.ComboBox;
import org.dwcj.exceptions.DwcAppInitializeException;


public class ComboboxThemeDemo extends App {
    
    private TextBox edFirstname;
    private TextBox edLastname;

    @Override
    public void run() throws DwcAppInitializeException {


        AppPanel panel = new AppPanel();
        panel.setStyle("display", "inline-grid");
        panel.setStyle("grid-template-columns", "1fr");
        panel.setStyle("padding", "10px");
        panel.setStyle("gap", "50px");


        Div comboboxThemes = new Div();
        comboboxThemes.setId("comboboxThemes");
        panel.add(comboboxThemes);
        comboboxThemes.setStyle("display", "inline-grid");
        comboboxThemes.setStyle("grid-template-columns", "150px 150px 150px 150px 150px 150px 150px");
        comboboxThemes.setStyle("gap", "20px");
        comboboxThemes.setStyle("padding", "10px");
        comboboxThemes.setStyle("overflow", "auto");

        Map<Object, String> data = new HashMap<>();
        data.put("Random Data1", "Random Data");
        data.put("Random Data2", "Some Data");
        data.put("Random Data3", "More Data");
        data.put("Random Data4", "Test Data");


        ComboBox b1 = new ComboBox();
        b1.setStyle("grid-column", "1").setStyle("width", "100%").setItems(data);
        ComboBox b2 = new ComboBox();
        b2.setAttribute("theme", "danger").setStyle("grid-column", "2").setStyle("width", "100%").setItems(data);
        ComboBox b3 = new ComboBox();
        b3.setAttribute("theme", "gray").setStyle("grid-column", "3").setStyle("width", "100%").setItems(data);
        ComboBox b4 = new ComboBox();
        b4.setAttribute("theme", "info").setStyle("grid-column", "4").setStyle("width", "100%").setItems(data);
        ComboBox b5 = new ComboBox();
        b5.setAttribute("theme", "primary").setStyle("grid-column", "5").setStyle("width", "100%").setItems(data);
        ComboBox b6 = new ComboBox();
        b6.setAttribute("theme", "success").setStyle("grid-column", "6").setStyle("width", "100%").setItems(data);
        ComboBox b7 = new ComboBox();
        b7.setAttribute("theme", "warning").setStyle("grid-column", "7").setStyle("width", "100%").setItems(data);
        ComboBox b8 = new ComboBox();
        b8.setAttribute("theme", "outlined-default").setStyle("grid-column", "1").setStyle("width", "100%").setItems(data);
        ComboBox b9 = new ComboBox();
        b9.setAttribute("theme", "outlined-danger").setStyle("grid-column", "2").setStyle("width", "100%").setItems(data);
        ComboBox b10 = new ComboBox();
        b10.setAttribute("theme", "outlined-gray").setStyle("grid-column", "3").setStyle("width", "100%").setItems(data);
        ComboBox b11 = new ComboBox();
        b11.setAttribute("theme", "outlined-info").setStyle("grid-column", "4").setStyle("width", "100%").setItems(data);
        ComboBox b12 = new ComboBox();
        b12.setAttribute("theme", "outlined-primary").setStyle("grid-column", "5").setStyle("width", "100%").setItems(data);
        ComboBox b13 = new ComboBox();
        b13.setAttribute("theme", "outlined-success").setStyle("grid-column", "6").setStyle("width", "100%").setItems(data);
        ComboBox b14 = new ComboBox();
        b14.setAttribute("theme", "outlined-warning").setStyle("grid-column", "7").setStyle("width", "100%").setItems(data);
        
        
        comboboxThemes.add(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14);
        b1.selectIndex(0);
        b2.selectIndex(0);
        b3.selectIndex(0);
        b4.selectIndex(0);
        b5.selectIndex(0);
        b6.selectIndex(0);
        b7.selectIndex(0);
        b8.selectIndex(0);
        b9.selectIndex(0);
        b10.selectIndex(0);
        b11.selectIndex(0);
        b12.selectIndex(0);
        b13.selectIndex(0);
        b14.selectIndex(0);
        

    }
        

}
