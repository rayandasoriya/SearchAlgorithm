import java.util.*;

//Starting Java Class for SearchUSA
public class SearchUSA {
    //Initializing the variable
    public static List<Path> ConnectingPath = new ArrayList<Path>();
    public static List<City> Loc = new ArrayList<SearchUSA.City>();
    public static final String ASTAR = "astar";
    public static final String GREEDY = "greedy";
    public static final String DYNAMIC = "dynamic";

    private static final String PATH_SEPERATOR = ",";
    
    public void intialize() {

        //Adding the location of the cities
        Loc.add(new City("albanyGA",31.58,84.17));
        Loc.add(new City("albanyNY",42.66,73.78));
        Loc.add(new City("albuquerque",35.11,106.61));
        Loc.add(new City("atlanta",33.76,84.40));
        Loc.add(new City("augusta",33.43,82.02));
        Loc.add(new City("austin",30.30,97.75));
        Loc.add(new City("bakersfield",35.36,119.03));
        Loc.add(new City("baltimore",39.31,76.62));
        Loc.add(new City("batonRouge",30.46,91.14));
        Loc.add(new City("beaumont",30.08,94.13));
        Loc.add(new City("boise",43.61,116.24));
        Loc.add(new City("boston",42.32,71.09));
        Loc.add(new City("buffalo",42.90,78.85));
        Loc.add(new City("calgary",51.00,114.00));
        Loc.add(new City("charlotte",35.21,80.83));
        Loc.add(new City("chattanooga",35.05,85.27));
        Loc.add(new City("chicago",41.84,87.68));
        Loc.add(new City("cincinnati",39.14,84.50));
        Loc.add(new City("cleveland",41.48,81.67));
        Loc.add(new City("coloradoSprings",38.86,104.79));
        Loc.add(new City("columbus",39.99,82.99));
        Loc.add(new City("dallas",32.80,96.79));
        Loc.add(new City("dayton",39.76,84.20));
        Loc.add(new City("daytonaBeach",29.21,81.04));
        Loc.add(new City("denver",39.73,104.97));
        Loc.add(new City("desMoines",41.59,93.62));
        Loc.add(new City("elPaso",31.79,106.42));
        Loc.add(new City("eugene",44.06,123.11));
        Loc.add(new City("europe",48.87,-2.33));
        Loc.add(new City("ftWorth",32.74,97.33));
        Loc.add(new City("fresno",36.78,119.79));
        Loc.add(new City("grandJunction",39.08,108.56));
        Loc.add(new City("greenBay",44.51,88.02));
        Loc.add(new City("greensboro",36.08,79.82));
        Loc.add(new City("houston",29.76,95.38));
        Loc.add(new City("indianapolis",39.79,86.15));
        Loc.add(new City("jacksonville",30.32,81.66));
        Loc.add(new City("japan",35.68,220.23));
        Loc.add(new City("kansasCity",39.08,94.56));
        Loc.add(new City("keyWest",24.56,81.78));
        Loc.add(new City("lafayette",30.21,92.03));
        Loc.add(new City("lakeCity",30.19,82.64));
        Loc.add(new City("laredo",27.52,99.49));
        Loc.add(new City("lasVegas",36.19,115.22));
        Loc.add(new City("lincoln",40.81,96.68));
        Loc.add(new City("littleRock",34.74,92.33));
        Loc.add(new City("losAngeles",34.03,118.17));
        Loc.add(new City("macon",32.83,83.65));
        Loc.add(new City("medford",42.33,122.86));
        Loc.add(new City("memphis",35.12,89.97));
        Loc.add(new City("mexia",31.68,96.48));
        Loc.add(new City("mexico",19.40,99.12));
        Loc.add(new City("miami",25.79,80.22));
        Loc.add(new City("midland",43.62,84.23));
        Loc.add(new City("milwaukee",43.05,87.96));
        Loc.add(new City("minneapolis",44.96,93.27));
        Loc.add(new City("modesto",37.66,120.99));
        Loc.add(new City("montreal",45.50,73.67));
        Loc.add(new City("nashville",36.15,86.76));
        Loc.add(new City("newHaven",41.31,72.92));
        Loc.add(new City("newOrleans",29.97,90.06));
        Loc.add(new City("newYork",40.70,73.92));
        Loc.add(new City("norfolk",36.89,76.26));
        Loc.add(new City("oakland",37.80,122.23));
        Loc.add(new City("oklahomaCity",35.48,97.53));
        Loc.add(new City("omaha",41.26,96.01));
        Loc.add(new City("orlando",28.53,81.38));
        Loc.add(new City("ottawa",45.42,75.69));
        Loc.add(new City("pensacola",30.44,87.21));
        Loc.add(new City("philadelphia",40.72,76.12));
        Loc.add(new City("phoenix",33.53,112.08));
        Loc.add(new City("pittsburgh",40.40,79.84));
        Loc.add(new City("pointReyes",38.07,122.81));
        Loc.add(new City("portland",45.52,122.64));
        Loc.add(new City("providence",41.80,71.36));
        Loc.add(new City("provo",40.24,111.66));
        Loc.add(new City("raleigh",35.82,78.64));
        Loc.add(new City("redding",40.58,122.37));
        Loc.add(new City("reno",39.53,119.82));
        Loc.add(new City("richmond",37.54,77.46));
        Loc.add(new City("rochester",43.17,77.61));
        Loc.add(new City("sacramento",38.56,121.47));
        Loc.add(new City("salem",44.93,123.03));
        Loc.add(new City("salinas",36.68,121.64));
        Loc.add(new City("saltLakeCity",40.75,111.89));
        Loc.add(new City("sanAntonio",29.45,98.51));
        Loc.add(new City("sanDiego",32.78,117.15));
        Loc.add(new City("sanFrancisco",37.76,122.44));
        Loc.add(new City("sanJose",37.30,121.87));
        Loc.add(new City("sanLuisObispo",35.27,120.66));
        Loc.add(new City("santaFe",35.67,105.96));
        Loc.add(new City("saultSteMarie",46.49,84.35));
        Loc.add(new City("savannah",32.05,81.10));
        Loc.add(new City("seattle",47.63,122.33));
        Loc.add(new City("stLouis",38.63,90.24));
        Loc.add(new City("stamford",41.07,73.54));
        Loc.add(new City("stockton",37.98,121.30));
        Loc.add(new City("tallahassee",30.45,84.27));
        Loc.add(new City("tampa",27.97,82.46));
        Loc.add(new City("thunderBay",48.38,89.25));
        Loc.add(new City("toledo",41.67,83.58));
        Loc.add(new City("toronto",43.65,79.38));
        Loc.add(new City("tucson",32.21,110.92));
        Loc.add(new City("tulsa",36.13,95.94));
        Loc.add(new City("uk1",51.30,0.00));
        Loc.add(new City("uk2",51.30,0.00));
        Loc.add(new City("vancouver",49.25,123.10));
        Loc.add(new City("washington",38.91,77.01));
        Loc.add(new City("westPalmBeach",26.71,80.05));
        Loc.add(new City("wichita",37.69,97.34));
        Loc.add(new City("winnipeg",49.90,97.13));
        Loc.add(new City("yuma",32.69,114.62));

        // Adding the distance between connecting cities
        ConnectingPath.add(new Path("albanyNY", "montreal", 226));
        ConnectingPath.add(new Path("albanyNY", "boston", 166));
        ConnectingPath.add(new Path("albanyNY", "rochester", 148));
        ConnectingPath.add(new Path("albanyGA", "tallahassee", 120));
        ConnectingPath.add(new Path("albanyGA", "macon", 106));
        ConnectingPath.add(new Path("albuquerque", "elPaso", 267));
        ConnectingPath.add(new Path("albuquerque", "santaFe", 61));
        ConnectingPath.add(new Path("atlanta", "macon", 82));
        ConnectingPath.add(new Path("atlanta", "chattanooga", 117));
        ConnectingPath.add(new Path("augusta", "charlotte", 161));
        ConnectingPath.add(new Path("augusta", "savannah", 131));
        ConnectingPath.add(new Path("austin", "houston", 186));
        ConnectingPath.add(new Path("austin", "sanAntonio", 79));
        ConnectingPath.add(new Path("bakersfield", "losAngeles", 112));
        ConnectingPath.add(new Path("bakersfield", "fresno", 107));
        ConnectingPath.add(new Path("baltimore", "philadelphia", 102));
        ConnectingPath.add(new Path("baltimore", "washington", 45));
        ConnectingPath.add(new Path("batonRouge", "lafayette", 50));
        ConnectingPath.add(new Path("batonRouge", "newOrleans", 80));
        ConnectingPath.add(new Path("beaumont", "houston", 69));
        ConnectingPath.add(new Path("beaumont", "lafayette", 122));
        ConnectingPath.add(new Path("boise", "saltLakeCity", 349));
        ConnectingPath.add(new Path("boise", "portland", 428));
        ConnectingPath.add(new Path("boston", "providence", 51));
        ConnectingPath.add(new Path("buffalo", "toronto", 105));
        ConnectingPath.add(new Path("buffalo", "rochester", 64));
        ConnectingPath.add(new Path("buffalo", "cleveland", 191));
        ConnectingPath.add(new Path("buffalo", "toronto", 105));
        ConnectingPath.add(new Path("buffalo", "cleveland", 191));
        ConnectingPath.add(new Path("calgary", "vancouver", 605));
        ConnectingPath.add(new Path("calgary", "winnipeg", 829));
        ConnectingPath.add(new Path("charlotte", "greensboro",  91));
        ConnectingPath.add(new Path("chattanooga", "nashville",  129));
        ConnectingPath.add(new Path("chicago", "milwaukee",  90));
        ConnectingPath.add(new Path("chicago", "midland",  279));
        ConnectingPath.add(new Path("cincinnati", "indianapolis",  110));
        ConnectingPath.add(new Path("cincinnati", "dayton",  56));
        ConnectingPath.add(new Path("cleveland", "pittsburgh",  157));
        ConnectingPath.add(new Path("cleveland", "columbus",  142));
        ConnectingPath.add(new Path("coloradoSprings", "denver",  70));
        ConnectingPath.add(new Path("coloradoSprings", "santaFe",  316));
        ConnectingPath.add(new Path("columbus", "dayton", 72));
        ConnectingPath.add(new Path("dallas", "denver", 792));
        ConnectingPath.add(new Path("dallas", "mexia", 83));
        ConnectingPath.add(new Path("daytonaBeach", "jacksonville", 92));
        ConnectingPath.add(new Path("daytonaBeach", "orlando",  54));
        ConnectingPath.add(new Path("denver", "wichita",  523));
        ConnectingPath.add(new Path("denver", "grandJunction", 246));
        ConnectingPath.add(new Path("desMoines", "omaha", 135));
        ConnectingPath.add(new Path("desMoines", "minneapolis", 246));
        ConnectingPath.add(new Path("elPaso", "sanAntonio", 580));
        ConnectingPath.add(new Path("elPaso", "tucson", 320));
        ConnectingPath.add(new Path("eugene", "salem", 63));
        ConnectingPath.add(new Path("eugene", "medford", 165));
        ConnectingPath.add(new Path("europe", "philadelphia", 3939));
        ConnectingPath.add(new Path("ftWorth", "oklahomaCity", 209));
        ConnectingPath.add(new Path("fresno", "modesto", 109));
        ConnectingPath.add(new Path("grandJunction", "provo", 220));
        ConnectingPath.add(new Path("greenBay", "minneapolis", 304));
        ConnectingPath.add(new Path("greenBay", "milwaukee", 117));
        ConnectingPath.add(new Path("greensboro", "raleigh", 74));
        ConnectingPath.add(new Path("houston", "mexia", 165));
        ConnectingPath.add(new Path("indianapolis", "stLouis", 246));
        ConnectingPath.add(new Path("jacksonville", "savannah", 140));
        ConnectingPath.add(new Path("jacksonville", "lakeCity", 113));
        ConnectingPath.add(new Path("japan", "pointReyes", 5131));
        ConnectingPath.add(new Path("japan", "sanLuisObispo", 5451));
        ConnectingPath.add(new Path("kansasCity", "tulsa", 249));
        ConnectingPath.add(new Path("kansasCity", "stLouis", 256));
        ConnectingPath.add(new Path("kansasCity", "wichita", 190));
        ConnectingPath.add(new Path("keyWest", "tampa", 446));
        ConnectingPath.add(new Path("lakeCity", "tampa", 169));
        ConnectingPath.add(new Path("lakeCity", "tallahassee", 104));
        ConnectingPath.add(new Path("laredo", "sanAntonio", 154));
        ConnectingPath.add(new Path("laredo", "mexico", 741));
        ConnectingPath.add(new Path("lasVegas", "losAngeles", 275));
        ConnectingPath.add(new Path("lasVegas", "saltLakeCity", 486));
        ConnectingPath.add(new Path("lincoln", "wichita", 277));
        ConnectingPath.add(new Path("lincoln", "omaha", 58));
        ConnectingPath.add(new Path("littleRock", "memphis", 137));
        ConnectingPath.add(new Path("littleRock", "tulsa", 276));
        ConnectingPath.add(new Path("losAngeles", "sanDiego", 124));
        ConnectingPath.add(new Path("losAngeles", "sanLuisObispo",  182));
        ConnectingPath.add(new Path("medford", "redding",  150));
        ConnectingPath.add(new Path("memphis",  "nashville",  210));
        ConnectingPath.add(new Path("miami",  "westPalmBeach",  67));
        ConnectingPath.add(new Path("midland",  "toledo",  82));
        ConnectingPath.add(new Path("minneapolis",  "winnipeg",  463));
        ConnectingPath.add(new Path("modesto",  "stockton",  29));
        ConnectingPath.add(new Path("montreal",  "ottawa",  132));
        ConnectingPath.add(new Path("newHaven",  "providence",  110));
        ConnectingPath.add(new Path("newHaven",  "stamford",  92));
        ConnectingPath.add(new Path("newOrleans",  "pensacola",  268));
        ConnectingPath.add(new Path("newYork",  "philadelphia",  101));
        ConnectingPath.add(new Path("norfolk",  "richmond",  92));
        ConnectingPath.add(new Path("norfolk",  "raleigh",  174));
        ConnectingPath.add(new Path("oakland",  "sanFrancisco",  8));
        ConnectingPath.add(new Path("oakland",  "sanJose",  42));
        ConnectingPath.add(new Path("oklahomaCity", "tulsa",  105));
        ConnectingPath.add(new Path("orlando", "westPalmBeach",  168));
        ConnectingPath.add(new Path("orlando", "tampa",  84));
        ConnectingPath.add(new Path("ottawa",  "toronto",  269));
        ConnectingPath.add(new Path("pensacola",  "tallahassee",  120));
        ConnectingPath.add(new Path("philadelphia",  "pittsburgh",  319));
        ConnectingPath.add(new Path("philadelphia",  "newYork",  101));
        ConnectingPath.add(new Path("philadelphia",  "uk1",  3548));
        ConnectingPath.add(new Path("philadelphia",  "uk2",  3548));
        ConnectingPath.add(new Path("phoenix",  "tucson",  117));
        ConnectingPath.add(new Path("phoenix",  "yuma",  178));
        ConnectingPath.add(new Path("pointReyes",  "redding",  215));
        ConnectingPath.add(new Path("pointReyes",  "sacramento",  115));
        ConnectingPath.add(new Path("portland",  "seattle",  174));
        ConnectingPath.add(new Path("portland",  "salem",  47));
        ConnectingPath.add(new Path("reno",  "saltLakeCity",  520));
        ConnectingPath.add(new Path("reno",  "sacramento",  133));
        ConnectingPath.add(new Path("richmond",  "washington",  105));
        ConnectingPath.add(new Path("sacramento",  "sanFrancisco",  95));
        ConnectingPath.add(new Path("sacramento",  "stockton",  51));
        ConnectingPath.add(new Path("salinas",  "sanJose",  31));
        ConnectingPath.add(new Path("salinas",  "sanLuisObispo",  137));
        ConnectingPath.add(new Path("sanDiego",  "yuma",  172));
        ConnectingPath.add(new Path("saultSteMarie", "thunderBay",  442));
        ConnectingPath.add(new Path("saultSteMarie",  "toronto",  436));
        ConnectingPath.add(new Path("seattle",  "vancouver",  115));
        ConnectingPath.add(new Path("thunderBay",  "winnipeg",  440));

    }


