/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author yoc91
 */
public class api_empleado {
    private String get(){
        String salida="";
        
        try {
            URL url = new URL("https://localhost:5001/api/Empleados");
            HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
            c_api.setRequestMethod("GET");
            c_api.setRequestProperty("Accept", "application/json");
            if(c_api.getResponseCode()==200){
              InputStreamReader entrada = new InputStreamReader(c_api.getInputStream());
              BufferedReader lectura = new BufferedReader(entrada);
              salida = lectura.readLine();
            }else{
            salida = "";
                //c_api.getResponseCode() Muestra la línea del error 
            System.out.println("No se puede conectar a la api : " + c_api.getResponseCode());
            }
            
            c_api.disconnect();
            
        } catch (Exception ex) {
            System.out.println("Error api: " + ex.getMessage());
        }
        
        return salida;
    }
    
    //Metodo Leer
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        String encabezado[] ={"idEmpleados","nombre","apellido","direccion","telefono","idPuesto","dpi","fecha_nacimiento","fecha_ingreso_registro"};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[9];
        JSONArray arreglo = new JSONArray(get());
        for (int indice = 0;indice < arreglo.length();indice++){
            JSONObject atributo = arreglo.getJSONObject(indice);
           datos[0] = String.valueOf(atributo.getInt("idEmpleados")) ;
           datos[1] = atributo.getString("nombre");
           datos[2] = atributo.getString("apellido");
           datos[3] = atributo.getString("direccion");
           datos[4] = atributo.getString("telefono");
           datos[5] = String.valueOf(atributo.getString("idPuesto"));
           datos[6] = atributo.getString("dpi");
           datos[7] = atributo.getString("fecha_nacimiento");
           datos[8] = atributo.getString("fecha_ingreso_registro");
           tabla.addRow(datos);
        }
    }catch(JSONException ex){
    System.out.println("Error tabla:" + ex.getMessage());
    }
    return tabla;
    }
    
    public int  post(){
         int salida = 0;
         try{
          URL url = new URL("https://localhost:5001/api/Empleados");  
          HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
          c_api.setRequestMethod("POST");
          c_api.setRequestProperty("Content-Type", "application/json; utf-8");
         // c_api.setRequestProperty("Accept", "application/json");
          c_api.setDoOutput(true);
          String jsonS = "{\"nit\":\"1234\",\n" +
            "\"nombres\":\"Jose Jose\",\n" +
            "\"apellidos\":\"Lopez Lopez\",\n" +
            "\"direccion\":\"Direccion\",\n" +
             "\"telefono\":\"555\",\n" +
            "\"fecha_nacimiento\":\"1995-01-01\"}";
         OutputStream os = c_api.getOutputStream();
        os.write(jsonS.getBytes());
        os.flush();
          
          if (c_api.getResponseCode()==200){
             
 
                salida = 1;
        
        
              
          }else{
            
              System.out.println("No se puede conectar a la api : " + c_api.getResponseCode());
          
          }
          
          c_api.disconnect();
            
        }catch(IOException ex){
     
            System.out.println("Error api:" + ex.getMessage());
        }
         return salida;
    
    }
    
}
