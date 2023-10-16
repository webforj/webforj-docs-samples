package layout_demos.item;

import java.util.ArrayList;
import java.util.HashMap;

import org.dwcj.App;
import org.dwcj.addons.code.Code;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.choicebox.event.ChoiceBoxSelectEvent;
import org.dwcj.component.spinnernumberfield.SpinnerNumberField;
import org.dwcj.component.layout.flexlayout.FlexAlignment;
import org.dwcj.component.layout.flexlayout.FlexContentAlignment;
import org.dwcj.component.layout.flexlayout.FlexDirection;
import org.dwcj.component.layout.flexlayout.FlexJustifyContent;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.layout.flexlayout.FlexWrap;
import org.dwcj.component.maskednumberfield.event.MaskedNumberFieldModifyEvent;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class ItemDemo extends App{

  SpinnerNumberField spinner;
  
  FlexLayout boxLayout;
  ArrayList<Box> boxes;
  float numBoxes;

  String javaCode;
  Code codeWindow;
  HashMap<String, String> codeSnippetBuilder;

  @Override
  public void run() throws DwcjException{
    
    Frame page = new Frame().addClassName("app__frame");

    FlexLayout mainLayout = FlexLayout.create()
    .horizontal()
    .build();
    
    boxLayout = FlexLayout.create()
    .horizontal()
    .build()
    .addClassName("button__container");
    
    
    FlexLayout flexContainerOptions = FlexLayout.create()
    .vertical()
    .build()
    .addClassName("flex__options");
    
    
    spinner = new SpinnerNumberField();
    spinner.setAttribute("label", "Number of Boxes");
    spinner.onEditModify(this::spinnerChange);
    spinner.setText("5");
    
    boxes = new ArrayList<>();
    numBoxes = 0;
    for(int i = 1; i <= 5; i++){
      addBox(i);
    }
    
    flexContainerOptions.add(spinner);
    
    mainLayout.add(flexContainerOptions, boxLayout);
    page.add(mainLayout);

    ChoiceBox order = new ChoiceBox().onSelect(this::selectDirection);
    order.setAttribute("label", "Order");
    for(FlexDirection justify : FlexDirection.values()){
      String label = justify.getValue();
      order.addItem(
        "." + justify.toString()
          .toLowerCase() + "()", 
        label.substring(0, 1)
          .toUpperCase() + label
          .substring(1)
          );
      }
    order.selectIndex(0);

    ChoiceBox alignment = new ChoiceBox().onSelect(this::selectJustification);
    alignment.setAttribute("label", "Align Self");
    for(FlexAlignment justify : FlexAlignment.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      alignment.addItem(".justify()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    alignment.selectIndex(0);

    ChoiceBox basis = new ChoiceBox().onSelect(this::selectAlignment);
    basis.setAttribute("label", "Flex Basis");
    for(FlexAlignment justify : FlexAlignment.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      basis.addItem(".align()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    basis.selectIndex(0);

    ChoiceBox grow = new ChoiceBox().onSelect(this::selectAlignContent);
    grow.setAttribute("label", "Flex Grow");
    for(FlexContentAlignment justify : FlexContentAlignment.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      grow.addItem(".contentAlign()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    grow.selectIndex(0);

    ChoiceBox shrink = new ChoiceBox().onSelect(this::selectWrap);
    shrink.setAttribute("label", "Flex Shrink");
    for(FlexWrap justify : FlexWrap.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      shrink.addItem(".wrap()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    shrink.selectIndex(0);
 
    flexContainerOptions.add(order, alignment, basis, grow, shrink);
    
    codeWindow = new Code();
    page.add(codeWindow);
    codeWindow.setLanguage("java")
      .addClassName("code__block");

    createStrings();
    updateCode();
  }
  
  private void createStrings(){
    codeSnippetBuilder = new HashMap<>();
    codeSnippetBuilder.put("FlexDirection", ".horizontal() \n");
    codeSnippetBuilder.put("FlexJustifyContent", "");
    codeSnippetBuilder.put("FlexAlignment", "");
    codeSnippetBuilder.put("FlexContentAlignment", "");
    codeSnippetBuilder.put("FlexWrap", "");
  }
  
  private void updateCode(){
    javaCode = "FlexLayout boxLayout = FlexLayout.create() \n"+
    codeSnippetBuilder.get("FlexDirection") +
    codeSnippetBuilder.get("FlexJustifyContent") +
    codeSnippetBuilder.get("FlexAlignment") +
    codeSnippetBuilder.get("FlexContentAlignment") +
    codeSnippetBuilder.get("FlexWrap");
    codeWindow.setText(javaCode);
  }

  private void spinnerChange(MaskedNumberFieldModifyEvent ev){
    if(ev.getControl().getText().isEmpty() || Integer.valueOf(ev.getControl().getText()) < 1){
      ev.getControl().setText("1");
    }
    if(Integer.valueOf(ev.getControl().getText()) > numBoxes){
      addBox(Integer.valueOf(ev.getControl().getText()));
    }
    else if(Integer.valueOf(ev.getControl().getText()) < numBoxes){
      removeBox(Integer.valueOf(ev.getControl().getText()));
    }
  }

  private void addBox(int newNum){
    while(newNum > numBoxes){
      numBoxes++;
      String hue = String.valueOf((360/10) * (int)numBoxes);
      Box newBox = new Box((int) numBoxes);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxes.add(newBox);
      boxLayout.add(newBox);
    }
  }

  private void removeBox(int newNum){
    while(newNum < numBoxes){
      boxes.get((int)numBoxes-1).boxDestroy();
      boxes.remove((int)numBoxes-1);
      numBoxes--;
    }
  }

  private void selectDirection(ChoiceBoxSelectEvent ev){
    boxLayout.setDirection(FlexDirection.fromValue(ev.getControl().getSelectedItem().getValue()));
    switch(ev.getControl().getSelectedItem().getKey().toString()){
      case ".row-reverse()": codeSnippetBuilder.put("FlexDirection", ".horizontalReverse()\n");
      break;
      case ".column()": codeSnippetBuilder.put("FlexDirection", ".vertical()\n");
      break;
      case ".column-reverse()": codeSnippetBuilder.put("FlexDirection", ".verticalReverse()\n");
      break;
      default: codeSnippetBuilder.put("FlexDirection", ".horizontal()\n");
                  break;
    }
    updateCode();
  }
  
  private void selectJustification(ChoiceBoxSelectEvent ev){
    boxLayout.setJustifyContent(FlexJustifyContent.fromValue(ev.getControl().getSelectedItem().getValue()));
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".justify().start()")){
      codeSnippetBuilder.put("FlexJustifyContent", "");
    }
    else{
      codeSnippetBuilder.put("FlexJustifyContent", ev.getControl().getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }

  private void selectAlignment(ChoiceBoxSelectEvent ev){
    boxLayout.setAlignment(FlexAlignment.fromValue(ev.getControl().getSelectedItem().getValue()));
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".align().stretch()")){
      codeSnippetBuilder.put("FlexAlignment", "");
    }
    else{
      codeSnippetBuilder.put("FlexAlignment", ev.getControl().getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }

  private void selectAlignContent(ChoiceBoxSelectEvent ev){
    boxLayout.setAlignContent(FlexContentAlignment.fromValue(ev.getControl().getSelectedItem().getValue()));
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".contentAlign().normal()")){
      codeSnippetBuilder.put("FlexContentAlignment", "");
    }
    else{
      codeSnippetBuilder.put("FlexContentAlignment", ev.getControl().getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }

  private void selectWrap(ChoiceBoxSelectEvent ev){
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".wrap().nowrap()")){
      boxLayout.setWrap(FlexWrap.fromValue(ev.getControl().getSelectedItem().getValue()));
      codeSnippetBuilder.put("FlexWrap", "");
    }
    else if(ev.getControl().getSelectedItem().getKey().toString().equals(".wrap().reverse()")){
      boxLayout.setWrap(FlexWrap.WRAP_REVERSE);
      codeSnippetBuilder.put("FlexWrap", ev.getControl().getSelectedItem().getKey().toString() + "\n");
    }
    else{
      boxLayout.setWrap(FlexWrap.fromValue(ev.getControl().getSelectedItem().getValue()));
      codeSnippetBuilder.put("FlexWrap", ev.getControl().getSelectedItem().getKey().toString() + "\n");
    }
    updateCode();
  }
}
