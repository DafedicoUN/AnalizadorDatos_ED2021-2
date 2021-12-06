import com.fazecast.jSerialComm.*;

// Esta clase es importante, toma la clase "SerialportDatalistener" y la hereda, pero cambia en la herencia los metodos
// getListeningEvents() y SerialEvent() de manera que pueda recibir los bits del arduino sin problemas

public class MyComPortListener implements SerialPortDataListener
{
    // Para entender un poco este sistema se requiere saber como funciona el puerto serial a bajo nivel.
    // Primero se requiere que el puerto serial este abierto y conectado, lo que se define en el main de PruebaEntrega
    // Segundo se debe disparar un evento en el puerto serial, debido a que esperar permanentemente un dato consume maquina
    // Cuando se dispara el evento se establece un Buffer, de 8 o 9 bits (sin o con bit de paridad) que almacena el caracter en ASCII

    // Este metodo activa el evento de recepcion de datos, lo que implica que se esta recibiendo datos del Arduino
    @Override
    public int getListeningEvents() 
    { 
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; 
    }
    // Al Disparar el evento se sobreescrive este evento, esto permite que los datos en binario puedan convertirse en un Byte
    // Se llama a la clase "reformatBuffer" para reordenar los caracteres obtenidos y escribir una frase como string
    @Override
    public void serialEvent(SerialPortEvent event)
    {
        byte[] buffer = new byte[event.getSerialPort().bytesAvailable()];
        event.getSerialPort().readBytes(buffer, buffer.length);
        ReformatBuffer.parseByteArray(buffer);
    }
}