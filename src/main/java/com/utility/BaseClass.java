package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Select select;
	public static Sheet sheet;
	public static Workbook wps;


	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Prajula-50628\\eclipse-workspace\\Selenium\\Essentials\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.edge.driver","C:\\Users\\Prajula-50628\\eclipse-workspace\\Selenium\\Essentials\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	public static void launchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void clearBrowserCache() throws InterruptedException
	{
	driver.manage().deleteAllCookies();//delete all cookies
	Thread.sleep(7000); //wait 7 seconds to clear cookies.
	}
	
	public static void get(String url) {
		driver.get(url);
	}

	//Explicit Waits
	public static void ExVisibilityOfElementLocated(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void ExElementToBeClickable(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);	
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//To enter values in a WebElement
	public static void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}	
	//to click an element
	public static void click(WebElement element) {
		element.click();
	}

	public void close() {
		driver.close();
	}
	// to read the properties file
	public static String propertiesReader(String key) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Prajula-50628\\eclipse-workspace\\Project\\src\\main\\resources\\OrangeHrm.properties");
		Properties prop = new Properties();//subclass of HashTable
		prop.load(file); //To read a properties file (key and value paIR)
		return prop.getProperty(key);

	}

	//--------------------------------------------------------------
	//II - SelectBy
	public static void selectValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
	public static void selectVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public static void selectIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	//deSelectBy
	public static void deselectValue(WebElement element, String value) {
		select = new Select(element);
		select.deselectByValue(value);
	}
	public static void deselectVisibleText(WebElement element, String value) {
		select = new Select(element);
		select.deselectByVisibleText(value);
	}
	public static void deselectIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);
	}

	//------------------------------------------------------
	//Excel Operations

	//DISCLAIMER - this will work only if your excel contains string and numbers. soo to be added
	//gets one row of data along with it's header value
	public Map<String, String> excelGetAsMap(String filePath, int sheetIndex, String desiredValue) throws IOException {
		Map<String, String> excelData = new LinkedHashMap<String, String>();
		String[] headerData = null;
		String[] desiredData = null;
		int desiredRowIndex = 0;

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook wps = new XSSFWorkbook(fis);
		Sheet sheet = wps.getSheetAt(sheetIndex); // getting access to all the elements in sheet
		int lastRow = sheet.getLastRowNum();

		//reading header values into Array
		for(int i=0;i<1;i++) {//rows iterator

			int lastCell = sheet.getRow(i).getLastCellNum();
			headerData = new String[lastCell];
			for(int j=0;j<lastCell;j++) {//cell iterator
				if(sheet.getRow(i).getCell(j).getCellTypeEnum()==CellType.STRING) {
					String headerValue = sheet.getRow(i).getCell(j).getStringCellValue();
					headerData[j]=headerValue;	
				}
				else {
					String headerValue = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
					headerData[j]=headerValue;	
				}
			}
		}
		System.out.println(Arrays.toString(headerData));
		//getting the desired row index -- not working to check
		for(int i=1;i<=lastRow;i++) {

			int lastCell = sheet.getRow(i).getLastCellNum();
			for(int j=0; j<lastCell;j++) {
				if(sheet.getRow(i).getCell(j).getCellTypeEnum()==CellType.STRING) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					if(value.equalsIgnoreCase(desiredValue)) {
						desiredRowIndex = i;
					}
				}
				else {
					String value = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
					if(value.equalsIgnoreCase(desiredValue)) {
						desiredRowIndex = i;
					}
				}
			}
		}

		//getting the desired row values
		for(int i=desiredRowIndex; i==desiredRowIndex; i++) {
			int lastCell = sheet.getRow(i).getLastCellNum();
			desiredData= new String[lastCell];
			for(int j=0; j<lastCell;j++) {
				if(sheet.getRow(i).getCell(j).getCellTypeEnum()==CellType.STRING) {
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					desiredData[j]=value;
				}
				else {
					//making use of an amazing method
					String value = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
					desiredData[j]=value;
				}
			}
		}	
		System.out.println(Arrays.toString(desiredData));
		//storing the data in a LinkedHashMap
		for(int i=0;i<headerData.length;i++) {
			excelData.put(headerData[i], desiredData[i]);	
		}

		return excelData;
	}

	//	------------------------------------------#Excel Read Ends Here#-------------------------------	
	//----------------------------#JavascriptExecutor methods start here#------------------------------------------

	public static void jsClickElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void jsDrawBorder(WebElement element, String borderColour) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='"+borderColour+"'", element);

	}

	//https://www.computerhope.com/htmcolor.htm - all html colours
	public static void jsChangeBackgroundColour(WebElement element, String colour) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.background='"+colour+"'", element);

	}

	public static void jsDrawBorderChangeBackground(WebElement element, String backgroundColour, String borderColour) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:"+backgroundColour+"; border:"+borderColour+";')", element);
	}
	public static void jsGenerateAlerts(String message) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}

	public static void jsRefresh() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}

	public static String  jsPageTitle() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//    	String pageTitle = js.executeScript("return document.title;").toString(); //same as the below line
		String pageTitle = (String) js.executeScript("return document.title;");
		return pageTitle;
	}

	//Wow!
	public static String jsEntirePageContent() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageContent = js.executeScript("return document.documentElement.innerText;").toString();
		return pageContent;
	}

	public static void jsWindowScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void jsWindowScrollDistance(int distance) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+distance+")");
	}

	//try if this is working later 
	public static void jsWindowScrollLeftRight(int distance) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo("+distance+",0)");
	}

	public static void jsScrollToElementTrue(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void jsScrollToElementFalse(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
    public static void jsSetAttribute(WebElement element, String attribute, String attributeValue) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('"+attribute+"','"+attributeValue+"')", element);
	}
	
    public static String jsGetAttribute(WebElement element, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String value = (String)js.executeScript("return arguments[0].getAttribute('"+attribute+"')", element);
		return value;
	}
//    -------------------------------------#JavaScriptExecutor methods end here#------------------------------


}
