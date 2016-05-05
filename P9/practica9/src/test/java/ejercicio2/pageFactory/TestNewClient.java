/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.pageFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class TestNewClient {
    WebDriver driver;
    LoginPage poLogin;
    ManagerPage poManagerPage;
    NewCustomerPage poNewCustomerPage;
    DeleteCustomerPage poDeleteCustomerPage;
    //@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[14]/td/a") WebElement continuar;
        
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        poLogin = PageFactory.initElements(driver, LoginPage.class);
    }
    
    @Test
    public void test_Login_Correct(){
        String loginPageTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("mngr34733", "AbEvydU");
        poManagerPage = PageFactory.initElements(driver, ManagerPage.class);

        Assert.assertTrue(poManagerPage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr34733"));
        
        poNewCustomerPage = poManagerPage.newCustomer();
        
        Assert.assertTrue(poNewCustomerPage.getHomePageDashboardUserName().toLowerCase().contains("add new customer"));
        
        poNewCustomerPage.datosNewCustomer("pepitodrr", "m", "01/01/1990", "Calle Melancolía", "Madrid", "SPAIN", "424242", 
                "666666666", "pepff33333335@gmail.com", "safePass");
        
        String ValorEsperado = "Customer Registered Successfully!!!";
        WebElement ValorReal = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p"));
    
        Assert.assertTrue(ValorReal.getText().contains(ValorEsperado));
        String m4 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
        System.out.println("id");
        System.out.println(m4);
        
        poNewCustomerPage.continuar();
        
        Assert.assertTrue(poManagerPage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr34733"));
        
        poDeleteCustomerPage = poManagerPage.deleteCustomer();
        
        Assert.assertTrue(poDeleteCustomerPage.getCabecera().toLowerCase().contains("delete customer form"));
        
        poDeleteCustomerPage.deleteCustomer(m4);
        
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        Assert.assertTrue(mensaje.equals("Do you really want to delete this Customer?"));
        alert.accept();
        
        alert = driver.switchTo().alert();
        mensaje = alert.getText();
        Assert.assertTrue(mensaje.equals("Customer deleted Successfully"));
        alert.accept();
        
        driver.close();
    }
    
    @Test
    public void test_Login_Incorrect(){
        String loginPageTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("mngr34733", "AbEvydU");
        poManagerPage = PageFactory.initElements(driver, ManagerPage.class);

        Assert.assertTrue(poManagerPage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr34733"));
        
        poNewCustomerPage = poManagerPage.newCustomer();
        
        Assert.assertTrue(poNewCustomerPage.getHomePageDashboardUserName().toLowerCase().contains("add new customer"));
        
        poNewCustomerPage.datosNewCustomer("PepitoIncorrecto", "m", "01/01/1990", "Calle Melancolía", "Madrid", "SPAIN", "424242", 
                "666666666", "pepito5555@gmail.com", "safePass");
                
        Alert alert = driver.switchTo().alert();
        String mensaje = alert.getText();
        Assert.assertTrue(mensaje.equals("Email Address Already Exist !!"));
        alert.accept();
        
        
        driver.close();
    }
}
