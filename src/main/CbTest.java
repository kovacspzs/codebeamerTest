package com.codebeamerTest.app;

import org.junit.Test;
import org.openqa.selenium.By;
import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class CbTest {

    private static final String PAGE = "http://localhost:8080";
    private static final String USERNAME = "kovacspzs";
    private static final String PASSWORD = "Almafa1234";
    private static final String filePath = "src/test/resources/Intland_Software's_Scrum_Template.zip";
    private static final String fileName = "Intland_Software's_Scrum_Template.zip";
    private static final String pageName = "Intland ChildPage";

    @Test
    public void Login() {
        open(PAGE);
        //Test step request #1
        $("#user").setValue(USERNAME);
        $("#password").setValue(PASSWORD);
        $(".login_button").click();

        //Test step request #2
        $("#project_browser_ToolBarItem").click();

        //Test step request #3
        $(By.cssSelector("input[type='submit']")).click();

        //Test step request #4
        $("#newProject").click();

        //Test step request #5
        File file = $(By.cssSelector("input[type='file']")).uploadFile(new File(filePath));
        $(".qq-upload-file").shouldHave(text(fileName));

        //Test step request #6
        $(By.cssSelector("input[name='_eventId_submit']")).click();

        //Test step request #7
        String projectName = $("#name").getValue();

        //Test step request #8
        $(By.cssSelector("input[name='_eventId_submit']")).click();

        //Test step request #9
        $("#finishButton").click();

        //Test step request #10
        $("#project_browser_ToolBarItem").click();
        $("#project-list-tab").click();
        Boolean isProjectExists = false;
        if ($("#project-list").getText().equals(projectName)){
            isProjectExists = true;
        }

        //Test step request extra #1
        $(By.linkText(projectName)).click();
        $(".actionLink").should(appear);
        $(".actionLink", 0).click();

        //Test step request extra #2
        $(By.xpath("//*[@id=\"name\"]")).should(appear);
        $(By.xpath("//*[@id=\"name\"]")).setValue(pageName);

        //Test step request extra #3
        $(By.cssSelector("input[type='submit']")).click();

        //Test step request extra #4
        $("title").shouldHave(text(pageName));

    }

}
