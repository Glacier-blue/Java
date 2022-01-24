package cloneable;

class TestStu implements Cloneable{
    String name;
    String number;
    double score;
    public TestStu(String name, String number, double score) {
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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}