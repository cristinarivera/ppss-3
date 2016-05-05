/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Cristina Rivera Baydal ( crb13@alu.ua.es )
 */
public class DeleteCustomerPage {
    WebDriver driver;
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p") WebElement cabecera;
    @FindBy(name="cusid") WebElement idCustomer;
    @FindBy(name="AccSubmit") WebElement submit;
    
    public DeleteCustomerPage(WebDriver driver){
             this.driver = driver;
    }
    
    public void deleteCustomer(String idCustomer){
        this.idCustomer.sendKeys(idCustomer);
        submit.click();        
    }
    
    
    public String getCabecera(){
        return cabecera.getText();
    }
}
