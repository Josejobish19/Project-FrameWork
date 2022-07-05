package com.mobileService;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import webActionHelpers.ActionHelper;
import webActionHelpers.AlertFrameWindowHelper;
import webActionHelpers.GetTableSizeList;
import webActionHelpers.MouseAction;
import webActionHelpers.SendkeysActionHelper;

public class MobileClient {
	
	WebDriver driver;
	ActionHelper ab  = new ActionHelper();
	MouseAction ac = new MouseAction();
	SendkeysActionHelper  ad = new SendkeysActionHelper();
	AlertFrameWindowHelper ae = new AlertFrameWindowHelper();
	GetTableSizeList ts = new GetTableSizeList();
	@FindBy(xpath = "//h1[contains(.,'Customers')]")
	WebElement Customers;
	@FindBy(xpath = "//button[contains(.,' Add Client    ')]")
	WebElement AddClientButton;
	@FindBy(xpath = "//select[@name=\"dynamic-table_length\"]")
	WebElement TableLengthSort;
	@FindBy(xpath = "//span[contains(.,'Change columns')]")
	WebElement Changecolumns;
	@FindBy(xpath = "//span[contains(.,'Clients')]")
	WebElement Clients;
	@FindBy(xpath = "//input[@type=\"search\"and@aria-controls=\"dynamic-table\"]")
	WebElement ClientSearch;
	
	@FindBy(xpath = "xpath(\"//*[@id=\\\"dynamic-table\\\"]/tbody/tr\")")
	List<WebElement> tableClientsize;
	@FindBy(xpath = "xpath(\"//*[@id=\"dynamic-table\"]/tbody/tr/td[2]")
	WebElement tableClientresult;
	@FindBy(xpath = "//input[@name=\"identity\"]")
	WebElement username;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement passSubmit;
	@FindBy(xpath = "//*[@id=\"content-wrapper\"]/section[2]/div/li/a")
	WebElement clientActionsbutton;
	@FindBy(xpath = "//a[contains(.,' Export to Excel file                    ')]")
	WebElement ExporttoExcelfilebutton;
	@FindBy(xpath = "//a[contains(.,' Export to PDF file                    ')]")
	WebElement ExporttoPDFfilebutton;
	@FindBy(xpath = "//a[contains(.,' Add Customers by CSV                    ')]")
	WebElement AddCustomersbyCSVbutton;
	@FindBy(xpath = "//a[contains(.,' Delete Selected                     ')]")
	WebElement DeleteSelectedbutton;
	
	
public  MobileClient(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver,this);
}
public boolean isCustomersfeildDisplayed()
{
	return Customers.isDisplayed();
}
public boolean isAddClientButtondisplayed()
{
	return AddClientButton.isDisplayed();
}
public boolean istableLengthButtondisplayed()
{
	return TableLengthSort.isDisplayed();
}
public boolean isChangecolumnsButtondisplayed()
{
	return Changecolumns.isDisplayed();
}
public boolean isclientSearchdisplayed()
{
	return ClientSearch.isDisplayed();
}
public void clickClient() {
	ac.mouseClick(driver, Clients);
	
}
public int tableClientsize1(  ) throws Exception
{
    return tableClientsize.size();
}
public void clientsearchResult(String name)
{
	ad.sendkeys(driver, ClientSearch, name);
	
}
public String ClientsearchResultText()
{
	return tableClientresult.getText();
}
public boolean isClientsearchResultdisplayed()
{
	return tableClientresult.isDisplayed();
}
public boolean isclientActionsbuttondisplayed()
{
	return clientActionsbutton.isDisplayed();
}
public boolean isExporttoExcelfilebuttondisplayed()
{
	return ExporttoExcelfilebutton.isDisplayed();
}
public boolean isExporttoPDFfilebuttondisplayed()
{
	return ExporttoPDFfilebutton.isDisplayed();
}
public boolean isAddCustomersbyCSVbuttondisplayed()
{
	return AddCustomersbyCSVbutton.isDisplayed();
}
public boolean isDeleteSelectedbuttondisplayed()
{
	return DeleteSelectedbutton.isDisplayed();
}
public void clickClientAction()
{
	ac.mouseClick(driver, clientActionsbutton);
}
public MobileClient login(String username1 , String pwd1)
{
	ad.clearAndsendkeys(driver, username , username1);
	ad.clearAndsendkeys(driver, password , pwd1);
	ac.mouseClick(driver, passSubmit);
	return new MobileClient(driver);
	
}
}
