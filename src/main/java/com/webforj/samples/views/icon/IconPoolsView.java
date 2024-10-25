package com.webforj.samples.views.icon;

import com.webforj.component.Composite;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.icons.FontAwesomeIcon;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Icon Pools")
public class IconPoolsView extends Composite<FlexLayout> {

    public IconPoolsView() {
        getBoundComponent().setDirection(FlexDirection.ROW).setMargin("var(--dwc-space-l)")
                           .setSpacing("var(--dwc-space-m)");

        Icon arrows = TablerIcon.create("arrows-diagonal");
        
        Icon camera = FeatherIcon.CAMERA.create();
        
        Icon eye = FontAwesomeIcon.create("eye");


        getBoundComponent().add(arrows, camera, eye);
    }
}