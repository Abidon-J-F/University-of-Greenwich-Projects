from PyQt5.QtGui import QTextCursor
from PyQt5.QtWidgets import *
from PyQt5 import *
import sys

# GUI for displaying group cahat

class ChatGUI:

    def __init__(self):
        self.app = QApplication(sys.argv) # main window
        self.window = QWidget()
        self.window.setWindowTitle('Chatter-')
        self.window.setMinimumSize(800, 400)
        self.Layout = QGridLayout() # grid layout for spacing widgets
        self.window.setLayout(self.Layout)
        self.button = QPushButton("Send") # button for sending messages
        self.button.clicked.connect(self.send)
        self.Layout.addWidget(self.button, 0, 1)
        self.textbox = QLineEdit() # textbox for writing messages
        self.Layout.addWidget(self.textbox, 0, 0)
        self.textWindow = QPlainTextEdit()  # text field for viewing other messages
        self.Layout.addWidget(self.textWindow, 1, 0, 1, 2)
        self.window.show()
        sys.exit(self.app.exec_())  # run main loop and display the window

    def send(self):  # method for sending messages
        msg = self.textbox.text() + "\n"
        if msg == "" or None:
            return
        else:
            print(msg)
            return msg
            self.write2client(msg)
            self.textWindow.insertPlainText(msg)

    def write2client(self, x):  # method for writing to textWindow
        if x == "" or None:
            return
        else:
            self.textWindow.insertPlainText(x)

def main():
    gui = ChatGUI()

    gui.write2client("xfgjhklklfdgfh")

if __name__ == "__main__":
    main()