package com.webforj.samples.views.applayout.applayoutstickytoolbar;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.router.annotation.Route;
import com.webforj.samples.views.applayout.AppLayoutStickyToolbarView;

@Route(value = "/Tasks", outlet = AppLayoutStickyToolbarView.class)
public class TasksView extends Composite<Div>{
    Paragraph contentLabel = new Paragraph("Content for Tasks goes here");
    public TasksView(){
        getBoundComponent().add(contentLabel);
    }
}
