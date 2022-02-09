// Programa de Prueba ARDUINO - Estructuras de datos 2021-2
// Juan Pablo Carrillo Acero, Cristian Chois Amaya, Daniel Fernando Díaz Coy
// 
// Puede aplicarse a cualquier arduino con los puertos I2C definidos en SDA y SCL
// Se usará como ejemplo del video el ESP32 - Widora Air v6 + Acelerometro MPU6050

// Librerias, propias de Arduino y requeridas para el ejemplo
#include <Wire.h>

// IMPORTANTE: Cada sensor posee su libreria, esto facilita mucho la programacion del arduino
#include <Adafruit_Sensor.h>  //requerido para los sensores
#include <Adafruit_MPU6050.h> //requerido para el acelerometro
#include <Adafruit_BMP085.h>  //requerido para el barometro


// Variables definidas para los cálculos
double ax, ay, az, at, giro_x, giro_y;
long inicio, actual, conteo;

// Instanciamiento de las librerias

Adafruit_MPU6050 mpu;
Adafruit_BMP085 bmp;

void setup() {
  // Velocidad en comunicacion serial, esta es la mas rápida universalmente aunque existen aun mas rapidas (BLE alcanza 8Mb/s)
  Serial.begin(115200);
  // Definicion de los pines SDA y SCL del arduino, cada arduino puede tener o no estos pines definidos
  Wire.begin(21,22);
    // Codigo de prueba si hay fallo del sensor
  if (!mpu.begin()) {
    Serial.println("Error al encontrar el sensor MPU6050");
    while (1) {
      delay(10);
    }
  }
  //Serial.println("Sensor MPU6050 Encontrado!");

  if (!bmp.begin()) {
  Serial.println("Could not find a valid BMP085/BMP180 sensor, check wiring!");
  while (1) {}
  }

  // Define el rango de aceleracion del sensor 2, 4, 8, 16 G
  mpu.setAccelerometerRange(MPU6050_RANGE_2_G);
  // Define el rango de giro del sensor 250,500,1000,2000 grados/seg.
  mpu.setGyroRange(MPU6050_RANGE_500_DEG);
  // Define el filtro de ruido del sensor 5,10,21,44,94,184,260 Hz (se deja tal cual el ejemplo)
  mpu.setFilterBandwidth(MPU6050_BAND_21_HZ);
  delay(1000);

  // Inicializacion de las variables de conteo
  inicio=millis();
  conteo=0;
}

void loop() {

  sensors_event_t a, g, temp;
  mpu.getEvent(&a, &g, &temp);

  // Debido al tiempo de prueba del video solo se enviaran 10 datos

  if(conteo<25){
    
    actual=millis()-inicio;
    // Se almacenan las aceleraciones en las variables

    ax=a.acceleration.x;
    ay=a.acceleration.y;
    az=a.acceleration.z;

    Serial.print("t = ");
    Serial.print(actual);
    Serial.print(" , ");
    
    Serial.print("ax = ");
    Serial.print(ax);
    Serial.print(" , ");
    Serial.print("ay = ");
    Serial.print(ay);
    Serial.print(" , ");
    Serial.print("az = ");
    Serial.print(az);
    Serial.print(" , ");

    Serial.print("Temp = ");
    Serial.print(bmp.readTemperature());
    Serial.print(" , ");
    Serial.print("Pbar = ");
    Serial.print(bmp.readPressure());
    Serial.print(" , ");
    Serial.print("Altitud = ");
    Serial.print(bmp.readAltitude(103000));
    Serial.print(" , ");
    
    Serial.println(conteo);
    conteo++;
    delay(200);
  }
  else
  {
    // Esto permite un ciclo continuo, 25 datos y una pausa de 5 segundos
    delay(5000);
    Serial.println("");
    Serial.println("");
    conteo=0;
  }
}
