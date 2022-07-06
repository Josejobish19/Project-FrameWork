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
	ActionHelper actionhelp  = new ActionHelper();
	MouseAction clickhelp = new MouseAction();
	SendkeysActionHelper  Sendkey = new SendkeysActionHelper();
	AlertFrameWindowHelper Alerthelp = new AlertFrameWindowHelper();
	GetTableSizeList Gettablehelp = new GetTableSizeList();
	
	
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
	
	@FindBy(xpath = "//div//tr[1]")
	List<WebElement> tableClientsize;
	@FindBy(xpath = "//tr//td[contains(.,'Jobish ')]")
	WebElement tableClientresult;
	@FindBy(xpath = "//input[@name=\"identity\"]")
	WebElement username;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement passSubmit;
	@FindBy(xpath = "//a[@class=\"dropdown-toggle btn-round btn btn-default\"]")
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
	clickhelp.mouseClick(driver, Clients);
	
}
public int tableClientsize1(  ) throws Exception
{
    return tableClientsize.size();
}
public void clientsearchResult(String name)
{
	Sendkey.sendkeys(driver, ClientSearch, name);
	
}
public String ClientsearchResultText() throws Exception
{
	Gettablehelp.waitUntilElementVisible(driver, tableClientresult) ;
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
public void clickClientAction() throws Exception
{
	
	clickhelp.doubleClick(driver, clientActionsbutton);
}
public MobileClient login(String username1 , String pwd1)
{
	Sendkey.clearAndsendkeys(driver, username , username1);
	Sendkey.clearAndsendkeys(driver, password , pwd1);
	clickhelp.mouseClick(driver, passSubmit);
	return new MobileClient(driver);
	
}
}
