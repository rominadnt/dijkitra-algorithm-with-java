 
class ShortestPath 
{ 
    // یافتن راس ها با کمترین فاصله از راس هایی که استفاده نشده اند
    // هر راس باید یکبار ملاقات شود
    static final int V=9; 
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        //مقداردهی مینیمم با کمترین فاصله
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    // چاپ  راس و فاصله 
    void printSolution(int dist[], int n) 
    { 
        System.out.println("rass fasele"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" _ "+dist[i]); 
    } 
  
    // تابع پیاده سازی کوتاه ترین مسیر

    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[V]; // ارایه خروجی
                                 // کوتاه ترین مسیر از منبع 
  
        Boolean sptSet[] = new Boolean[V]; 
  
        // اگر فاصله بیشتر بود
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // فاصله راس شروع از خودش همیشه صفر است
        dist[src] = 0; 
  
        for (int count = 0; count < V-1; count++) 
        { 
            // انتخاب راس با حداقل فاصله
            // u=منبع 
            // iteration. 
            int u = minDistance(dist, sptSet); 
  
            // راس انتخاب شده را تیک میزند
            sptSet[u] = true; 
  
            //بروزرسانی فاصله
            for (int v = 0; v < V; v++) 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
        printSolution(dist, V); 
    } 
    public static void main (String[] args) 
    { 
        /* ایجاد ماتریس */
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 }; 
        ShortestPath t = new ShortestPath(); 
        t.dijkstra(graph, 0); 
    } 
} 