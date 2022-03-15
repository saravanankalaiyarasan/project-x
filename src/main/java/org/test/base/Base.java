  package org.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;
//import org.test.ExcelRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	public static WebDriver browserLaunch() {
																		//Browser launch
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		return driver;
		
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);											//url launch

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void SendKeys(WebElement e,String keys) {      //sendkeys
		e.sendKeys(keys);
	}
	
	
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static void screenshot(String path) throws IOException {
		TakesScreenshot ss=(TakesScreenshot)driver;
		File from = ss.getScreenshotAs(OutputType.FILE);											//screenshot
		File to=new File("E:\\development\\workplace\\MavenNew\\Screenshot\\"+path+".png");
		
		FileUtils.copyFile(from, to);
		
		
	}
	
	//get Title
	
	public static String getTitle() {
		String Title=driver.getTitle();
		return Title;
		
	}
	
	//get current url
	
	public static String getCurrentUrl() {
		String url=	driver.getCurrentUrl();
		return url;
	}
	
	//quit 
	
	public static void quit() {
		driver.quit();
		
	}
	
	//get Attribute
	
	public static String getAttribute(WebElement e,String Att) {
		
		return e.getAttribute(Att);
		

	}
	
	//get text
	
	public static String getText(WebElement e) {
		return e.getText();
		
	}
	
	/////////////////////////////////////////////////
	
	//mouse over using Actions
	
	public static void moveToAndClick(WebElement moveTo) {
																					//mouseover and click
		Actions x=new Actions(driver);
		
		x.moveToElement(moveTo).click().perform();
		
		
	}
	
	//mouse over 
	

	public static void moveToByActions(WebElement moveTo) {
																					//move to by mouseover
		Actions x=new Actions(driver);
		
		x.moveToElement(moveTo).perform();
		
		
	}
	
	// mouseover click
	
	public static void clickByActions(WebElement moveTo) {								//click by Actions
		
    Actions x=new Actions(driver);
		
		x.click(moveTo).perform();
		
	}

	public static void sendkeysByActions( String keys) {
		 Actions x=new Actions(driver);												//sendkeys By Actions
		 
		x.sendKeys(keys).perform();
		
	}
	
	
	//dragAndDrop By Actions
	
	public static void DragAndDrop(WebElement from, WebElement to) {
		 Actions x=new Actions(driver);	
		 x.dragAndDrop(from, to).perform();
	}
	
	
	
	////////////////////////////////////////////////
	
	//Java script 
	
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;									//scrollUp
		js.executeScript("arguments[0].scrollIntoView(true)", e);

	}
	
	
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;									//scrollDown
		js.executeScript("arguments[0].scrollIntoView(false)", e);

	}
	
	public static void sendkeysByJavaScript(String input, WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;									//sendKeysByJavaScript
		js.executeScript("arguments[0].setAttribute('value','"+input+"')", e);

	}
	

	public static void clickByJavaScript( WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;									//clickByJavaScript
		js.executeScript("arguments[0].click();", e);

	}
	
	/////////////////////////////////////////////////////
	
	//Alart
	
	public static String getTextByAlart() {
																						//get text by alart
		String text = driver.switchTo().alert().getText();
		return text;
		
	}
	
	
	public static void acceptByAlart() {
		driver.switchTo().alert().accept();												//accept by alart
	}

	public static void dismissByAlart() {
		driver.switchTo().alert().dismiss();											//dismiss by alart
		
	}
	
	
	public static void alartSendkeys(String keys) {
		
		driver.switchTo().alert().sendKeys(keys);										// alart sendkeys & accept
		driver.switchTo().alert().accept();
		
	}
	
	/////////////////////////////////
	
	//Frame
	
	public static void frameSwitch(int index) {
		driver.switchTo().frame(index);													// switch to frames
	}
	
	
	
	public static void parentFrame() {													// return to parent frame
		driver.switchTo().parentFrame();
	}
	
	
	public static void frameDefaultContent() {											// direct to default content
		driver.switchTo().defaultContent();
	}
	
	/////////////////////////////////////////////////////
