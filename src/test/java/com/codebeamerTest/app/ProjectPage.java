package com.codebeamerTest.app;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class ProjectPage {
    private StartPage startpage = new StartPage();
    private CommonFunctions commonfunctions = new CommonFunctions();
    private static final String FILE_PATH = "src/test/resources/";
    private SelenideElement createButton = $(By.cssSelector("input[type='submit']"));
    private SelenideElement createNewButton = $("#newProject");
    private SelenideElement finishButton = $("#finishButton");
    private SelenideElement nameInputField = $("#name");
    private SelenideElement projectListTab = $("#project-list-tab");
    private SelenideElement projectList = $("#project-list");
    private SelenideElement uploadFile = $(By.cssSelector("input[type='file']"));
    private SelenideElement adminMenu = $("#admin_ToolBarItem");
    private SelenideElement removeButton = $(By.cssSelector("input[name='REMOVE']"));
    private SelenideElement deleteButton = $(byXpath("//input[@value='Delete Project...']"));


    public void CreateProject (ProjectProperties properties, String filename) {
        createButton.click();
        createNewButton.click();
        uploadFile.uploadFile(new File(FILE_PATH+filename));
        $(".qq-upload-file").shouldHave(text(filename));
        commonfunctions.Submit();
        String projectName = nameInputField.getValue();
        properties.setProjectName(projectName);
        finishButton.click();
        startpage.SelectMenu("Projects");
        projectListTab.click();
        projectList.shouldHave(text(properties.getProjectName()));
     }

     public void DeleteProject(ProjectProperties properties) {
         startpage.SelectMenu("Projects");
         projectListTab.click();
         $(By.linkText(properties.getProjectName())).click();
         adminMenu.click();
         removeButton.click();
         commonfunctions.Yes();
         deleteButton.click();
         commonfunctions.Yes();
         $(By.tagName("body")).shouldHave(text("has been deleted"));
     }
}
