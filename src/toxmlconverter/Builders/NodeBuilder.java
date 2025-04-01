/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.Builders;

import toxmlconverter.Nodes.INode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import toxmlconverter.Nodes.Node;


/**
 *
 * @author Anton
 */
public abstract class NodeBuilder {

        private INode parent = null;
        private String nodeName="";
        private String value="";
        private Queue<INode> children = new LinkedList();
        private HashSet<String> appendableIndexes = new HashSet();   
        private String nodeIndex;


        public INode getParent(){
            return this.parent;
        }
        
        public String getNodeName() {
            return nodeName;
        }

        public String getValue() {
            return value;
        }

        public Queue<INode> getChildren() {
            return children;
        }

        public HashSet<String> getAppendableIndexes() {
            return appendableIndexes;
        }
        
        public String getNodeindex(){
            return this.nodeIndex;
        }
    
        public NodeBuilder setName(String name) {
            
            this.nodeName = name;
            return this;
            
        }

        public NodeBuilder setValue(String value) {
            
            this.value = value;
            return this;
            
        }

        public NodeBuilder setChildren(Queue<INode> children) {
            
            this.children = children;
            return this;
            
        }
        
        public NodeBuilder appendChild(Node el) {
            
            this.children.add(el);
            return this;
            
        }
        
        public NodeBuilder setAppendableIndexes(HashSet<String>  appendableIndexes) {
            
            this.appendableIndexes = appendableIndexes;
            return this;
            
        }
        
        public NodeBuilder setParent(INode parent){
            this.parent=parent;
            return this;
        }
        
        public NodeBuilder setNodeIndex(String nodeIndex){
            this.nodeIndex=nodeIndex;
            return this;
        }
        
  
        public abstract Node build();
        
        public void reset(){
            
            parent = null;
            nodeName="";
            value="";
            children= (Queue<INode>) new LinkedList();
            appendableIndexes = new HashSet();
            nodeIndex="";
        }
    
}
