package testes;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.lang.Runtime;

import org.junit.jupiter.api.Test;

import ParseException;
import yal2jvm;


class YalParserTest {

    void runYal(String yalFilesPath, String filename, String[] yalProgArgs, String expectedResult, boolean printFlag){
        String fullPath = yalFilesPath + "/" + filename;



        String[] args = new String[]{fullPath + ".yal"};

			try {
				yal2jvm.main(args);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


        try {
            Runtime.getRuntime().exec("java -jar jasmin.jar " + fullPath + ".j");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader buffReader = null;
        BufferedWriter buffWriter = null;
        Process process = null;
        try {
            process = Runtime.getRuntime()
                    .exec("java " + filename);
            buffReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            buffWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        String output = "";

        try {
            for(String arg: yalProgArgs){
                buffWriter.write(arg + "\n");
                buffWriter.flush();
                buffWriter.newLine();
                try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            buffWriter.close();

            String line = "";

            while ((line = buffReader.readLine()) != null) {
                output += line + "\n";
            }

            buffReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        output = output.substring(0, output.length() - 1);

        assertEquals(expectedResult, output);

    }

    @Test
    void aval1() throws IOException {
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(progName);
        runYal("ex", progName, new String[]{},  "6", false);
    }

    @Test
    void aval2(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{},  "2\n2\n3", false);
    }

    @Test
    void aval3(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{},  "4\n2", false);
    }

    @Test
    void aval4(){ //io.read
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{"5", "1"},  "5", false); //Writing to process's input stream doesn't work
    }

    @Test
    void aval5(){ //Func Arguments no Initialised...
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{},  "9\n40", false);
    }

    @Test
    void aval6(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{},  "4", false);
    }

    @Test
    void aval7(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{},  "2", false);
    }

    @Test
    void max(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{},  "4\n6", false);
    }

    @Test
    void aval8(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        //runYal("examples/MyFirstYalExamples", progName, new String[]{-24, 5},  "a-24\n0", false);
        //runYal("examples/MyFirstYalExamples", progName, new String[]{3, 2},  "a3\n-8", false);

    }

    @Test
    void maxmin(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        //runYal("examples/MyFirstYalExamples", progName, new String[]{-24, 5},  "a0\na=0", false);

    }

    //##################ARRAYS#####################################
    @Test
    void array1(){
        String  progName = new Object(){}.getClass().getEnclosingMethod().getName();
        runYal("ex", progName, new String[]{},
                        "a: 0a: 1a: 2a: 3a: 4a: 5a: 6a: 7a: 8a: 9", false);
    }

    //###################EXTRA TESTS###############################
    @Test
    void constantRanges(){
        runYal("examples/ExtraExamples", "constantRanges", new String[]{},
                "5\n" +
                "-1\n" +
                "6\n" +
                "128\n" +
                "-129\n" +
                "32768\n" +
                "-32769",
                false);
    }
}