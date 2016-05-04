/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.pageFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
        
        poNewCustomerPage.datosNewCustomer("pepitoaa", "m", "01/01/1990", "Calle Melancolía", "Madrid", "SPAIN", "424242", 
                "666666666", "pepito5aa555555@gmail.com", "safePass");
        
        String ValorEsperado = "Customer Registered Successfully!!!";
        WebElement ValorReal = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p"));
    
        Assert.assertTrue(ValorReal.getText().contains(ValorEsperado));
        String m1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[1]")).toString();
        String m2 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[1]")).getText();
        System.out.println("primero");
        System.out.println(m1);
        System.out.println("segundo");
        
        System.out.println(m2);
        /*
        /html/body/table/tbody/tr/td/table/tbody/tr[4]/td[1] //CustomerID
        /html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2] //numero
        */        
                
        driver.close();
    }
}
