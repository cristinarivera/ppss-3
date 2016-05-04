/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class ManagerPage {
    WebDriver driver;
    @FindBy(xpath="//table//tr[@class='heading3']")
    WebElement homePageUserName;
    @FindBy(linkText="New Customer")
    WebElement newCustomer;
    @FindBy(linkText="Log out") WebElement logOut;
    
    public ManagerPage(WebDriver driver){
        this.driver = driver;
        /*
        homePageUserName = driver.findElement(By.xpath("//table//tr[@class='heading3']"));
        newCustomer = driver.findElement(By.linkText("New Customer"));
        logOut = driver.findElement(By.linkText("Log out"));
*/
    }
    public String getHomePageDashboardUserName(){
        return homePageUserName.getText();
    }

}
