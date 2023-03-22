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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author aazañero
 */
public class prueba1 {
    public static void main(String[ ] arg) throws ClassNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = dateFormat.format(new Date());
        try {
            String token="";
        int cont=0;
        try{
            Connection cn = null;
            String bd="";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                bd = "jdbc:sqlserver://MAESTRO\\MAESTRO;database=fesepsa;user=sa;password=Fesepsa2012";
                //bd= "jdbc:sqlserver://PCFS017;database=fesepsa;user=sa;password=Fesepsa1234!";
                cn = DriverManager.getConnection(bd);
            java.sql.Statement sql = cn.createStatement();
            ResultSet rs = sql.executeQuery("SELECT token FROM AF_TOKEN_APISUNAT WHERE estado='A'");
            
            while(rs.next()){
                cont++;
                token=rs.getString(1);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        if(cont==0){
            token="No se encontraron datos";
        }else{
            if(cont>1){
                token="Registro duplicado";
            }
        }
            URL url = new URL("https://ruc.com.pe/api/v1/consultas");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            //String datos = "{\"token\":\"8d78b17f-4242-4fbf-8dfc-082285e4229f-b9ed83c4-02d5-48c2-a840-644694960c10\",\"comisiones_afp\":{\"periodo\":\"2022-02\"}}";
            String datos = "{\"token\":\"" + token + "\",\"tipo_cambio\": {\"moneda\":\"PEN\",\"fecha_inicio\":\"" + fecha + "\",\"fecha_fin\":\"" + fecha + "\"}}";
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
            System.out.println("EXEC [dbo].[AF_MANAGE_TCAMBIO] '4','" + fecha + "',''," + compra + "," + venta);
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println("EXEC [dbo].[AF_MANAGE_TCAMBIO] '5','" + fecha +"'");
        }
      }
}
