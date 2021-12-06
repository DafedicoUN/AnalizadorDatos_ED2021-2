// Reformat Buffer es la clase que exporta los datos y los imprime en consola, 
// se debe tener en cuenta que el "retorno de carro" tambien es un caracter ASCII (binario 00001101, HEX 0D)


public class ReformatBuffer
{
    public String outputString;
    
    static int cutoffASCII = 10; // ASCII code of the character used for cut-off between received messages
    static String bufferReadToString = ""; // empty, but not null
            
    public static void parseByteArray(byte[] readBuffer) {
        
        String s = new String(readBuffer);
        bufferReadToString = bufferReadToString.concat(s);
        
        SetTime tiempo = new SetTime();

        if((bufferReadToString.indexOf(cutoffASCII) + 1) > 0) 
        {
                    
            String outputString = bufferReadToString.substring(0, bufferReadToString.indexOf(cutoffASCII) + 1);
            bufferReadToString = bufferReadToString.substring(bufferReadToString.indexOf(cutoffASCII) + 1); // adjust as needed to accommodate the CRLF convention ("\n\r"), ASCII 10 & 13
                    
            System.out.print(outputString);

            if(outputString.contains("sync")) 
            {
                tiempo.SetTime();
            }  
        }
    }
}