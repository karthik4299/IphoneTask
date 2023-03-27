package org.task;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Classs extends BaseClass {

	public static void main(String[] args) throws AWTException {

		browserlaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		maximize();
		implicityWait(10);
		WebElement click = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		click(click);
		WebElement search = driver.findElement(By.name("q"));
		sendkeys(search, "iphone");
		robotEnter();

		List<WebElement> pr = driver.findElements(By.xpath("//div[@class='_4rR01T']"));

		List<String> l = new ArrayList<String>();
		for (WebElement x : pr) {
			String text = x.getText();
			System.out.println(text);
			l.add(text);
		}

		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<Integer> l1 = new ArrayList<Integer>();

		for (int i = 1; i < price.size(); i++) {
			WebElement w = price.get(i);
			String text1 = w.getText();
			if (text1.contains("₹")) {
				String re = text1.replace("₹", "");

				if (text1.contains(",")) {
					String re1 = text1.replace(",", "");
					int pa = Integer.parseInt(re1);
					l1.add(pa);
				}
			}

		}

		// ascending order
		Collections.sort(l1);
		System.out.println(l1);

	}

}
