# `gh-page`

### Create and checkout the `gh-pages` branch
```
$ git checkout -b gh-pages
Switched to a new branch 'gh-pages'
```

### Delete the master branch locally
```
$ git branch -d master
Deleted branch master (was dd33ea6).
```

### Push the `gh-pages` branch
```
$ git push -u origin gh-pages
Total 0 (delta 0), reused 0 (delta 0)
To https://github.com/jeenalee/interactive-pretty-stuff.git
 * [new branch]      gh-pages -> gh-pages
Branch gh-pages set up to track remote branch gh-pages from origin.
```

### Delete the master branch on GitHub
```
$ git push origin :master
To https://github.com/jeenalee/interactive-pretty-stuff.git
 - [deleted]         master
```
