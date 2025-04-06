
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import toxmlconverter.FileConverterService;
import toxmlconverter.FileFormat;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anton
 */
public class TestBigFILE {
    
    
   public static void main(String args[]) throws IOException{
       
       
       
        HeapSpaceTester.loggTheHeapspace();
       
        String bigFileIn="C:/Develop/ToXmlConverter/data/bigFileIn.txt";
        String fileOut="c:/Develop/ToXmlConverter/data/bigFileOut.xml";

        BufferedWriter bw = new BufferedWriter(new FileWriter(bigFileIn));
        
        
        
        for(int i = 0; i < 10000000; i++){
        
            bw.write(""+
            "P|Carl Gustaf|Bernadotte\n" +
            "T|0768-101801|08-101801\n" +
            "A|Drottningholms slott|Stockholm|10001\n" +
            "F|Victoria|1977\n" +
            "A|Haga slott|Stoclkholm|10002\n" +
            "F|Carl Philip|1979\n" +
            "T|0768-101802|08-101802\n" +
            "P|Barack|Obama\n"+
            "P|Anton\n" +
            "F|Birgitta|1994\n" +
            "A|Bodengatan 11| Stockholm | 911 41\n" +
            "UA|Frankrike|Parisgatan24|Paris| 101 00\n" +
            "T|070-09 88 12|00-00000\n");
        
        }
       
        bw.flush();
        bw.close();
        
        
        FileConverterService service = new FileConverterService(FileFormat.XML);
        service.convert(bigFileIn, fileOut); 
        
    
        

       
       
   }
    
}
