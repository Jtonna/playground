import subprocess
from process_strings import processor

# We are using the WMIC command followed by the PROCESS GET x, x, x command to get a list of everything running on the machine
# http://net-informations.com/q/mis/wmic.html
cmd_get_tasks = "WMIC PROCESS GET caption, commandline, processid"

# Spawns a new shell, runs the command from cmd_get_tasks & allows the data to be accessed through stdout
# https://docs.python.org/3/library/subprocess.html#module-subprocess
processes_list = subprocess.Popen(cmd_get_tasks, shell=True, universal_newlines=True, stdout=subprocess.PIPE)

def find_processes(process_name):

    # Keep track of relevan programs
    num_relevant_programs = 0

    # Default process name
    if len(process_name) < 1:
        process_name = "Adobe"
    
    # For each individual "process" line in the "shell" we spawned
    for indv_process in processes_list.stdout:
        
        # If the current process contains the name we are looking for
        if process_name in indv_process:
            
            # Filter out this the program name from the results so we cant add it to the kill list
            if "Adobe Killer" in indv_process or "Adobe_Killer" in indv_process:
                continue
            
            num_relevant_programs = num_relevant_programs+1
            
            # Pass the relevant process "strings" to the
            processor(indv_process)
    
    print("\n-------------------------------------")
    print(f"Queried \"{process_name}\" and found {num_relevant_programs} relevent programs")