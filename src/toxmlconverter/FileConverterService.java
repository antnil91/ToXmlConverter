/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter;

import toxmlconverter.Nodes.INode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Anton
 */
public class FileConverterService {
    
    

    private FileFormat outputFormat;
    private final char DELMITTER = '|';

    public FileConverterService(FileFormat outputFormat){
        
        this.outputFormat = outputFormat;
        
    }
    
    public void convert(String fileInPath, String OutPath) throws FileNotFoundException, IOException{ 
        
        FileReader fr = new FileReader(fileInPath);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(new FileWriter(OutPath));
        
        String cols[];
        String nodeIndex;
        String[] children;

        String strLine;
       
        INode parent = NodeFactory.getNodeBuilder(outputFormat).setName("people").setAppendableIndexes(new HashSet<>(Arrays.asList("P"))).build();  //Definiera root-noden. 
        INode currNode = null;
        INode prevNode = parent;
        
        parent.setOpen(bw);
     

         while (br.ready()) {
            
            strLine = br.readLine();  //
            cols = strLine.split("\\" + DELMITTER);  
            nodeIndex = cols[0];  
            children = Arrays.copyOfRange(cols, 1, cols.length);  
            
            
            if(prevNode.isValidChild(nodeIndex)){

               parent = prevNode;
               
            } else {

                parent = prevNode.getParent();
                
                while(!parent.isValidChild(nodeIndex)){
                      parent = parent.getParent();
                }
                
                
                if(parent.getParent()==null){
                        parent.setClosed(bw);
                }
            
            }
            

            currNode = NodeFactory.createNode(nodeIndex, children, this.outputFormat, parent);

            
            if(parent.isValidChild(nodeIndex)){
                parent.appendChild(currNode);
            } 
            
          
            prevNode = currNode;
            
            bw.flush();
            
        }
        bw.flush();
        
        bw.close();
        br.close();
        
    }
    

    
}

