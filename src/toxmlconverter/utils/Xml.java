/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.utils;

/**
 *
 * @author Anton
 */
public class Xml {
    
    
    public static String removeXmlReservedChars(String str){
        
        str = str.replace("&", "&amp;");  // Replaces & with &amp;
        str = str.replace("<", "&lt;");   // Replaces < with &lt;
        str = str.replace(">", "&gt;");   // Replaces > with &gt;
        str = str.replace("\"", "&quot;"); // Replaces " with &quot;
        str = str.replace("'", "&apos;"); // Replaces ' with &apos;
        
        return str;

    }
}
