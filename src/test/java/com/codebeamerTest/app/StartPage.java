package com.codebeamerTest.app;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class StartPage {
    private SelenideElement mystartButton = $("#mystart_ToolBarItem");
    private SelenideElement projectsButton = $("#project_browser_ToolBarItem");
    private SelenideElement reportsButton = $("#queries_browser_ToolBarItem");
    private SelenideElement tagsButton = $("#labels_browser_ToolBarItem");
    private SelenideElement sysadminButton = $("#sysadmin_browser_ToolBarItem");

    public void SelectMenu(String menutiem) {
        switch (menutiem){
            case "My Start":
                mystartButton.click();
                break;
            case "Projects":
                projectsButton.click();
                break;
            case "Reports":
                reportsButton.click();
                break;
            case "Tags":
                tagsButton.click();
                break;
            case "System Admin":
                sysadminButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid menu: " + menutiem);
        }
    }
}
