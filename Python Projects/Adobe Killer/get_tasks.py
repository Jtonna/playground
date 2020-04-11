import subprocess

# Dictionary that will contain a list of all running processes on the machine
kill_list = dict()

# Gets running tasks on the windows machine in order of ProcessID, Caption (name), CommandLine (location of file)
def get_the_tasks():

    # We are using the WMIC command followed by the PROCESS GET x, x, x command to get a list of everything running on the machine
    # http://net-informations.com/q/mis/wmic.html
    cmd_get_tasks = "WMIC PROCESS GET caption, commandline, processid"

    # Spawns a new shell, runs the command from cmd_get_tasks & allows the data to be accessed through stdout
    # https://docs.python.org/3/library/subprocess.html#module-subprocess
    processes_list = subprocess.Popen(cmd_get_tasks, shell=True, universal_newlines=True, stdout=subprocess.PIPE)

    # For each individual "process" line in the "shell" we spawned
    num_of_lines_from_shell = int()
    num_of_processes = int()
    num_of_adobe_processes = int()
    for process in processes_list.stdout:

        # Increment num_of_processes (used for index in the dict)
        num_of_lines_from_shell = num_of_lines_from_shell + 1

        # Each "process" has a line length of 1070 for some reason, we use this to filter out lines that are irrelevant
        if len(process) == 1070:
            num_of_processes = num_of_processes + 1

            # Filter our program out so we dont prematurely kill it
            if "Adobe Killer" in process:
                continue

            # Filter our program out so we dont prematurely kill it
            if "Adobe_Killer" in process:
                continue

            # If the current process contains "Adobe" we add it to the kill_list dict
            if process.find("Adobe") != -1:
                num_of_adobe_processes = num_of_adobe_processes + 1

                # Variables for the following if
                strings_found = 0
                string_start_index = None

                # For the current process, find the 3 sub-strings we want
                if strings_found < 3:

                        # Loop len(process) number of times
                        for i in range(len(process)):
                            current_index_char = process[i]
                            current_index = i
                            next_index_char = process[i + 1]

                            # Move through groups of spaces
                            if current_index_char == ' ':
                                if next_index_char == ' ':
                                    continue # start another loop

                            # Indentify the start of a new string
                            if current_index_char != ' ':
                                if next_index_char != ' ' & string_start_index == None:
                                    string_start_index = current_index
                                    continue # start another fresh loop

                            # Identify the end of a string
                            if current_index_char != ' ':
                                if next_index_char is ' ' or current_index is len(process) - 1:
                                    




                # if strings_found < 3
                # 	loop over the entire string
                        
                # 		identify the end of a string
                # 		if the current index is NOT a space
                # 			if the next index is a space or NULL
                # 				if the next index after that one is a space or NULL
                # 					set string_end_index to the current index
                # 					move on to the next index 

                # Add the "process" to the kill list
                # kill_list[format(num_of_adobe_processes-1)] = {'pid':{'name': 'caption', 'location': 'commandline'}}

                

            
    
    print(f"num_of_lines_from_shell = {num_of_lines_from_shell}")
    print(f"num_of_processes = {num_of_processes}")
    print(f"num_of_adobe_proc = {num_of_adobe_processes}")
    print(kill_list)
        

get_the_tasks()  
    
# processes = {
#     1:{
#         'pid' : {'name': "Caption", 'location': "commandline"}
#     },
#     2:{
#         'pid' : {'name': "Caption", 'location': "commandline"}
#     }

# }
