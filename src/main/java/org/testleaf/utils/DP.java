package org.testleaf.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testleaf.base.ProjectSpecificMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DP extends ProjectSpecificMethods{
	
	@Test(dataProvider="Create")
	public void createLead(String companyName, String firstname, String Lastname) {
		
		getDriver().findElement(By.linkText("Create Lead")).click();
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		getDriver().findElement(By.name("submitButton")).click();
	}
	
	@DataProvider(name="Create")
	public String[][] fetchData() throws IOException{
		
		String[][] data;
		/*
		 * String[][] data=new String[2][3];
		 * 
		 * data[0][0]="TestLeaf"; data[0][1]="Hari"; data[0][2]="RadhaKrishna";
		 * 
		 * data[1][0]="Qeagle"; data[1][1]="Babu"; data[1][2]="Manickam";
		 * 
		 * return data;
		 */
		
	 data=ReadExcelData.readSheetData("CreateLead");
	 
	 return data;
		
		
	}

}
