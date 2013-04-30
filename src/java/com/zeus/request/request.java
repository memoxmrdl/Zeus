/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Guillermo
 */
public class request {
    
    public String post(String request, String datos, String protocolo) {
        String responce = "";
        OutputStreamWriter wr = null;
        BufferedReader rd = null;

        try {
            URL url = new URL(request);
            if (protocolo.equals("HTTPS")) {
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                //Escribir los parametros en el mensaje
                conn.setDoOutput(true);
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(datos);
                wr.flush();
                //Recibir respuesta
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                URLConnection conn = url.openConnection();
                //Escribir los parametros en el mensaje
                conn.setDoOutput(true);
                wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(datos);
                wr.flush();
                //Recibir respuesta
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }

            String line;
            while ((line = rd.readLine()) != null) {
                //Process line...
                responce += line;
            }
         } catch (Exception e) {         
         } finally {
            try {
                if (wr != null) {
                    wr.close();
                }
                if (rd != null) {
                    rd.close();
                }
            } catch (IOException ex) {
                System.out.println("Exception al cerrar el lector o el escritor");
            }
        }
        return responce;
    }  
    
}
