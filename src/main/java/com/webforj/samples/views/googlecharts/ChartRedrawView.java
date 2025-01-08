package com.webforj.samples.views.googlecharts;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.NumberField;
import com.webforj.component.googlecharts.GoogleChart;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@InlineStyleSheet("context://css/googlecharts/chartRedraw.css")
@Route
@FrameTitle("Chart Redraw")
public class ChartRedrawView extends Composite<Div> {

    private static final String COLOR = "color";
    private static final String TEXT_STYLE = "textStyle";
    private static final String TITLE = "title";

    private GoogleChart chart = new GoogleChart(GoogleChart.Type.COLUMN);
    private Button redrawButton = new Button("Redraw Chart");
    private FlexLayout inputGroup = new FlexLayout();

    public ChartRedrawView() {
        getBoundComponent().addClassName("window");

        Div chartContainer = new Div();
        chartContainer.addClassName("chart-container");
        chartContainer.add(chart);

        Map<String, Object> options = new HashMap<>();
        options.put(TITLE, "Social Media Following");
        options.put("colors", List.of("#006fe6"));
        options.put("backgroundColor", "transparent");
        options.put("chartArea", Map.of("width", "80%", "height", "70%"));
        options.put("hAxis", Map.of(TEXT_STYLE, Map.of(COLOR, "#333")));
        options.put("vAxis", Map.of("minValue", 0, TEXT_STYLE, Map.of(COLOR, "#333")));
        options.put("legend", Map.of("position", "bottom"));
        chart.setOptions(options);

        List<Object> data = new ArrayList<>();
        data.add(Arrays.asList(new Object[] { "Category", "Number of Followers in Thousands" }));

        inputGroup.addClassName("input-group");

        String[] categories = { "Instagram", "Twitter", "Facebook", "LinkedIn" };
        Map<String, NumberField> valueFields = new HashMap<>();

        for (String category : categories) {
            data.add(Arrays.asList(new Object[] { category, 100 }));
            NumberField valueField = new NumberField("Value for " + category);
            valueField.setPlaceholder("");
            valueField.setStep(1.0);
            valueField.addClassName("number-field");
            valueField.setText("100");
            inputGroup.add(valueField);
            valueFields.put(category, valueField);
        }
        chart.setData(data);

        redrawButton.addClassName("redraw-button");
        redrawButton.addClickListener(e -> {
            List<Object> newData = new ArrayList<>();
            newData.add(Arrays.asList(new Object[] { "Category", "Followers" }));
            boolean allValuesValid = true;

            for (String category : categories) {
                NumberField valueField = valueFields.get(category);
                String fieldValue = valueField.getText();
                Double value = null;

                if (!fieldValue.isEmpty()) {
                    try {
                        value = Double.parseDouble(fieldValue);
                    } catch (NumberFormatException ex) {
                        allValuesValid = false;
                        break;
                    }
                }

                newData.add(Arrays.asList(new Object[] { category, value != null ? value.intValue() : null }));
            }

            if (allValuesValid) {
                chart.setData(newData);
                chart.redraw();
            }
        });

        inputGroup.add(redrawButton.setTheme(ButtonTheme.PRIMARY));
        getBoundComponent().add(chartContainer);
        getBoundComponent().add(inputGroup);
    }
}