# Security Alarm System

Created a security alarm system program using C programming language in the Arduino IDE and AVR for the Atmel AVR board device as a group project.

Inspiration was based on https://howtomechatronics.com/projects/arduino-security-alarm-system-project/

### Contribution to this project:
- Abidon Jude Fernandes
- Lewis Denyer
- Ronnelle Muia
- Catalin-Ionut Petcu

## Coursework Project Tasks

Created the LCD monitor to contain two options which are Activate and Monitor. The Arduino is linked to the Atmel AVR board using logic gates.
Created an Active option that activates the ultrasonic sensor after five seconds. If it detects anything in its 30cm radius it will ring the alarm buzzer continuously and activate the Atmel AVR red light. The alarm buzzer and red light gets deactivate if you input the right numerical code on the keypad otherwise you must wait 3 seconds to try again if you input the wrong code.
Created a Monitor option that activates the ultrasonic sensor to detect any objects in its 180 degrees radius and reports back the distance to the LCD monitor and display its finding in centimetres and inches.

Arduino: Here we decided to create an alarm using the Arduino, by adding several modules, such as an LCD, ultrasonic sensor, keypad and a buzzer, the ultrasonic sensor has two function;

Function one: Set Alarm
Here the system would do a five second countdown for you to get out of the range, then the ultrasonic sensor will activate, if its activated, by detecting anything in the area, it will sound the buzzer, the only way the buzzer can be turned off is by typing in the set code: 1111.

Function Two: Measure Distance
Here is the second function you would select on the LCD screen will measure the distance between the points of an object and the ultrasonic sensor and display it’s in centimetres and inches.

AVR: The concept of the AVR board was to act as a flashing LED system to compliment the Arduino’s alarm system. While the AVR board has its own setup, it requires input via specified pins along a port, eliminating the need for IDC-10 connection to the Arduino. This allows the input to the specified port to be digital and nullify the need for data type conversion. Once the alarm system on the Arduino board has been triggered (via the ultrasonic sensor), a signal is sent to one AVR pin, triggering the LEDs to flash. This repeats endlessly until a second pin is triggered, resetting the LEDs (turning them off).

Arduino: This here is our final product for the Arduino section. This base contains an Arduino Mega Motherboard which is connected to a 9V Battery which powers the system and makes it portable. The motherboard is linked to a Breadboard via jumper wires which then distributes power and functionality to the Ultrasonic Sensor, 4x4 Keypad, LCD, Active Buzzer, Potentiometer (10k) and a Button which is all connected to the Motherboard and the Breadboard using male to female wires and jumper wires. We used Arduino IDE software and coded our Security System in C Programming Language and used a USB cable to transfer the code from the computer into the Arduino Mega Motherboard https://www.arduino.cc/en/main/software.

Arduino Implemenation
PDF flowchart...
![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)
![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)



AVR Implementation
The code to the left is an alteration of simple flashing LED program provided by user: ‘SteveN’ from the site AvrFreaks. Since AVR’s logic gates sets its LEDs off when loaded with a 1, the program sets the zero flag to the ‘Temp’ variable before loading it with hexadecimal ‘FF’, to effectively ‘turn off’ all LEDs its outputting to.
From this point, the program waits for specific pins to receive input ‘0’ to trigger corresponding commands. After input to either pin, the program triggers the delay subroutine before jumping back to the loop subroutine to test inputs. This allows the LEDs to flash for long enough to see.

The flowchart to the right is a general visualisation of how the code above should function. The program is supposed to run endlessly as its inputs are based off an Arduino board, hence the ‘Loop’ sub routine constantly calling itself.
After the Loop is called, the program waits for input in either pin 01 or 04. Since 01 is supposed to trigger the LED flashing via the ‘com LEDs’ function, it is tested first. If it receives input, it calls the delay function to wait for a duration before testing the input again.
If the pin 01 hasn’t received input, then it tests pin 04 (the reset pin). If 04 is activated, it loads hex FF to the LEDs, turning them ‘off’ akin to the start of the program. If not, the program will continue to wait for input.
![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)
![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)


**Created the security alarm system to do the following tasks:**
1. Adding a module to the list of existing modules and creating a folder for it.
2. Adding a list of coursework requirements expected for each module.
3. Adding a list of requirements for a specific coursework.
4. Adding notes to each requirement 
5. Adding deadlines dates for each coursework.
6. Outputting those notes as a text document file in their appropriate folder so that it can imported into a word-processed document.

**Arduino IDE version 8 and the NetBeans IDE was utilised in making of this project.**
C, Atmel AVR, LiquidCrystal, Keypad
