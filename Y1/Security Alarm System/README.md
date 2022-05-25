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


**Created the security alarm system to do the following tasks:**

We decided to create an alarm using the Arduino, by adding several modules, such as an LCD, ultrasonic sensor, keypad and a buzzer. The ultrasonic sensor has two function;

Function One: Set Alarm <br />
We created an Active option which sets the alarm by activating the ultrasonic sensor after five seconds. If it detects anything in its 30cm and 180-degree radius it will activate the alarm buzzer which will ring continuously and activate the Atmel AVR red light which will flash red light continuously. The only way to deactivate the alarm buzzer and the flashing red light gets is if you input the right numerical code on the keypad which is 1111, and if you fail to input the correct code you must wait 3 seconds to try again.

Function Two: Measure Distance <br />
We created a Monitor option that activates the ultrasonic sensor to detect any objects in its 30cm 180-degree radius.  It measures the distance between the object and the ultrasonic sensor, calculates the distance, and displays the distance in centimetres and inches on the LCD monitor. 



Arduino Implemenation <br />
This here is our final product for the Arduino section. <br />
![Arduino Security Alarm System](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y1/Security%20Alarm%20System/Arduino.jpg) <br />

This base contains an Arduino Mega Motherboard which is connected to a 9V Battery which powers the system and makes it portable. The motherboard is linked to a Breadboard via jumper wires which then distributes power and functionality to the Ultrasonic Sensor, 4x4 Keypad, LCD, Active Buzzer, Potentiometer (10k) and a Button which is all connected to the Motherboard and the Breadboard using male to female wires and jumper wires. We used Arduino IDE software and coded our Security System in C Programming Language and used a USB cable to transfer the code from the computer into the Arduino Mega Motherboard https://www.arduino.cc/en/main/software.

The Ardunio flowchart is self-explanatory. <br />

Arduino Security System Flowchart <br /> 
![Arduino Security System Flowchart](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y1/Security%20Alarm%20System/Arduino%20Security%20System%20Flowchart.jpeg) <br /> 



AVR Implementation <br />
The concept of the AVR board was to act as a flashing LED system to compliment the Arduino’s alarm system. While the AVR board has its own setup, it requires input via specified pins along a port, eliminating the need for IDC-10 connection to the Arduino. This allows the input to the specified port to be digital and nullify the need for data type conversion. Once the alarm system on the Arduino board has been triggered (via the ultrasonic sensor), a signal is sent to one AVR pin, triggering the LEDs to flash. This repeats endlessly until a second pin is triggered, resetting the LEDs (turning them off).

The AVR code is an alteration of simple flashing LED program provided by user: ‘SteveN’ from the site AvrFreaks. Since AVR’s logic gates sets its LEDs off when loaded with a 1, the program sets the zero flag to the ‘Temp’ variable before loading it with hexadecimal ‘FF’, to effectively ‘turn off’ all LEDs its outputting to.
From this point, the program waits for specific pins to receive input ‘0’ to trigger corresponding commands. After input to either pin, the program triggers the delay subroutine before jumping back to the loop subroutine to test inputs. This allows the LEDs to flash for long enough to see. <br />

AVR Security System Flowchart <br />
![AVR Security System Flowchart](https://github.com/Abidon-J-F/University-of-Greenwich-Projects/blob/main/Y1/Security%20Alarm%20System/AVR%20Security%20System%20Flowchart.jpeg) <br />

The AVR flowchart is a general visualisation of how the code above should function. The program is supposed to run endlessly as its inputs are based off an Arduino board, hence the ‘Loop’ sub routine constantly calling itself. After the Loop is called, the program waits for input in either pin 01 or 04. Since 01 is supposed to trigger the LED flashing via the ‘com LEDs’ function, it is tested first. If it receives input, it calls the delay function to wait for a duration before testing the input again. If the pin 01 hasn’t received input, then it tests pin 04 (the reset pin). If 04 is activated, it loads hex FF to the LEDs, turning them ‘off’ akin to the start of the program. If not, the program will continue to wait for input. 



**Utilised Arduino IDE with C programming language, Atmel studio IDE with AVR programming language, and LiquidCrystal and Keypad Arduino libraries in this project**
