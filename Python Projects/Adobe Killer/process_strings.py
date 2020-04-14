from kill_list import the_list

def processor(process):
    name_found = False
    name_list = []
    pid_found = False
    pid_list = []

    # traverse the string from the beginning for Name
    if name_found is False:
        for i in range(len(process)):

            # We know we finished adding the first string when we encounter 2 spaces in a row
            if process[i] == ' ':
                if process[i+1] == ' ':
                    name_found = True
                    break
            
            name_list.append(process[i])
            
    # traverse the string from the end for pid
    if pid_found is False:
        temp_list = []
        fail_safe = 0
        for i in range(len(process)):
            index = ((len(process) - 1) - i)

            # if the index is a space, we continue
            # once the index is not a space, we add pid's
            # if the index becomes a space again we break

            if process[index] == ' ':
                if process[index-1] == ' ':
                    continue

            # DO NOT TOUCH
            # This basically figures out when we found the pid using some jank ass "fail safe" system
            # It took me like 4 hours while sleep deprived to make it work, Im so tired. Please help.
            # 4/12/2020 3:52PM // time awake 38 hours
            try:
                int(process[index])
                if fail_safe is 1:
                    temp_list.append(process[index])
            except ValueError:
                if process[index] == ' ':
                    if fail_safe is not 2: 
                        fail_safe = 1
                        continue
                else:
                    if fail_safe is 1:
                        fail_safe = 2
                        break
            
                        
        # Loop over the temp list and basically reverse it for pid_list
        for i in range(len(temp_list)):
            # Pop the last item and add it to pid list
            last_item = temp_list.pop(len(temp_list)-1)
            pid_list.append(last_item)

    # Convert the list's to strings
    name_string = ''.join(name_list)
    pid_string = ''.join(pid_list)
    print(f"\nname: {name_string}\npid: {pid_string}")

    # pass them to kill_list
    the_list(name_string, pid_string)