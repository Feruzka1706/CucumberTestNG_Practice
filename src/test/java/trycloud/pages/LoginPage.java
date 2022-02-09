package trycloud.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import trycloud.utility.ConfigReader;
import trycloud.utility.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(css = "#user")
    public WebElement userNameInput;

    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement loginButton;


    @FindBy(css = "p.warning.wrongPasswordMsg")
    public WebElement errorMessage;


    /**this login method for logining default with one username and password to website
     Just regular logging the webpage we can call this method and no need even providing
     parameters inside the method
     */
    public void login(){
        userNameInput.sendKeys(ConfigReader.read("username1"), Keys.ENTER);
        passwordInput.sendKeys(ConfigReader.read("password"));
        loginButton.click();
    }

    /**
     * @param username
     * @param password
     * This method also used for logging to webpage, only we can provide different
     * user and password based on special scenarios
     */
    public void login(String username, String password){
        userNameInput.sendKeys(username, Keys.ENTER);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
