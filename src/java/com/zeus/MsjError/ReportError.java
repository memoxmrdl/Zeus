/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.MsjError;

/**
 *
 * @author Guillermo
 */
public class ReportError {
    public String ReturnError(String message) {

        message = message.replaceAll("[\n\r\"]", " ");
        
        if(this.searchStr("EXECUTE PROCEDURE Z_GET_ART_IMPTO", message)) {
           return "Procedure unknown EXECUTE PROCEDURE Z_GET_ART_IMPTO";
        } 
        
        message = message.replace("[", "");
        message = message.replace("]", "");
        message = message.replace(":", "");
        message = message.replace(",", "");                    

        return "{\"error\":\""+message.replaceAll("[\n\r\"]", " ")+"\"}";        
    }
    
    public boolean searchStr(String search, String str) {
        if(!str.replaceAll(search,"").equals(str)) {
            return true;
        }
        return false;
    }
}
