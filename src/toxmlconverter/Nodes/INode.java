/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package toxmlconverter.Nodes;

import java.io.BufferedWriter;

/**
 *
 * @author Anton
 */
public interface INode {
    
    
    public void writeOpenNode(BufferedWriter bw);
    
    public void writeValue(BufferedWriter bw);
    
    public void writeChildren(BufferedWriter bw);
    
    public void closeNode(BufferedWriter bw);
    
    public void appendChild(INode el);
    
    public boolean isValidChild(String elementIndex);  
    
    public boolean hasChildren();
    
    public INode getParent();
    
    public String getNodeIndex();
    
    public void setOpen(BufferedWriter bw);
    public void setClosed(BufferedWriter bw);
    
      public boolean isOpen();
    
}
