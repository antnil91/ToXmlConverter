/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.Nodes;

import java.io.BufferedWriter;
import java.io.IOException;
import toxmlconverter.Builders.NodeBuilder;


/**
 *
 * @author Anton
 */
public class XmlElement extends Node {

    public XmlElement(NodeBuilder builder) {
        super(builder);
    }


    @Override
    public void writeOpenNode(BufferedWriter bw) {
        try {
            bw.write(String.format("<%s>", this.getNodeName()));
            bw.flush();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    
    @Override
    public void writeValue(BufferedWriter bw) {
        try {
            bw.write(this.getValue());
                  bw.flush();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    
    @Override
    public void writeCloseNode(BufferedWriter bw) {
        try {
            bw.write(String.format("</%s>", this.getNodeName()));
                  bw.flush();
        } catch (IOException ex) {
            
            ex.printStackTrace();
        }
    }

}
