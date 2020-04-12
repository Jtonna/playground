process = 'AdobeNotificationClient.exe                                         "C:\Program Files\WindowsApps\AdobeNotificationClient_1.0.1.22_x86__enpm4xejd91yc\AdobeNotificationClient.exe" -ServerName:App.AppXbdz14xebceycqvrazxqtnx89wn9e0ebz.mca                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       17824'

# Take in a start & end index for a string
def substring_constructor(substring_start_index, substring_end_index):
    print("\n*Substring Constructor")
    print(f"start & end index for a string {substring_start_index, substring_end_index}\n")

# main string refer's to "process" which is a string that is 1070 characters long and riddle'd with spaces and 3 sub-strings that are a Program Name, Program Drive Location & Process Id (PID)
for i in range(len(process)):
    print(f"\n{process[i]}    |||  loop #{i} of {len(process)-1}")

    # Move through an empty space in the main string then start the loop again
    if process[i] == ' ':
        if process[i+1] == ' ':
            continue
    
    # Now all "sub-strings" should be seperated by a single space
    print(process[i])