    // Class to Define getters and setters for city
    public class City {
        private String cityName;
        private double lat;
        private double lon;

        public City(String cityName, double lat, double lon) {
            super();
            this.cityName = cityName;
            this.lat = lat;
            this.lon = lon;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

    //Class to define the getters and setters for path cost between connecting cities
    public class Path {
        private String sourceCity;
        private String destinationCity;
        private int cost;

        public Path(String sourceCity, String destinationCity, int cost) {
            super();
            this.sourceCity = sourceCity;
            this.destinationCity = destinationCity;
            this.cost = cost;
        }

        public String getSourceCity() {
            return sourceCity;
        }
        public void setSourceCity(String sourceCity) {
            this.sourceCity = sourceCity;
        }
        public String getDestinationCity() {
            return destinationCity;
        }
        public void setDestinationCity(String destinationCity) {
            this.destinationCity = destinationCity;
        }
        public int getCost() {
            return cost;
        }
        public void setCost(int cost) {
            this.cost = cost;
        }

        //TO check if source and destination is same
        @Override
        public boolean equals(Object o) {
            if(o != null && o instanceof Path) {
                Path r = (Path)o;
                if(r.getSourceCity().equals(sourceCity) && r.getDestinationCity().equals(destinationCity)) {
                    return true;
                } else if(r.getSourceCity().equals(destinationCity) && r.getDestinationCity().equals(sourceCity)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Class to get and set the value of path, actual cost adn heuristic cost
    class Node implements Comparable<Node>{
        private String path;
        private int actualCost;
        private double hCost;

        public Node(String path, int actualCost, double hCost) {
            super();
            this.path = path;
            this.actualCost = actualCost;
            this.hCost = hCost;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getActualCost() {
            return actualCost;
        }

        public void setActualCost(int actualCost) {
            this.actualCost = actualCost;
        }

        public double getHeuristicCost() {
            return hCost;
        }

        public void setHeuristicCost(double hCost) {
            this.hCost = hCost;
        }

        // Function to compare the value of cost
        @Override
        public int compareTo(Node o) {
            double totalCost = actualCost + hCost;
            double totalCost_o = o.getActualCost() + o.getHeuristicCost();
            if(totalCost == totalCost_o) {
                return 0;
            } else if (totalCost > totalCost_o) {
                return 1;
            } else if (totalCost < totalCost_o) {
                return -1;
            }
            return 0;
        }

        // To check if the city is already in the frontier with a higher cost or if its a new city
        @Override
        public boolean equals(Object obj) {
            if(obj != null && obj instanceof Node) {
                Node newNode = (Node)obj;
                String existingCity = getCurrentCity(getPath());
                String newCity = getCurrentCity(newNode.getPath());
                if(existingCity.equalsIgnoreCase(newCity)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void logOutput(String msg) {
        System.out.println(msg);
    }

    // Main function to get the value from the user in the beginning
    public static void main(String args[]) {
        SearchUSA search = new SearchUSA();
        search.intialize();

        if (args.length == 3) {
            String searchType = args[0];
            String sourceCity = args[1];
            String destinationCity = args[2];

            if (ASTAR.equals(searchType)) {
                search.astar(sourceCity, destinationCity);
            } else if (GREEDY.equals(searchType)) {
                search.greedy(sourceCity, destinationCity);
            } else if (DYNAMIC.equals(searchType)) {
                search.dynamic(sourceCity, destinationCity);
            }
        }
    }

    // Function of A*
    private void astar(String sourceCity, String destinationCity) {
        Queue<Node> queue = new PriorityQueue<Node>();
        List<String> visitedList = new ArrayList<String>();
        queue.add(new Node(sourceCity, 0, 0));
        int totalNodesExpanded = 0;
        while(!queue.isEmpty()) {
            // Check if the queue is empty
            Node currentNode = queue.remove();
            // Removing the current node from the queue
            if(goalChecker(currentNode.getPath(), destinationCity)) {
                // To check if the goal is achieved
                logOutput("");
                logOutput("Total Nodes Expanded by A* = " + totalNodesExpanded);
                logOutput("Path generated by A*: " + currentNode.getPath());
                logOutput("Path length generated by A*: " + getPathLength(currentNode.getPath()));
                logOutput("Cost of A*: " + currentNode.actualCost);
                return;
            } else {
                String currentCity = getCurrentCity(currentNode.getPath());
                // Get the expanded list of cities from the current source
                if(totalNodesExpanded != 0) {
                    System.out.print(", ");
                } else {
                    System.out.print("Nodes Expanded are : ");
                }
                System.out.print(currentCity);
                totalNodesExpanded ++;
                if(!visitedList.contains(currentCity)) {
                    // To check if the city has been visited
                    visitedList.add(currentCity);
                }
                List<Node> possibleMoves = moveGenerator(currentCity);
                // Defining the move generator
                for (Node possibleMove : possibleMoves) {
                    if(!visitedList.contains(possibleMove.getPath())) {
                        // Calculate the heuristic value to add the city in the queue
                        String newPath = currentNode.getPath() + PATH_SEPERATOR + possibleMove.getPath();
                        int totalCost = currentNode.getActualCost() + possibleMove.getActualCost();
                        double newHeuristicCost = calcHeuristicCost(possibleMove.getPath(), destinationCity);
                        Node node = new Node(newPath, totalCost, newHeuristicCost);
                        if(queue.contains(node)) {
                            updateQueueNode(queue, node);
                        } else {
                            queue.add(node);
                        }
                    }
                }
            }
        }

        logOutput("\nNo path found for A*");
    }

    // Function of Dynamic
    private void dynamic(String sourceCity, String destinationCity) {
        Queue<Node> queue = new PriorityQueue<Node>();
        List<String> visitedList = new ArrayList<String>();
        queue.add(new Node(sourceCity, 0, 0));
        int totalNodesExpanded = 0;
        while(!queue.isEmpty()) {
            // Check if the queue is empty
            Node currentNode = queue.remove();
            // Removing the current node from the queue
            if(goalChecker(currentNode.getPath(), destinationCity)) {
                // To check if the goal is achieved
                logOutput("");
                logOutput("Total Nodes Expanded by dynamic = " + totalNodesExpanded);
                logOutput("Path generated by dynamic Programming: " + currentNode.getPath());
                logOutput("Path length generated by dynamic Programming: " + getPathLength(currentNode.getPath()));
                logOutput("Cost of Dynamic: " + currentNode.actualCost);
                return;
            } else {
                String currentCity = getCurrentCity(currentNode.getPath());
                // Get the expanded list of cities from the current source
                if(totalNodesExpanded != 0) {
                    System.out.print(", ");
                } else {
                    System.out.print("Nodes Expanded are : ");
                }
                totalNodesExpanded++;
                System.out.print(currentCity);
                visitedList.add(currentCity);
                List<Node> possibleMoves = moveGenerator(currentCity);
                // Defining the move generator
                for (Node possibleMove : possibleMoves) {
                    if(!visitedList.contains(possibleMove.getPath())) {
                        // Calculate the path value from the source to add the city in the queue
                        String newPath = currentNode.getPath() + PATH_SEPERATOR + possibleMove.getPath();
                        int totalCost = currentNode.getActualCost() + possibleMove.getActualCost();
                        Node node = new Node(newPath, totalCost, 0);
                        if(queue.contains(node)) {
                            updateQueueNode(queue, node);
                        } else {
                            queue.add(node);
                        }
                    }
                }
            }
        }
        logOutput("\nNo path found for dynamic Programming");
    }

    private void greedy(String sourceCity, String destinationCity) {
        Queue<Node> queue = new PriorityQueue<Node>();
        List<String> visitedList = new ArrayList<String>();
        queue.add(new Node(sourceCity, 0, 0));
        int totalNodesExpanded = 0;
        while(!queue.isEmpty()) {
            // Check if the queue is empty
            Node currentNode = queue.remove();
            // Removing the current node from the queue
            if(goalChecker(currentNode.getPath(), destinationCity)) {
                // To check if the goal is achieved
                logOutput("");
                logOutput("Total Nodes Expanded by Greedy = " + totalNodesExpanded);
                logOutput("Path generated by Greedy: " + currentNode.getPath());
                logOutput("Path length generated by Greedy: " + getPathLength(currentNode.getPath()));
                int totalCost = getPathCost(currentNode.getPath());
                logOutput("Cost of Greedy: " + totalCost);
                return;
            } else {
                String currentCity = getCurrentCity(currentNode.getPath());
                // Get the expanded list of cities from the current source
                if(totalNodesExpanded != 0) {
                    System.out.print(", ");
                } else {
                    System.out.print("Nodes Expanded are : ");
                }
                totalNodesExpanded++;
                System.out.print(currentCity);
                visitedList.add(currentCity);
                List<Node> possibleMoves = moveGenerator(currentCity);
                // Defining the move generator
                for (Node possibleMove : possibleMoves) {
                    if(!visitedList.contains(possibleMove.getPath())) {
                        // Calculate the heuristic value to add the city in the queue
                        String newPath = currentNode.getPath() + PATH_SEPERATOR + possibleMove.getPath();
                        double newHeuristicCost = calcHeuristicCost(possibleMove.getPath(), destinationCity);
                        Node node = new Node(newPath, 0, newHeuristicCost);
                        if(queue.contains(node)) {
                            updateQueueNode(queue, node);
                        } else {
                            queue.add(node);
                        }
                    }
                }
            }
        }
        logOutput("\nNo path found for Greedy");
    }

    private int getPathLength(String path) {
        // Get the path length
        String[] cities = path.split(PATH_SEPERATOR);
        return cities.length;
    }

    private int getPathCost(String path) {
        // Calculate teh total path cost
        String[] cities = path.split(PATH_SEPERATOR);
        int totalCost = 0;
        for (int i = 0; i < cities.length - 1 ; i++) {
            Path r = new Path(cities[i], cities[i+1], 0);
            if(ConnectingPath.contains(r)) {
                int indexOf = ConnectingPath.indexOf(r);
                Path road = ConnectingPath.get(indexOf);
                totalCost += road.getCost();
            }
        }
        return totalCost;
    }

    private static boolean goalChecker(String path, String destinationCityName) {
        // To check if the goal or destination has been reached
        String lastVisitedCity = getCurrentCity(path);
        if(lastVisitedCity != null && !lastVisitedCity.trim().equals("") && lastVisitedCity.equalsIgnoreCase(destinationCityName)) {
            return true;
        }
        return false;
    }

    private List<Node> moveGenerator(String currentCity) {
        // Defining the move generator with all the neighbours
        List<Node> possibleMoves = new ArrayList<Node>();
        if(currentCity != null) {
            for (Path road : ConnectingPath) {
                if(road.getSourceCity().equalsIgnoreCase(currentCity)) {
                    possibleMoves.add(new Node(road.getDestinationCity(), road.getCost(), 0));
                } else if (road.getDestinationCity().equalsIgnoreCase(currentCity)) {
                    possibleMoves.add(new Node(road.getSourceCity(), road.getCost(), 0));
                }
            }
        }
        return possibleMoves;
    }

    private static String getCurrentCity(String currentPath) {
        // To get the value of the last visited city or the current city
        if(currentPath != null) {
            int index = currentPath.lastIndexOf(PATH_SEPERATOR);
            if(index != -1)
            {
                String lastVisitedCity = currentPath.substring(index + 1);
                return lastVisitedCity;
            } else {
                return currentPath;
            }
        }
        return null;
    }

    private void updateQueueNode(Queue<Node> queue, Node newNode) {
        // update the queue node when a lower cost path is discovered
        for (Node existingNode : queue) {
            if(existingNode.equals(newNode)) {
                if(existingNode.getActualCost() + existingNode.getHeuristicCost() > newNode.getActualCost() + newNode.getHeuristicCost()) {
                    existingNode.setPath(newNode.getPath());
                    existingNode.setActualCost(newNode.getActualCost());
                    existingNode.setHeuristicCost(newNode.getHeuristicCost());
                }
            }
        }
    }

    private double calcHeuristicCost(String path, String destinationCity) {
        // Passing values to calculate the heuristic cost of path
        double lat1 = 0;
        double lat2 = 0;
        double lon1 = 0;
        double lon2 = 0;
        for (City city : Loc) {
            if(city.getCityName().equalsIgnoreCase(path)) {
                lat1 = city.getLat();
                lon1 = city.getLon();
            }
            if(city.getCityName().equalsIgnoreCase(destinationCity)) {
                lat2 = city.getLat();
                lon2 = city.getLon();
            }
        }
        double hCost = heurisiticFunc(lat1,lon1, lat2, lon2);
        return hCost;
    }

    private double heurisiticFunc(double lat1, double lon1,
                                     double lat2, double lon2) {
        // Calculation of heuristic cost using the formula
        double lat_sum = lat1 + lat2;
        double lat_sub = lat1 - lat2;
        double long_sub = lon1 - lon2;
        double term1 = Math.pow(69.5 * lat_sub, 2);
        double term2 = Math.pow(69.5 * Math.cos(lat_sum / 360 * Math.PI) * long_sub, 2);
        double hVal = Math.sqrt(term1 + term2);
        return hVal;
    }
}