//	
//	//DropDown Select s=new Select();
//	
//	public static String getAttributeBySelect(WebElement e) {
//		
//		Select s=new Select(e);
//		
//		List<WebElement> options = s.getOptions();
//		
//
//		for(int i=0;i<options.size();i++) {										// qus 9
//			WebElement webElement = options.get(i);
//			String text = webElement.getAttribute("value");
//			String a=text;
//		}
//		return a;
//		
//		
//	}
	
	
	
	///////////////////////////////
	
	//Windows Handle
	
	
	public static void windowsHandle1() {

		String oneid = driver.getWindowHandle();
		
		Set<String> allid = driver.getWindowHandles();											//way 1
		
		
		
		for(String eachid:allid) {
			if(!oneid.equals(eachid)) {
				driver.switchTo().window(eachid);
			}
		}
	
	}
	
	
	
	public static void windowsHandile2(int to) {
		
		
		
		Set<String> allid = driver.getWindowHandles();											//way 2
		
int	count=1;
		
		for(String eachid:allid) {							
			if(count==to) {
				driver.switchTo().window(eachid);
			}
			count++;
		}
		
	
	}
	
	public static void windowsHandleArrayList(int index) {
		
		Set<String> all = driver.getWindowHandles();												//wey 3
		
		List<String> li=new ArrayList<String>();
		li.addAll(all);
		
		driver.switchTo().window(li.get(index));
		
		
	}
	///////////////////////////////
	
	//WebTable
	
	public static Dimension webtableSize(WebElement e) {
		
		Dimension size = e.getSize();
		return size;
		
	}
	
	
	//Excel Read with looping conditions(printf())
	
	public static void excelReadLoop(String fileName, String sheetName) throws IOException {
		
		File f=new File("E:\\development\\workplace\\MavenNew\\src\\test\\resources\\"+fileName+".xlsx");
		
		FileInputStream fi=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fi);
		
		Sheet sheet = w.getSheet(sheetName);
		
		for(int j=0;j<sheet.getPhysicalNumberOfRows();j++) {
		
		Row row = sheet.getRow(j);
		
			for(int i=0;i<row.getPhysicalNumberOfCells();i++) {
				
				Cell cell = row.getCell(i);
				
				 int type = cell.getCellType();
				 
				
				if(type==1) {
					String value = cell.getStringCellValue();
					
					System.out.println(value);
				}else {
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dd = cell.getDateCellValue();
						SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
						String value = sd.format(dd);
						System.out.println(value);
					}
					else {
						double db = cell.getNumericCellValue();
						long ln=(long)db;
						String value = String.valueOf(ln);
						System.out.println(value);
						
						}
					}
				
				
		
			}
		
		
		}
		
		
		
	}
	
	//ExcelRead
	public static String excelRead(String fileName, String sheetName, int row , int cell) throws IOException {
		
		File f=new File("E:\\development\\workplace\\MavenNew\\src\\test\\resources\\"+fileName+".xlsx");
		
		FileInputStream fi=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(fi);
		
		Sheet sheet = w.getSheet(sheetName);
			
		Row row1 = sheet.getRow(row);
					
		Cell cell1 = row1.getCell(cell);
				
		int type = cell1.getCellType();
				 
		String value=null;
				
		if(type==1) {
			 value = cell1.getStringCellValue();
					
					
		}else {
			if(DateUtil.isCellDateFormatted(cell1)) {
				Date dd = cell1.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
				 value = sd.format(dd);
						
			}
			else {
				double db = cell1.getNumericCellValue();
				long ln=(long)db;
				 value = String.valueOf(ln);
						
		 }
		}
		return value;
			
	}
		
	//excel sheet create
		
		public static void excelBookCreate(String bookName, int indexofrow, int indexofcell,String valueSet) throws IOException {
			

			File f=new File("E:\\development\\workplace\\MavenNew\\src\\test\\resources\\"+bookName+".xlsx");
			
			
			
			Workbook w=new XSSFWorkbook();
			
			Sheet sheet = w.createSheet();
			
			Row row = sheet.createRow(indexofrow);
			
			Cell cell = row.createCell(indexofcell);
			
			cell.setCellValue(valueSet);
			FileOutputStream fo=new  FileOutputStream(f);
			w.write(fo);

			
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	


