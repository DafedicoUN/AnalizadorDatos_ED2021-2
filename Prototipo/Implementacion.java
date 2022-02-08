// Ejemplo de Prueba para el video  - Entrega Final del Proyecto

// Juan Pablo Carrillo Acero, Cristian Chois Amaya, Daniel Fernando Díaz Coy

// Estructuras de datos - Grupo 3 - Equipo I - 2021-3

package prototipo;

// Librerias importadas
import java.nio.charset.StandardCharsets;

// Es IMPORTANTE usar esta libreria y que este bien insertada en el IDE para lograr la comunicacion serial
import com.fazecast.jSerialComm.SerialPort;


// A diferencia de la primera entrega, se ha programado el arduino para que mande 10000 bloques de datos 
// tomados de un sensor real (para mostrar que efectivamente la comunicacion serial existe)

public class Implementacion
{
    public static SerialPort Puerto;
    public static void main(String[] args)
    {
        System.out.println("");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Demostración Implementacion proyecto Estructuras de Datos");
        System.out.println("Grupo 3-I : Juan Pablo Carrillo, Cristian Chois y Daniel Díaz");
        System.out.println("---------------------------------------------------------------");
        System.out.println("");
        
        // Se prevee una configuracion rapida del puerto acorde con lo configurado en el arduino
        connect();
        
        // Se realiza una primera captura de datos en una lista 
    }

    public static void connect()
    {
        System.out.println("Iniciando Conexion serial con el dispositivo exterior...");
        // Se inserta en una lista todos los puertos disponibles de comunicacion abiertos
        SerialPort[] allAvailableComPorts = SerialPort.getCommPorts();
        // Imprime todos los puertos seriales, la descripcion es la propia del driver
        for(SerialPort eachComPort:allAvailableComPorts)
        {
            System.out.println("Lista de puertos disponibles: " + eachComPort.getDescriptivePortName());
        }
        // Generalmente al conectar un arduino el puerto COM # es el unico que se abre, por lo que, en caso de que halla multiples puertos
        // se toma el primero de ellos
        Puerto = allAvailableComPorts[0];
        // Se abre el puerto de comunicacion, todos los puertos estan cerrados o no disponibles y para establecer comunicacion con ellos
        // se debe solicitar la apertura
        
        Puerto.openPort();
        System.out.println("Puerto Abierto para comunicacion: " + Puerto.getDescriptivePortName());

        Puerto.setComPortParameters(112500, 8, 1,0);
        Puerto.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 0, 0);
        try {
            while (true)
            {
               while (Puerto.bytesAvailable() == 0)
                  Thread.sleep(20);
         
               byte[] readBuffer = new byte[Puerto.bytesAvailable()];
               int numRead = Puerto.readBytes(readBuffer, readBuffer.length);
               String datos = new String(readBuffer, StandardCharsets.UTF_8);
               
               //System.out.println("Read " + numRead + " bytes.");

               System.out.print(datos);
            }
         } catch (Exception e) { e.printStackTrace(); }
         Puerto.closePort();
    }
    public static void Captura()
    {
        return;
    }
}
