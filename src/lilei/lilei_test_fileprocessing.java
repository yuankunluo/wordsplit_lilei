package lilei;

import ICTCLAS.I3S.AC.ICTCLAS50;
import java.util.*;
import java.io.*;


public class lilei_test_fileprocessing {
	public static void main(String[] args){
		try {
			ICTCLAS50 ictclas = new ICTCLAS50();
			String arg = ".";
			if (ictclas.ICTCLAS_Init( arg.getBytes("UTF-8")) == false){
				System.out.println("ICTCLAS initial failed");
				return;
			} else {
				String inputFileName = "./input/huoche.txt";
				byte[] inputFileNameByte = inputFileName.getBytes("UTF-8");
				System.out.println("InputFile Length: " + inputFileNameByte.length);
				System.out.println(inputFileNameByte);
				
				String outputFileName = "./output/huoche.txt";
				byte[] outputFileNameByte = outputFileName.getBytes("UTF-8");
				
				ictclas.ICTCLAS_FileProcess(inputFileNameByte, 0, 1, outputFileNameByte);
				
				System.out.println("File Processing successfull!");
				
				
			}
			
		} catch (Exception ex){
			System.out.println(ex.toString());
		}
		
	}
}
