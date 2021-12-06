// Ejemplo de Prueba para el video  - 1ra entrega del Proyecto

// Juan Pablo Carrillo Acero, Cristian Chois Amaya, Daniel Fernando Díaz Coy

// Estructuras de datos - Grupo 3 - Equipo I - 2021-3

// Librerias importadas
// Es IMPORTANTE usar esta libreria y que este bien insertada en el IDE para lograr la comunicacion serial
import com.fazecast.jSerialComm.SerialPort;

// Para ejecutar se requiere un archivo de ejemplo que manda via serial un "Datestamp"

public class PruebaEntrega
{
    // Se declara el objeto Serialport, que es la base de la comunicacion serial, 
    // requiere la libreria insertada
    public static SerialPort firstAvailableComPort;

    public static void main(String[] args)
    {
        // Se inserta en una lista todos los puertos disponibles de comunicacion abiertos
        SerialPort[] allAvailableComPorts = SerialPort.getCommPorts();
        // Imprime todos los puertos seriales, la descripcion es la propia del driver
        for(SerialPort eachComPort:allAvailableComPorts)
        {
            System.out.println("Lista de puertos disponibles: " + eachComPort.getDescriptivePortName());
        }

        // Generalmente al conectar un arduino el puerto COM # es el unico que se abre, por lo que, en caso de que halla multiples puertos
        // se toma el primero de ellos

        firstAvailableComPort = allAvailableComPorts[0];

        // Se abre el puerto de comunicacion, todos los puertos estan cerrados o no disponibles y para establecer comunicacion con ellos
        // se debe solicitar la apertura

        firstAvailableComPort.openPort();
        System.out.println("Puerto Abierto para comunicacion: " + firstAvailableComPort.getDescriptivePortName());

        // Se crea una instancia de la clase "MyComPortListener" para alterar ligeramente la clase SerialPortDataListener() de la libreria
        MyComPortListener listenerObject = new MyComPortListener();
        
        // Crea el evento permanente de escucha de serial
        firstAvailableComPort.addDataListener(listenerObject);
    }
}

