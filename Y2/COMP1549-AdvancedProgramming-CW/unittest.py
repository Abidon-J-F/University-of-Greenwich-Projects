import unittest
from chat import Server
from chat import Client
from chat import p2p
import socket


class Testchat(unittest.TestCase):
    
    def test_addr(self):
        addr = socket.socket(socket.AF_INET)
        self.assertEqual(addr, '192.168.0.47')
        #test if $1 = actual address

    def test_msg(self):
        msg = Client.sendMessage("Hello Server")
        self.assertEqual(msg, "Hello Server")
        #Test to see if messages sent to server are received to all

    def test_client_add(self):
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.assertEqual(sock, 1000)
        #Test the client class to determine if client connects to default socket

    def test_peer(self):
        peer = p2p()
        print(peer)
        #test to view peers available

if __name__ == '__main__':
    unittest.main()
