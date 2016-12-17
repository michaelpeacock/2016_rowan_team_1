public class ListArrayBasedPlus<T> extends ListArrayBased<T>
{

    public ListArrayBasedPlus()
    {
        super();
    }

    public void add(int index, Object item)
    {
        if(items.length == numItems) {
            resize();
        }
        super.add(index, item);
    }

    public void resize()
    {
        T [] temp = (T[]) new Object[items.length + items.length];
        for(int index = 0; index < numItems; index++) {
            temp[index] = items[index];
        }
        items = temp;
    }


    public String toString()
    {
        String output = new String();
        for(int i = 0; i < super.size(); i++) {
            output = output + super.get(i) + " ";
        }
        return output;
    }
}
             