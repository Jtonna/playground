import subprocess

list_of_names = []
list_of_pids = []
command_to_kill_processes = "taskkill /F /PID "

def the_list(name, pid):
    list_of_names.append(name)
    list_of_pids.append(pid)

def kill_processes():
    print("Killing processes now")
    for pid in list_of_pids:
        print(f"killing {pid}")
        subprocess.Popen(command_to_kill_processes+pid, shell=True)