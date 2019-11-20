public class Item {
    String name;
    int val, weight, totalPerValue;

    public Item(String name, int val, int weight) {
        this.name = name;
        this.val = val;
        this.weight = weight;
        this.totalPerValue = val/weight;
    }

    public String getName() {
        return this.name;
    }
    public int getVal() {
        return this.val;
    }
    public int getWeight() {
        return this.weight;
    }
    public int getTotalPerValue() {
        return this.totalPerValue;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
