package comparable;

class Stu implements Comparable<Stu>{
    String name;
    String number;
    double score;
    public Stu(String name, String number, double score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestStu{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Stu o) {
        if(this.score<o.score){
            return 1;
        }else if(this.score==o.score){
            return 0;
        }else{
            return -1;
        }
    }
}
