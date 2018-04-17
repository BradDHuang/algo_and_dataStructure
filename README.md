
     ,-----.,--.                  ,--. ,---.   ,--.,------.  ,------.
    '  .--./|  | ,---. ,--.,--. ,-|  || o   \  |  ||  .-.  \ |  .---'
    |  |    |  || .-. ||  ||  |' .-. |`..'  |  |  ||  |  \  :|  `--, 
    '  '--'\|  |' '-' ''  ''  '\ `-' | .'  /   |  ||  '--'  /|  `---.
     `-----'`--' `---'  `----'  `---'  `--'    `--'`-------' `------'
    ----------------------------------------------------------------- 


Make your current directory a git repository by running:

git init

Using the SSH link you copied, add the remote repository as the origin:

git remote add origin git@github.com:yourname/yourrepository.git

Check your files status/changes,
Add your files and commits, 
Push your changes:

git status

git add .

git commit -m "First commit"

git push -u origin master

notes:
-m <msg>
--message=<msg>
Use the given <msg> as the commit message.

-u
--update
Update the index just where it already has an entry matching <pathspec>. 
This removes as well as modifies index entries to match the working tree, but adds no new files.