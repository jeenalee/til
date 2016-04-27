# Git Tutorial with PyLadies

### Make new branch called `ABC`
```
$ git branch ABC
```

### Switch to branch `ABC`
```
$ git checkout ABC`
```

### Create a branch from a git commit log
From git log, copy >8 characters of the commit you want to branch off.
`$ git checkout 32098b317375f`
You will get this message:
```
detached HEAD state: you haven't made a branch for this yet`
* (detached from 32098b3)
  master
  new_branch
```
HEAD is the 'you are here' sign.

### Fork a repository
Click on the fork button, and you will get a copy of that repository on your GitHub profile. Pull the forked repo to your local environment to have a copy locally.

### Merge branches
```
$ git checkout the_branch_name_you_want_to_keep
$ git merge the_branch_to_merge
```
When merging, git puts all the git log into one history.

### Resolve conflict
Open the file. You want `<<<<<<`, `=====`, and `>>>>>` gone.

### Delete branch `ABC`
```
$ git branch -d ABC
```

### Good git practices
This will vary among different groups. In general:
- Modify code on a different branch and if it doesn't break, merge it into the master branch.
- Locally, merge it to the master branch first. If nothing breaks, send pull request to the global master branch.
