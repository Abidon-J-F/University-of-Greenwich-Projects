//Inspiration based on https://howtomechatronics.com/projects/arduino-security-alarm-system-project/ project

#include <LiquidCrystal.h> // includes the LiquidCrystal Library 
#include <Keypad.h> // includes the Keypad Library

#define buzzer 8

long duration;
int distanceCm, distance, initialDistance, currentDistance, i;
int screenOffMsg = 0;
String password = "1111";
String tempPassword;
boolean activated = false; // State of the alarm
boolean isActivated;
boolean activateAlarm = false;
boolean alarmActivated = false;
boolean enteredPassword; // State of the entered password to stop the alarm
boolean key = true;
const int trigPin = 9;
const int echoPin = 10;
const byte ROWS = 4; //four rows
const byte COLS = 4; //four columns
int avrReset = 51;
int avrAlarm = 50;

char keypressed;

//define the cymbols on the buttons of the keypads
char keyMap[ROWS][COLS] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte rowPins[ROWS] = {14, 15, 16, 17}; //Row pinouts of the keypad
byte colPins[COLS] = {18, 19, 20, 21}; //Column pinouts of the keypad
Keypad myKeypad = Keypad( makeKeymap(keyMap), rowPins, colPins, ROWS, COLS);
LiquidCrystal lcd(1, 2, 4, 5, 6, 7); // Creates an LC object. Parameters: (rs, enable, d4, d5, d6, d7)

void setup() {
  lcd.begin(16, 2);
  pinMode(buzzer, OUTPUT); // Set buzzer as an output
  pinMode(trigPin, OUTPUT); // Sets the trigPin as an Output
  pinMode(echoPin, INPUT); // Sets the echoPin as an Input
  pinMode(avrReset, OUTPUT); // avrReset is the Output that makes the LEDs stop
  digitalWrite(avrReset, HIGH); // Set value to 0
  pinMode(avrAlarm, OUTPUT); // avrAlarm is the Output that makes the LEDs blink
  digitalWrite(avrAlarm, HIGH);

}

void loop() {

  if (activateAlarm) { // Checks if the user activated the alarm
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("Alarm will be");
    lcd.setCursor(0, 1);
    lcd.print("activated in");

    int countdown = 5; // 5 seconds count down before activating the alarm
    while (countdown != 0) {
      lcd.setCursor(13, 1);
      lcd.print(countdown);
      countdown--;
      tone(buzzer, 700, 100);
      delay(1000);
    }
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("Alarm Activated!");
    initialDistance = getDistance(); // Gets an initial distance to compare it to any distance difference created by a movement
    activateAlarm = false;
    alarmActivated = true; // Sets the alarm off
  }

  if (alarmActivated == true) {
    currentDistance = getDistance() + 5; // Gets a new distance + a small variation
    if ( currentDistance < initialDistance) { // Checks is the new distance is less than the initial one
      tone(buzzer, 1000); // Send 1KHz sound signal
      digitalWrite(avrReset, HIGH);
      digitalWrite(avrAlarm, LOW); //Set value to 1
      lcd.clear();
      enterPassword(); // Call the enterPassword method
    }
  }
  if (!alarmActivated) { // If the alarm is not activated it shows the main screen
    if (screenOffMsg == 0 ) { // Main screen
      digitalWrite(avrAlarm, HIGH);
      digitalWrite(avrReset, LOW);
      //digitalWrite(avrReset, HIGH);
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print("A - Activate");
      lcd.setCursor(0, 1);
      lcd.print("B - Monitor");
      screenOffMsg = 1;
    }
    keypressed = myKeypad.getKey(); // Gets a key from the keypad
    if (keypressed == 'A') {      //If A is pressed, activate the alarm
      tone(buzzer, 1000, 200);
      activateAlarm = true;
    }

    else if (keypressed == 'B') {
      lcd.clear();
      tone(buzzer, 2000, 100);
      while (key != NO_KEY) {
        digitalWrite(trigPin, LOW);
        delayMicroseconds(2);
        digitalWrite(trigPin, HIGH);
        delayMicroseconds(10);
        digitalWrite(trigPin, LOW);
        duration = pulseIn(echoPin, HIGH); // Gets the duration it takes for the radar to detect an object
        distanceCm = duration * 0.034 / 2; // Calculates the distance in centimeters

        if (distanceCm > 27) // Maximum distance the radar can detect is 30 cm
        {
          lcd.clear();
          lcd.setCursor(0, 0);
          lcd.print("Out of Range");
        }
        else
        {
          if (distanceCm < 0.9)
          {
            lcd.clear();
            lcd.setCursor(0, 0);
            lcd.print("Distance: 0 cm");
          }
          else
          {
            lcd.setCursor(0, 0); // Sets the location at which subsequent text written to the LCD will be displayed
            lcd.print("Distance: "); // Prints string "Distance" on the LCD
            lcd.print(distanceCm); // Prints the distance value from the sensor
            lcd.print("  cm");
            delay(650);
          }
        }
      }
    }
  }
}


void enterPassword() { // Method for checking if the entered password matches the system's password
  int k = 5;
  tempPassword = "";
  activated = true;
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print(" *** ALARM *** ");
  lcd.setCursor(0, 1);
  lcd.print("Code>");
  while (activated) {
    keypressed = myKeypad.getKey();
    if (keypressed != NO_KEY) {
      if (keypressed == '0' || keypressed == '1' || keypressed == '2' || keypressed == '3' ||
          keypressed == '4' || keypressed == '5' || keypressed == '6' || keypressed == '7' ||
          keypressed == '8' || keypressed == '9' ) {
        tempPassword += keypressed;
        lcd.setCursor(k, 1);
        lcd.print("*");
        k++;
      }
    }

    if (k > 9 || keypressed == '#') { // Setting # as clear password button
      tempPassword = "";
      k = 5;
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print(" *** ALARM *** ");
      lcd.setCursor(0, 1);
      lcd.print("Code>");
    }
    if ( keypressed == '*') { // Setting * as enter password button
      if ( tempPassword == password ) {
        digitalWrite(avrAlarm, HIGH);
        digitalWrite(avrReset, LOW);
        activated = false;
        alarmActivated = false;
        noTone(buzzer);
        screenOffMsg = 0;
      }

      else if (tempPassword != password) { // If the password is wrong shows a message and goes back to reenter the password
        lcd.setCursor(0, 1);
        lcd.print("Incorrect!!!");
        delay(3000);
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print(" *** ALARM *** ");
        lcd.setCursor(0, 1);
        lcd.print("Code>");
      }
    }
  }
}
// Custom function for the Ultrasonic sensor
long getDistance() { // Method for getting the distance from the radar
  // Clears the trigPin
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  // Sets the trigPin on HIGH state for 10 micro seconds
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  // Reads the echoPin, returns the sound wave travel time in microseconds
  duration = pulseIn(echoPin, HIGH);
  // Calculating the distance
  distance = duration * 0.034 / 2;
  return distance;
}
