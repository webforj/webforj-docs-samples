package com.webforj.samples.views.applayout.applayoutstickytoolbar;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.router.annotation.Route;
import com.webforj.samples.views.applayout.AppLayoutStickyToolbarView;

@Route(value = "/Orders", outlet = AppLayoutStickyToolbarView.class)
public class OrdersView extends Composite<Div>{
    Paragraph contentLabel = new Paragraph("Content for Orders goes here");
    public OrdersView(){
        getBoundComponent().add(contentLabel);
    }
}
