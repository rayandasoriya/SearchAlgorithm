# Search Algorithm
Dynamic Programming(Uniform Cost Search), Greedy Best First Search and A* Search Algorithms in Java


The code focusues on the US map to find the optimal path to travel from one city to another via road. The JAVA file SearchUSA.java contains the code to find the path cost and optimal path using three search techniques, i.e, Dynamic Programming(Uniform Cost Search), Greedy Best First Search, and A* searching algorithm. It has considered the map of US to traverse from one city to another. Also, it has imported the data from the dataset which contains the path between the connecting cities along with the path cost and also the location of each city(longitude and latitude). The heauritic cost to travel from one fity to another has also bene calculated.

##Installation
The machine running this program must have Java installed on the machine. To run a program, follow the steps;

1. Open the terminal and go to the location which contains the file

2. Compile the program
```
    javac SearchUSA.java
```

3. Run the program
```
    java SearchUSA [greedy|dynamic|astar] [source] [destination]    
```

In this, select one of the serachType(greedy, dynamic or astar). Then, enter the source city and then the destination city.

Ex. If you want to traverse from Portland to Sacramento using A*, then type the following code in the terminal:
```
    java SearchUSA "astar" "portland" "sacramento"
```

Similar types of combination can be tried to get the required output. the output will contain these five computations:
• A comma-separated list of expanded nodes (the closed list)
• The number of nodes expanded
• A comma-separated list of nodes in the solution path
• The number of nodes in the path
• The total distance from A to B in the solution path

If there are some issues in running the program, feel free to contact me at dasoriyarayan@gmail.com
