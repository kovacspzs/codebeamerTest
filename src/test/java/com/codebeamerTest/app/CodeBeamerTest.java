package com.codebeamerTest.app;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.*;


public class CodeBeamerTest {

    private ProjectProperties properties = new ProjectProperties();
    private LoginPage login = new LoginPage();
    private StartPage startpage = new StartPage();
    private ProjectPage projectpage = new ProjectPage();
    private WikiPage wikipage = new WikiPage();

    @Before
    public void setBrowser() {
        ChromeOptions options = new ChromeOptions();
        //Incognito mod beallitas
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://localhost:8080";
        Configuration.startMaximized = true;
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @Test
    public void codeBeamerTest() {
        //1. Lépj be a telepítéskor létrehozott felhasználóval
        open("/");
        login.credentials("pkovacs", "Testpass1234");

        //2. Kattints a Projects menure
        startpage.SelectMenu("Projects");

        /*
        3. Kattints a New Project gombra (+ icon) (A videóban Create project van)
        4. Válaszd a Create a new project opciót
        5. Töltsd fel az Intland_Software's_Scrum_Template.zip fájlt
        6. Kattints a Next gombra
        7. Jegyezd meg a Name mező értékét
        8. Kattints a Finish gombra
        10. Ellenőrizd az adott nevű projekt sikeresen létrejött-e */
        projectpage.CreateProject(properties,"Intland_Software's_Scrum_Template.zip");

        //1. Projekt kreálás után az úgynevezett Project Wiki lapon landolunk. Itt kattints a New Child Page ikonra
        //2. A felugró ablakon töltsd ki a Name mezőt tetszőleges értékkel
        //3. Mentsd el a Wiki lapot a Save gombra kattintással
        //4. Ellenőrizd, hogy létrejött-e a megadott nevű Wiki lap
        wikipage.CreateWikiPage(properties,"Intland ChildPage");

        //Project törlése a teszt megismételhetőség érdekében
        projectpage.DeleteProject(properties);
    }
}

