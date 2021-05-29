package edu.handong.csee.java.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransactionReader {

	public static void main(String[] args) {
		TransactionReader reader = new TransactionReader();
		reader.run();
	}

	private void run() {
		//When "Transaction.csv" is under bin directory 
		String fileName = "." + File.separator + "bin" + File.separator + "Transaction.csv";
		
		try {
			Scanner inputStream = new Scanner(new File(fileName));
			String line = inputStream.nextLine();
			double total=0; //total sales 
			while(inputStream.hasNextLine()) {
				//contains SKU, Quantity, Price, Description
				line=inputStream.nextLine();
				//turn the string into an array of strings
				String[] ary = line.split(",");
				//extract each item into an appropriate variable
				String SKU=ary[0];
				int quantity = Integer.parseInt(ary[1]);
				double price = Double.parseDouble(ary[2]);
				String description = ary[3];
				//Output item 
				System.out.println("Sold " + quantity + " of " + description + " (SKU: " + SKU + ") at " + price + " each.");
				//Compute total
				total+=quantity*price;
			}
			System.out.println("Total sales: " + total);
			inputStream.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot find file" + fileName);
		}
	}
}
