# Splitting directory into two directories.
cd directory_to_split

# Say you want to move two files into directory_2.
ls -1 | head -n 2 | xargs -I '{}' mv '{}' directory_2/
