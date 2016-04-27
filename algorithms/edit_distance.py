def calculate_edit_distance(str1, str2, pos1, pos2):
    """
    Calculates the edit distance between two strings given the strings
    and index markers of the strings.
    
    Input: two strings and two integers that denote 
           the indices the function is currently inspecting.
    Output: edit distance of input strings (integer)
    """
    
    result = None
    
    # If either of the strings is an empty string, return the length
    # of the other string.  
    if pos1 == 0:
        result = pos2
    elif pos2 == 0:
        result = pos1
    
    # Check if the last character of the strings are identical. If
    # they are, move on to the next character.
    elif str1[pos1-1] == str2[pos2-1]:
        result = calculate_edit_distance(str1, str2, pos1-1, pos2-1)

    # If the last characters are not the same, one character is
    # different between these two strings at the pos 1 and 2. Move on
    # to the next character, and add one to the distance.
    else:
        # Iteratively, find which case holds true. The options are:
        #   - insertion in string1
        #   - deletion in string1
        #   - substitution between strings 1 and 2 at pos1 and pos2.
        # Choose the minimum of the three cases.
        result = 1 + min(calculate_edit_distance(str1, str2, pos1, pos2-1),
                       calculate_edit_distance(str1, str2, pos1-1, pos2),
                       calculate_edit_distance(str1, str2, pos1-1, pos2-1))
    
    return result
