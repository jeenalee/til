# Undo and redo a commit
source: [Stackoverflow](http://stackoverflow.com/questions/927358/how-do-you-undo-the-last-commit)

``` bash
# This is what you want to undo
git commit -m "Something terribly misguided"

# This is most often done when you remembered what you just committed
# is incomplete, or you misspelled your commit message1, or both. Leaves
# working tree as it was before git commit.
git reset --soft HEAD~

# Make corrections to working tree files.
# << edit files as necessary >>

# git add whatever changes you want to include in your new commit.
git add ...

# Commit the changes, reusing the old commit message. reset copied the
# old head to .git/ORIG_HEAD; commit with -c ORIG_HEAD will open an
# editor, which initially contains the log message from the old commit
# and allows you to edit it. If you do not need to edit the message, you
# could use the -C option instead.
git commit -c ORIG_HEAD
```
