/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter;

import toxmlconverter.Builders.JsonNodeBuilder;
import toxmlconverter.Builders.NodeBuilder;
import toxmlconverter.Builders.XmlElementBuilder;
import toxmlconverter.Nodes.INode;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import static toxmlconverter.FileFormat.JSON;
import static toxmlconverter.FileFormat.XML;

/**
 *
 * @author Anton
 */


public class NodeFactory {
  
    
 
  private static final HashMap<String, String> nodeNameIndex = new HashMap<>(Map.of(
          
        "P", "person",
        "A", "address",
        "T", "phone",
        "F", "family",
        
        "UA", "utlandsadress"
          
    ));
  
   private static final HashMap<String, String[]> colIndexToNameMapper = new HashMap<>(Map.of(
          
        "P", new String[]{"förnamn", "efternamn"},
        "T", new String[]{"mobilnummer", "fastnätsnummer"},
        "A", new String[]{"gata", "stad", "postnummer"},
        "F", new String[]{"namn", "födelseår"},
        
        "UA",new String[]{"Land", "gata", "stad","postnummer"}
           
    ));
   
   
    private static final HashMap<String, HashSet<String>> appendableIndexexMapper = new HashMap<>(Map.of(
            
        "P", new HashSet<>(Arrays.asList("T", "A", "F")),
        "F", new HashSet<>(Arrays.asList("T", "A")),
        "A", new HashSet<>(Arrays.asList("UA"))

    ));
  
    
    public static INode createNode(String nodeIndex, String[] cols, FileFormat outputFormat, INode parent) throws IOException {
        
        NodeBuilder nodeBuilder = getNodeBuilder(outputFormat);
                
        
        String nodeName = nodeNameIndex.get(nodeIndex);
        String[] childNames = colIndexToNameMapper.get(nodeIndex);
        HashSet<String> appendableIndexes = appendableIndexexMapper.get(nodeIndex);

        INode node = nodeBuilder.setName(nodeName).setAppendableIndexes(appendableIndexes).setParent(parent).build();
           
        for(int i=0; i < cols.length; i++) {
            
            NodeBuilder childBuiler = getNodeBuilder(outputFormat);
            
            INode child = childBuiler.setName(childNames[i]).setValue(cols[i]).setParent(node).setNodeIndex(nodeIndex).build();
            
            node.appendChild(child);

        }
        
       return node;
        
    }
    
    public static NodeBuilder getNodeBuilder(FileFormat outputFormat) throws IOException{
        
        NodeBuilder nodeBuilder;
                
        switch(outputFormat){
            
            case XML:
                nodeBuilder = new XmlElementBuilder();
                break;
            case JSON:
                nodeBuilder = new JsonNodeBuilder();
                break;
            default:
                
                throw new IOException ("Fileformat not supported yet.");
                
        }
        
        return nodeBuilder;
        
    }
     
 
    
    
    
}
