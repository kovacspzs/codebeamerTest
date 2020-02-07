package com.codebeamerTest.app;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class WikiPage {
    private CommonFunctions commonfunctions = new CommonFunctions();
    private SelenideElement wikiName = $(By.xpath("//*[@id=\"name\"]"));
    private SelenideElement wikiLink = $(".breadcrumbs-summary").$(".generated-link");


    public void CreateWikiPage (ProjectProperties properties, String pagename) {
        $(By.linkText(properties.getProjectName())).click();
        $(".actionLink").should(appear);
        $(".actionLink", 0).click();
        switchTo().frame("inlinedPopupIframe");
        wikiName.should(appear);
        wikiName.setValue(pagename);
        //Test step request extra #3
        commonfunctions.Submit();
        //Test step request extra #4
        wikiLink.shouldHave(text(pagename));
    }
}


