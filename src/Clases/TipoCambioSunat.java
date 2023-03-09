/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author aazañero
 */
public class TipoCambioSunat {
    public String devolver(String tipoconsulta,String fecha){
        try {
            URL url = new URL("https://ruc.com.pe/api/v1/consultas");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            //String datos = "{\"token\":\"8d78b17f-4242-4fbf-8dfc-082285e4229f-b9ed83c4-02d5-48c2-a840-644694960c10\",\"comisiones_afp\":{\"periodo\":\"2022-02\"}}";
            String datos = "{\"token\":\"8d78b17f-4242-4fbf-8dfc-082285e4229f-b9ed83c4-02d5-48c2-a840-644694960c10\",\"tipo_cambio\": {\"moneda\":\"PEN\",\"fecha_inicio\":\"" + fecha + "\",\"fecha_fin\":\"" + fecha + "\"}}";
            //String datos = "{\"token\": \"8d78b17f-4242-4fbf-8dfc-082285e4229f-b9ed83c4-02d5-48c2-a840-644694960c10\",\"ruc\": \"20100004080\"}";
            //System.out.println(datos);
            conexion.setRequestProperty("Content-Type","application/json");
            conexion.setDoOutput(true);
            OutputStream output = conexion.getOutputStream();
            output.write(datos.getBytes());
            output.flush();
            output.close();
            //System.out.println(conexion.getResponseCode());
            //System.out.println(conexion.getResponseMessage());
            //
            BufferedReader in = new BufferedReader(
            new InputStreamReader(conexion.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();
            //print in String
            //System.out.println(response.toString());
            //Read JSON response and print
            
            JSONObject myResponse = new JSONObject(response.toString());
            //System.out.println(myResponse.getString("condicion_de_domicilio"));
            
            Double compra=myResponse.getJSONArray("exchange_rates").getJSONObject(0).getDouble("compra");
            Double venta=myResponse.getJSONArray("exchange_rates").getJSONObject(0).getDouble("venta");
            //formato de 3 decimales
            DecimalFormatSymbols separador = new DecimalFormatSymbols();
            separador.setDecimalSeparator('.');
            DecimalFormat formato = new DecimalFormat("#.000",separador);
            
            if(tipoconsulta.equals("compra")){
                return formato.format(compra);
            }else if(tipoconsulta.equals("venta")){
                return formato.format(venta);
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}
