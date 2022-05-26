# Group-Based Communication using a Network Distributed System

Created a network distributed system for a group-based communication using Python in the command line as a group project.

### Contribution to this project:
- Abidon Jude Fernandes
- Ibrahim Anjum
- Ronnelle Muia
- Sean Daly

## How to activate the program

The following program can be run as a server or a client via the command line prompt. 

In Windows:
1. Access the directory containing the program file.
2. Run the file as "Server.py" to run the server.
3. To run the client, run the program in another cmd prompt "Client.py".
4. To quit any instance via keyboard, press Ctrl + C.

In Ubuntu/Linux:
1. Access the directory containing the program file. 
2. Run the file as "python3 Server.py" to run the server.
3. To run the client, run the program as "python3 Client.py".
4. To quit any instance via keyboard, press Ctrl + C.


## Coursework Project Tasks

Develop a client to server connection-based program with a client and server class.


**Accomplishment:**
1. Created a centralised server implementation to accommodate a peer-to-peer netcode command line program using UTF-8 encoding.
2. Developed a server to client connection-based program with a client and server class.
3. Created the Client main class to inherit the Server class, allowing it to send message to and from. Both the Server and Client class are composed of global variable S, which is used to store connections of all users within the server.
4. Created the Server main class called receive_message allows the listening of any specified port that the user inputs. It uses a IPV4 address and a TDP over UDP connection because TDP is more reliable as it confirms the connection before sending the information.
5. Developed that any users connected to a server receives a unique ID is assigned to each other, a port it will listen into, IP address number, a port and IP address number of one of the existing members.
6. Developed that every user can message each of the connected members or the whole group in the server.
7. Developed the system to display all the currently connected members in your server.
8. Created the command CTRL+C that every user can use to exit the client anytime.


## Software
**Utilised Python programming language, the PyCharm IDE, and PyQt5, socket, select, errno, sys, tkinter and unittest libraries in this project.**
