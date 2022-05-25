import tkinter as tk
from tkinter import *
import tkinter.messagebox
 #  GUI for entering on screen name

class NameGUI():

    def __init__(self):
        self.name = None  # class variable for accessing chosen name
        self.top = tk.Tk()  # initialise window
        self.top.title("Name selection")
        self.top.geometry("300x100")  # window sizing
        top_frame = tk.Frame(self.top).pack(side="top")  # spacing components
        mid_frame = tk.Frame(self.top).pack()
        bottom_frame = tk.Frame(self.top).pack(side="bottom")
        self.label = tk.Label(self.top, text="Please enter screen name:", ).pack(Frame=top_frame)  # label for window
        self.e1 = tk.Entry(self.top, text="Enter name:")
        self.e1.pack(Frame=mid_frame)  # textfield for name entry
        self.select_button = tk.Button(self.top, text="Select", command = self.selectName, fg="black").pack(Frame=bottom_frame,
                                                                                           side="left")  # buttons
        self.cancel_button = tk.Button(self.top, text="Cancel", command = self.leaveNameGUI, fg="black").pack(Frame=bottom_frame,
                                                                                               side="right")
        self.top.mainloop()  # initialise window

    def selectName(self):  # method that returns entered name
        if self.e1.get() == "":
            self.warningWindow()
              # warning box
        else:
            name = self.e1.get()
            print("string output: " + self.e1.get())
            print("class output " + name)
            self.leaveNameGUI()
            return name

    def leaveNameGUI(self):  # method to close window
        self.top.destroy()

    def warningWindow(self):
        tk.messagebox.showinfo("Caution", "Please enter a screen name")

    def getName(self):
        return self.name

def main():
    nameInput = NameGUI()
    #nameInput.write2client('hello')


if __name__ == "__main__":
    main()
