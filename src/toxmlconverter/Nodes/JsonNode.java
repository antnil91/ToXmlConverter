/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.Nodes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import toxmlconverter.Builders.NodeBuilder;

/**
 *
 * @author Anton
 */
public class JsonNode extends Node {

    public JsonNode(NodeBuilder builder) {
        super(builder);
    }

    @Override
    public void writeOpenNode(BufferedWriter bw) {
        try {
        
            if(this.getParent()== null){
                bw.write("{");
            }
            
            if(this.getValue().equals("")){
                
                if(!this.hasChildren()){
                    bw.write(String.format("\"%s\": [", this.getNodeName()));       
                } else {
                    bw.write(String.format("\"%s\": {", this.getNodeName()));       
                }
                
        
            } 
            
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    @Override
    public void writeValue(BufferedWriter bw) {
        
        try {
            
            
            if(!this.getValue().equals("")){

                bw.write(String.format("\"%s\": ", this.getNodeName()));
                bw.write(String.format("\"%s\"", this.getValue()));
                
               if(this.getParent().hasChildren()) {
                  bw.write(",");
               }
                
           
      
            } 
            
        } catch (IOException ex) {
            
           ex.printStackTrace();
           
        }
        
    }

    @Override
    public void writeCloseNode(BufferedWriter bw) {
        try {
            
      
            if(this.getParent()== null){
                bw.write("]");
            }  
            

            if(this.getValue().equals("")){

                bw.write("}");

            } 
            
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
     
    
}


//