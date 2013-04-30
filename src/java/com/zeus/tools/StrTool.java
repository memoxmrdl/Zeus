/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.tools;

 import java.lang.*;
 import java.util.regex.*;
/**
 *
 * @author Guillermo
 */
public class StrTool {
    
    public String StrEvalJson(String str) {       
        
        str = str.replace("\"", "");
        str = str.replace("'", ""); 

        if(str.length() <= 2) { return null; }
        if(str != null && str.length() >= 1) {
            str = str.replace(":", ":\"");
            str = str.replace(",", "\",");
            str = str.replace("\"/", "/");
            str = str.replace("}", "\"}");
            
            str = str.replace("\"\"", "\"\"");
        } else {
            return null;
        }
        return str;
    }

    
}
