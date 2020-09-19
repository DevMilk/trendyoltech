public class StackClass {
    public int MAX;
    public int stackData[]; ;
    private int counter = 0;
    public StackClass(int MAX) {
        this.MAX = MAX;
        stackData = new int[MAX];
    }

    public void push(int dataToPush) throws IndexOutOfBoundsException{
        if(counter+1>MAX)
            throw new IndexOutOfBoundsException("Stack Capacity Reached");
        stackData[counter++] = dataToPush;

    }

    public int count() {
        return counter;
    }

    public int peek() throws NullPointerException{
        if(counter<=0){
            throw new NullPointerException("Stack Is Empty");
        }
        return stackData[counter-1];
    }

    public int pop() throws NullPointerException{
        int top = peek();
        counter --;
        return top;
    }
}
