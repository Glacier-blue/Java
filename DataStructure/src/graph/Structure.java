package graph;

public class Structure {
    static class MGraph<E>{
        E[] vex;
        int[][] edge;
        int size = 0;
        public MGraph(int size){
            vex = (E[])new Object[size];
            edge = new int[size][size];
            this.size = size;
        }
    }
}
