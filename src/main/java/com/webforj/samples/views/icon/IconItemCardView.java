package com.webforj.samples.views.icon;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.icons.FontAwesomeIcon;
import com.webforj.component.icons.Icon;
import com.webforj.component.icons.IconButton;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Icon Item Cards")
@InlineStyleSheet("context://css/icon/iconItemCard.css")
public class IconItemCardView extends Composite<FlexLayout> {

    public IconItemCardView() {
        getBoundComponent().setDirection(FlexDirection.COLUMN).setJustifyContent(FlexJustifyContent.CENTER)
        .setMargin("var(--dwc-space-l)").setAlignment(FlexAlignment.CENTER);

        TextField searchField = new TextField();
        searchField.setStyle("width", "600px");
        searchField.setPlaceholder("Search...");
        
        IconButton searchIcon = new IconButton(FontAwesomeIcon.create("magnifying-glass", FontAwesomeIcon.Variate.SOLID));
        searchField.setSuffixComponent(searchIcon);
        
        Div itemCard1 = createProductCard("Interactive Workshops", TablerIcon.create("presentation"));
        Div itemCard2 = createProductCard("Video Lessons", TablerIcon.create("video"));
        Div itemCard3 = createProductCard("User Guide", TablerIcon.create("file-text"));
        
        Div itemCards = new Div(itemCard1, itemCard2, itemCard3).setStyle("display", "flex");
        itemCards.setStyle("flex-direction", "row");
        itemCards.setStyle("gap", "var(--dwc-space-l)");

        getBoundComponent().add(searchField, itemCards);
    }

    private Div createProductCard(String title, Icon productIcon) {
        Div itemCard = new Div();
        itemCard.addClassName("item-card");

        Paragraph productTitle = new Paragraph(title);
        productTitle.addClassName("product-title");

        productIcon.addClassName("product-icon");

        IconButton likeIcon = new IconButton(TablerIcon.create("heart"));
        likeIcon.addClassName("like-icon");

        Div likecartDiv = new Div();

        Button addToCartButton = new Button(FeatherIcon.SHOPPING_CART.create());
        addToCartButton.setTheme(ButtonTheme.PRIMARY);

        likecartDiv.add(likeIcon, addToCartButton);
        likecartDiv.addClassName("likecart-div");

        itemCard.add(productTitle, productIcon, likecartDiv);
        return itemCard;
    }
}
