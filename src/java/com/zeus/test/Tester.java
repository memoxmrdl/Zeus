/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.test;

import com.zeus.classObj.*;

/**
 *
 * @author Guillermo
 */
public class Tester {
    public static void main(String[] args) {
       callDaoMethod call = new callDaoMethod();
       
       String conn, result, params;
       
       conn = "{server:localhost,db:C:/AD2000.FDB,username:SYSDBA,pwd:masterkey}";
       params = "{cliente_id: 331}";
       result = null;
       
       try {
           result = call.GetDirsCliente(params, conn);
       } catch(Exception e) {
           System.out.println(e.getMessage());
       }
       
       System.out.println(result);
    }       
}
