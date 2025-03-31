/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.Nodes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import toxmlconverter.Builders.NodeBuilder;

/**
 *
 * @author Anton
 */
public abstract class Node implements INode{
    
    
    private INode parent = null;
    private String nodeName="";
    private String value="";
    private Queue<INode> children = new LinkedList();
    private HashSet<String> appendableIndexes = new HashSet();    
    private boolean isOpen = false;
    private String nodeIndex;


    
    public Node(NodeBuilder builder){
        
        this.nodeName=builder.getNodeName();
        this.children = builder.getChildren();
        this.appendableIndexes = builder.getAppendableIndexes();
        this.value = builder.getValue();
        this.parent = builder.getParent();
        this.nodeIndex = builder.getNodeindex();
  
    }
    
    
 
    public String getNodeIndex(){
        return this.nodeIndex;
    }
    

     public boolean hasChildren(){
         return !this.children.isEmpty();
     }

    public String getNodeName() {
        return nodeName;
    }

    public String getValue() {
        return value;
    }
    
    public INode getParent(){
        return this.parent;
    }
    
    public boolean isOpen(){
        return this.isOpen;
    }



    public void setOpen(BufferedWriter bw){
        this.writeOpenNode(bw);
        this.isOpen=true;
    }
     
    
    public void setClosed(BufferedWriter bw){
         this.writeValue(bw);
         this.writeChildren(bw);
         this.closeNode(bw);
         this.isOpen=false;
    }
    
    @Override
    public void appendChild(INode el) {
        this.children.add(el);
    }

    
    @Override
    public boolean isValidChild(String elementIndex) {
        
        if(this.appendableIndexes!=null){
            return this.appendableIndexes.contains(elementIndex);
        } else {
            return false;
        }
       
    }
    
    
    @Override
    public void writeChildren(BufferedWriter bw) {
        
            while(!children.isEmpty()){
                
                INode child = children.poll();
                
                child.writeOpenNode(bw);
                child.writeValue(bw);
                child.writeChildren(bw);
                child.closeNode(bw);
                
            }
            
    }
    
}
