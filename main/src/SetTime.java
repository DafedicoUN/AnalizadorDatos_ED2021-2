import java.time.LocalDateTime;
import java.time.ZoneOffset;

// El objetivo de esta clase es sincronizar el tiempo del computador con el tiempo del arduino, para ello toma la base del tiempo del sistema
// y la envia al arduino, de acuerdo con el ejemplo de Arduino "TimeSerial"

public class SetTime 
{
    public static void SetTime() 
    {        
        String timeStamp = "T" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        PruebaEntrega.firstAvailableComPort.writeBytes(timeStamp.getBytes(), timeStamp.length());
        System.out.println("Time set to: " + timeStamp);
    }
}