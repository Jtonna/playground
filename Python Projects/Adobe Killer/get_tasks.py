import subprocess

# Dictionary that will contain a list of all running processes on the machine
processes = dict()

# Gets running tasks on the windows machine in order of ProcessID, Caption (name), CommandLine (location of file)
def get_tasks():

    # We are using the WMIC command followed by the PROCESS GET x, x, x command to get a list of everything running on the machine
    # http://net-informations.com/q/mis/wmic.html
    cmd_get_tasks = "WMIC PROCESS GET caption, commandline, processid"

    # Spawns a new shell, runs the command from cmd_get_tasks & allows the data to be accessed through stdout
    # https://docs.python.org/3/library/subprocess.html#module-subprocess
    processes_list = subprocess.Popen(cmd_get_tasks, shell=True, universal_newlines=True, stdout=subprocess.PIPE)

    # For each individual "process" line in the "shell" we spawned
    num_of_lines_from_shell = int()
    num_of_processes = int()
    for process in processes_list.stdout:

        # Increment num_of_processes (used for index in the dict)
        num_of_lines_from_shell = num_of_lines_from_shell +1

        # Each "process" has a line length of 1070 for some reason, we use this to filter out lines that are irrelevant
        if len(process) == 1070:
            num_of_processes = num_of_processes + 1

            
    
    print(f"num_of_lines_from_shell = {num_of_lines_from_shell}")
    print(f"num_of_processes = {num_of_processes}")
        

get_tasks()  
    
# processes = {
#     1:{
#         'pid' : {'name': "Caption", 'location': "commandline"}
#     },
#     2:{
#         'pid' : {'name': "Caption", 'location': "commandline"}
#     }

# }
