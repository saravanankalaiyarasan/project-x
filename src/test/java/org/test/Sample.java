package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.base.Base;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample extends Base{
	List<String> priceNames;
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch();
		urlLaunch("https://www.flipkart.com/");
	}
	
	@Test
	private void test1() {
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	
	}
	@Test
	private void test2() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		 priceNames=new LinkedList<String>();
				
		for(int i=0;i<list.size();i++) {
		WebElement a = list.get(i);
		String text = a.getText();
		System.out.println(text);
		priceNames.add(text);
		}
	}
	
	@Test
	private void test3() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		 String y="";
		 List<Integer> li=new ArrayList<Integer>();
		
		 
		for(int i=0;i<list.size();i++) {
		WebElement a = list.get(i);
		String text = a.getText();
		
		String x="";
		
			if(text.contains("₹")) {
				x=text.replace("₹", "");
		
			}
			if(x.contains(",")) {
			y=x.replace(",", "");
			System.out.println(y);

			int z=Integer.parseInt(y);
			 li.add(z);
			}
					
		}

		Collections.sort(li);
		System.out.println("asending order");
		System.out.println(li);
		
		

		System.out.println("lowest price is "+li.get(0));
		System.out.println("Highest price is "+li.get(li.size()-1));
		
		//////////
		
		Map<String,Integer> mp=new LinkedHashMap<String, Integer>();
		System.out.println(priceNames.size());
		System.out.println(li.size());
		
		System.out.println("-----------------Name and Price------------------");   //way 1
		for (int i = 0; i <priceNames.size(); i++) {
			System.out.println(priceNames.get(i)+"------------"+ li.get(i));
		}
		
				
				for (int i = 0; i <priceNames.size(); i++) {
					mp.put(priceNames.get(i), li.get(i));
				}
				
				Set<Entry<String, Integer>> et = mp.entrySet();
				
				for (Entry<String, Integer> x : et) {
					System.out.println(x);
				}
	}
	
	

}


