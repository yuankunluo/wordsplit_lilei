package lilei;

import ICTCLAS.I3S.AC.ICTCLAS50;

import java.util.*;
import java.io.*;

public class lilei_test_paragraphprocessing {
	public static void main(String[] args){
		try {
			// Get an instances of ICTCLAS50
			ICTCLAS50 testICTCLAS50 = new ICTCLAS50();
			String arg = ".";
			if (testICTCLAS50.ICTCLAS_Init(arg.getBytes("UTF-8")) == false) {
				System.out.println("Initial ICTICALS50 Failed.");
				return;
			}
			else {
				System.out.println("ICTCALS50 Initial successful.");
			}
			String sInput = "北京地铁：#文文明明 与你牵手#【地铁文明大家谈】“蝗虫”过后的10号线，一片狼藉…北京首都的宽容大度为人称道，但有时候宽容过了头也是最大的诟病。对于恶意破坏北京首都的行为，我们只想说“这里不欢迎你！”";
			byte nativByte[] = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("UTF-8"), 0, 1);
			System.out.print(nativByte.length);
			String nativStr = new String( nativByte, 0, nativByte.length, "UTF-8" );
			System.out.println("The Result is : " + nativStr);
			testICTCLAS50.ICTCLAS_Exit();
		} catch (Exception ex){
			System.out.println("Exception catched.");
		}
	}

}
