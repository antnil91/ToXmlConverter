/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.Builders;

import toxmlconverter.Nodes.INode;
import toxmlconverter.Nodes.XmlElement;

/**
 *
 * @author Anton
 */
public class XmlElementBuilder extends NodeBuilder {

    
    @Override
    public INode build() {
        
        XmlElement el= new XmlElement(this);
        
        this.reset();

        return el;
     
    }

}
