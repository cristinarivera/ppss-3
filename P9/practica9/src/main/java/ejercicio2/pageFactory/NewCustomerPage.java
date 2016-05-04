/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class NewCustomerPage {
    WebDriver driver;
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p") WebElement homePageUserName;
    
    @FindBy(name="name") WebElement name;
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]") WebElement male;
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]") WebElement female;    
    @FindBy(name="dob") WebElement dateOfBirth;
    @FindBy(name="addr") WebElement address;
    @FindBy(name="city") WebElement city;
    @FindBy(name="state") WebElement state;
    @FindBy(name="pinno") WebElement pin;
    @FindBy(name="telephoneno") WebElement telephone;
    @FindBy(name="emailid") WebElement email;
    @FindBy(name="password") WebElement password;
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]") WebElement submit; //también como los anteriores
    
        
    public NewCustomerPage(WebDriver driver){
             this.driver = driver;
    }
            
    public void datosNewCustomer(String name, String gender, String dateOfBirth, 
            String address, String city, String state, String pin, String telephone, 
            String email, String password){
        
        this.name.sendKeys(name);
        if(gender == "m"){
            male.click();
        }
        else {
            female.click();
        }
        this.dateOfBirth.sendKeys(dateOfBirth);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.pin.sendKeys(pin);
        this.telephone.sendKeys(telephone);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.submit.click();
        
        
    
    }
    public String getHomePageDashboardUserName(){
        return homePageUserName.getText();
    }
}
