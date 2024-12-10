package com.webforj.samples.views.applayout.applayoutstickytoolbar;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.router.annotation.Route;
import com.webforj.samples.views.applayout.AppLayoutStickyToolbarView;

@Route(value = "/Customers", outlet = AppLayoutStickyToolbarView.class)
public class CustomersView extends Composite<Div>{
    Paragraph contentLabel = new Paragraph("Content for Customers goes here");
    public CustomersView(){
        getBoundComponent().add(contentLabel);
    }
}
