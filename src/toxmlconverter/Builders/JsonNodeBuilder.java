/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.Builders;

import toxmlconverter.Builders.NodeBuilder;
import toxmlconverter.Nodes.JsonNode;
import toxmlconverter.Nodes.INode;
import toxmlconverter.Nodes.Node;

/**
 *
 * @author Anton
 */
public class JsonNodeBuilder extends NodeBuilder{

    @Override
    public Node build() {
               
        Node jsonNode= new JsonNode(this);
        
        this.reset();

        return jsonNode;
     
    }
    
}
