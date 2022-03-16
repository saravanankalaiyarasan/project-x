package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.base.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart extends Base {
	

	
	@BeforeClass
	private void browser() {
		browserLaunch();
		urlLaunch("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
	}
	
	@BeforeMethod
	private void url() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("---------------");

	}
	
	@Test
	private void test1() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
			
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		Thread.sleep(5000);
		
		for(int i=0;i<list.size();i++) {
			WebElement ele = list.get(i);
			String text = ele.getText();
			System.out.println(text);
		}
		
		
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<Integer> li=new ArrayList<Integer>();
		
		for(int i=0;i<list2.size();i++) {
			
			WebElement element = list2.get(i);
			
			String text = element.getText();
			
			String x="";
			if(text.contains("₹")){
				x=text.replace("₹", "");
			}
			
			String y="";
			
			if(x.contains(",")) {
				y=x.replace(",", "");
				System.out.println(y);
			int z=Integer.parseInt(y);
				li.add(z);
			}
			
		}
	Collections.sort(li);
		System.out.println("asanding order"+li);
		
		System.out.println("min rate is "+li.get(0));
		
		System.out.println("max rate is "+li.get(li.size()-1));
		
		
	}
	
	
	@Test
	private void test3() throws InterruptedException {
		List<WebElement> findElements = driver.findElements(By.xpath("(//a[@class='ge-49M'])"));
		
		System.out.println(findElements.size());
		
		List<Integer> li=new ArrayList<Integer>();
		for(int i=0;i<findElements.size();i++) {
			Thread.sleep(2000);
			findElements.get(i).click();
			
			
			Thread.sleep(3000);
			System.out.println("******************************");
								
				List<WebElement> list = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
				
				for(int j=0;j<list.size();j++) {
					WebElement ele = list.get(j);
					String text = ele.getText();
					System.out.println(text);
				}
																
				Thread.sleep(2000);
								
				List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

				
				for(int k=0;k<list2.size();k++) {
					
					WebElement element = list2.get(k);
					
					String text = element.getText();
					
					String x="";
					if(text.contains("₹")){
						x=text.replace("₹", "");
					}
					
					String y="";
					
					if(x.contains(",")) {
						y=x.replace(",", "");
						System.out.println(y);
					int z=Integer.parseInt(y);
						li.add(z);
					}
				
				}																							
		}
		
		Collections.sort(li);
		System.out.println("asanding order"+li);
		
		System.out.println("min rate is "+li.get(0));
		
		System.out.println("max rate is "+li.get(li.size()-1));
			
	}
	
	@AfterMethod
	private void after() {
		System.out.println("-----------------");
	}
	
	@AfterClass
	private void af() {
		
		quit();
	}

}
