
import ICTCLAS.I3S.AC.ICTCLAS50;
import java.util.*;
import java.io.*;

class TestMain {   

    public static void main(String[] args) {
        try {
            String sInput = "小时候经常听老人讲家乡的历史，从老祖宗一人落户到现在的子孙几千人，家乡土地也从蛮夷荒芜开垦出现在的良田万倾，一代一代的先祖流了多少汗水！";
            testICTCLAS_ParagraphProcess(sInput);

        } catch (Exception ex) {
        }
    }

    public static void testICTCLAS_ParagraphProcess(String sInput) {
        try {
            ICTCLAS50 testICTCLAS50 = new ICTCLAS50();
            String argu = ".";
            if (testICTCLAS50.ICTCLAS_Init(argu.getBytes("GB2312")) == false) {
                System.out.println("Init Fail!");
                return;
            }

            testICTCLAS50.ICTCLAS_SetPOSmap(3);

            byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 0);//ï¿½Ö´Ê´ï¿½ï¿½ï¿½
            System.out.println(nativeBytes.length);
            String nativeStr = new String(nativeBytes, 0, nativeBytes.length, "GB2312");
            System.out.println("nativeStr " + nativeStr);

            int nCount = 0;
            String usrdir = "userdict.txt"; 
            byte[] usrdirb = usrdir.getBytes();
            nCount = testICTCLAS50.ICTCLAS_ImportUserDictFile(usrdirb, 0);
            System.out.println("nCount" + nCount);
            nCount = 0;

            byte nativeBytes1[] = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 2, 0);
            System.out.println(nativeBytes1.length);
            String nativeStr1 = new String(nativeBytes1, 0, nativeBytes1.length, "GB2312");
            System.out.println("nativerStrl " + nativeStr1);
            testICTCLAS50.ICTCLAS_SaveTheUsrDic();
            testICTCLAS50.ICTCLAS_Exit();
        } catch (Exception ex) {
        }

    }

    public static void testICTCLAS_FileProcess() {
        try {
            ICTCLAS50 testICTCLAS50 = new ICTCLAS50();
            String argu = ".";
            if (testICTCLAS50.ICTCLAS_Init(argu.getBytes("GB2312")) == false) {
                System.out.println("Init Fail!");
                return;
            }

            String Inputfilename = "test.txt";
            byte[] Inputfilenameb = Inputfilename.getBytes();

            String Outputfilename = "test_result.txt";
            byte[] Outputfilenameb = Outputfilename.getBytes();

            testICTCLAS50.ICTCLAS_FileProcess(Inputfilenameb, 0, 1, Outputfilenameb);

            int nCount = 0;
            String usrdir = "userdict.txt"; 
            byte[] usrdirb = usrdir.getBytes();
            nCount = testICTCLAS50.ICTCLAS_ImportUserDictFile(usrdirb, 0);
            System.out.println("Count" + nCount);
            nCount = 0;

            String Outputfilename1 = "testing_result.txt";
            byte[] Outputfilenameb1 = Outputfilename1.getBytes();

            testICTCLAS50.ICTCLAS_FileProcess(Inputfilenameb, 0, 0, Outputfilenameb1);

        } catch (Exception ex) {
        }

    }

}
