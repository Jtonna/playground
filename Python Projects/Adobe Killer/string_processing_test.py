process = "Adobe_XD                                              'C:\ewerwffe\efew\dobe\efwfewfdf324 -args -moreargs'                     426462"

# Take in a start & end index for a string
def substring_constructor(substring_start_index, substring_end_index):
    print("\n*Substring Constructor")
    print(f"start & end index for a string {substring_start_index, substring_end_index}\n")

string_end_index = None
string_start_index = None
# Loop over len(process) number of times
for i in range(len(process)):
    last_index = len(process) - 1
    current_index = i
    current_index_char = process[i]
    print(f"\n{current_index_char} ||||| Loop number {i} || string_start_index {string_start_index} || string_end_index {string_end_index} || strings found {strings_found}")

    # If we are at the last_index we have found the end of the last string
    if current_index == last_index:
        string_end_index = last_index
        print(f"*Last Index last index {last_index}")
        print(f"    Setting string_end_index {string_end_index} which should be the same as last index")
        pass # continue the rest of the code

    # If we have an end index we should have a start index too, so we pass them to the substring_constructor and reset values
    if string_end_index is not None:
        strings_found = strings_found + 1
        substring_constructor(string_start_index, string_end_index)
        # We also want to reset the value's for the nest string if theres going to be another one
        continue # start a new loop if applicable

    # Move through groups of spaces & ignore args for files
    if current_index_char == ' ':
            if process[i+1] == ' ':
                continue # start another loop

    # Identify the start of a new stirng
    if current_index_char != ' ':
        if process[i+1] != ' ':
            if string_start_index == None:
                string_start_index = current_index
                print(f"    Found the start of a string at {current_index} with a character of {current_index_char}")
                
    # Identify the end of a sub-string
    if current_index_char == ' ':
            if process[i+1] != '-': # move past program args that contain a space followed by -
                print(f"FOUND THE END OF A SUB-STRING AT {current_index}")
                print(f"    the actual index of the sub-string is {current_index-1}")
    
    print(current_index_char)