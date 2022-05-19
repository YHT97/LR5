import java.util.*;


class Graph
{
    private final LinkedList[] adjLists;
    private final boolean[] visited;

    Graph(int vertices)
    {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest)
    {
        adjLists[src].add(dest);
    }

    void DFS(int vertex)
    {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (Object integer : adjLists[vertex]) {
            int adj = (int) integer;
            if (!visited[adj])
                DFS(adj);
        }
    }


    public static void main(String[] args) {
        boolean EXIT = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of graph:");
        int size = scan.nextInt();
        Graph g = new Graph(size);
        while (!EXIT) {
        System.out.println("""
                1.Add Edge 
                2.Generate Graph 
                3.DFS""");
        int toggle = scan.nextInt();
            switch (toggle) {
                case 1: {
                    System.out.println("Enter Start and End of line");
                    int start = scan.nextInt();
                    int end = scan.nextInt();
                    g.addEdge(start, end);
                    break;
                }
                case 2: {

                    System.out.println("Enter number of edge:");
                    for(int i=0;i<size;i++){
                        g.addEdge(i,(int) (Math.random()*size));
                    }
                    break;
                }
                case 3: {
                    EXIT=true;
                    g.DFS(0);
                    System.out.println();
                    break;

                }
            }
        }
    }
}