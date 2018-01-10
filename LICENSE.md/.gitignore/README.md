# marsRoverSimulator
Simulate the navigation system of the Mars Rover.

This program executes a set of instructions read from a text file. The instructions should contain three lines of commands in the following format:

8 10
1 1 N
LMLMLMRMLM

The first line of the instruction file is the boundaries of the demarcated plateau. The x and y coordinates are separated by a single space. The instructions in the example would create a demarcated plateau of size 80 with a maximum x-coordinate of 8 and a maximum y-coorindate of 10.

The second line of the instruction file is the initial position and orientation of the rover. The x and y coordinates and orientation direction are separated by a single space. The instructions in the example would initialise the position of the rover at (1,1) on the demarcated plateau with the rover facing North.

The third line of the instruction file is a series of commands that are to be executed by the rover. These commands are both movements and rotations. 
M - Move Forward
L - Rotate 90 degrees to the left
R - Rotate 90 degress to the right

A command of MLRM would move the rover forward in its current orientation, rotate its direction 90 degrees left, rotate its direction 90 degrees right and then move it forward in its current orientation.

Once the commands in the instruction file are executed, the rover will print out its current orientation and coordinates.

A file called alternativeInputs.txt is included in the project and instruction sets from this file can be used to test alternative scenarios.

# Why did you do that?
I chose to keep this solution really simple and not make use of ENUMS and interfaces etc because I personally felt that this project is small enough to not require them (but I could be wrong, I guess that's up for debate). I feel that code should be easy to read, interpret, follow and maintain. 

I really love this quote by Martin Fowler:
_*Any fool can write code that a computer can understand. Good programmers write code that humans can understand. – Martin Fowler*_

To ensure that I write code that humans can understand, I have added comments, descriptive variable names and a few unit tests.

_Confession time:_ Although I work with large-scale gradle web applications and unit test them all the time, I was a little confused when testing a pure Java app lol. I work with tools such as Mockito, JUnit and an internally developed sandbox to mimic responses and test my web apps but for this project I simply use JUnit and to test each of the key methods in the project to ensure that they return the expected response. I should probably look into doing this a bit more elegantly _(no pretences of genius here lol)_.  I did have a bit of an issue testing pieces of code that call System.exit(0) and I while I found a possible solution to this online, I simply ran out of time to implement it in this project. 

I decided to force the application to exit with an error response when receiving incorrect data/commands as I believe it would be safer to have the rover stopped and waiting for a new set of proper instructions rather than skipping/defaulting invalid commands/data and proceeding with the rest of the instructions.
