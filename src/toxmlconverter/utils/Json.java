/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toxmlconverter.utils;

/**
 *
 * @author Anton
 */
public class Json {
    
        
    public static String removeJsonReservedChars(String str){

        str = str.replace("\\", "\\\\");  // Replaces backslash \ with \\
        str = str.replace("\"", "\\\"");  // Replaces " with \"
        str = str.replace("\n", "\\n");   // Replaces newline with \n
        str = str.replace("\r", "\\r");   // Replaces carriage return with \r
        str = str.replace("\t", "\\t");   // Replaces tab with \t
        str = str.replace("\b", "\\b");   // Replaces backspace with \b
        str = str.replace("\f", "\\f");   // Replaces form feed with \f
        str = str.replace("/", "\\/");   // Replaces / with \/
        
        return str;

    }

    
}
