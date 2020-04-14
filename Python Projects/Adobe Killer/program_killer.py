from get_tasks import find_processes
from kill_list import kill_processes

print("Hello, welcome to Adobe Killer by Jacob Tonna")
print("    This program was written because i cannot stand the number of adobe proccesses that spawn & persist after closing Adobe XD, Photoshop & Illustrator, it drives me nuts.")
print("    With that being said, its pretty simple to use, you just type in the word 'kill' and the program searches for every 'adobe' program running and attempts to kill it, then it checks to make sure they are dead, if not it will loop a max of 50 times.")
print("    Adobe programs are assholes, they start back up sometimes due to one program still running. They multiply like fucking cockroaches. \n")

print("Requirements (as per my environment)")
print("    Windows 10")
print("    Python 3.7.7+")
print("    Pip 19+")
print("    Pipenv 2018.11.26")
print("    Any annoying ass Adobe Program \n")

print("Warnings")
print("    Chances are this script wont work on MAC or Linux as the main command running this system is based on Command Prompt in windows. I literally dont know if it will work on other machines or what it would do.")
print("    I have no intention of maintaining this once it's working on my system, unless it breaks or something. \n\n\n")

# Take user input to start the process
p2k = input("Enter a process name to kill: ")
find_processes(p2k)
kill_processes()