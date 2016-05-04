/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.pageFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestLoginPage {
    WebDriver driver;
    LoginPage poLogin;
    ManagerPage poManagerPage;
    
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        //poLogin = new LoginPage(driver);   
        poLogin = PageFactory.initElements(driver, LoginPage.class);
    }
    
    @Test
    public void test_Login_Correct(){
        String loginPageTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("mngr34733", "AbEvydU");
        poManagerPage = PageFactory.initElements(driver, ManagerPage.class);

        Assert.assertTrue(poManagerPage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr34733"));
        driver.close();
    }
    
    @Test
    public void test_Login_Incorrect(){
        String loginPageTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("mngr34733", "3333333");
        poManagerPage = PageFactory.initElements(driver, ManagerPage.class);

        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        alert.accept();
        Assert.assertTrue(mensaje.equals("User or Password is not valid"));
        Assert.assertTrue(mensaje.contains("User or Password is not valid"));
        
        driver.close();
    }
}
