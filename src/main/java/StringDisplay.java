/* override 할때는 부모의 의도와 다르게 하면 안된다. */
public class StringDisplay extends AbstractDisplay{
    private final String string;
    public StringDisplay(String string) {
        super(7);
        this.string = string;
    }

    @Override
    protected void open() {
        System.out.println("--StringDisplay open--");
    }

    @Override
    protected void print() {
        System.out.println(string);
    }

    @Override
    protected void close() {
        System.out.println("--StringDisplay close--");
    }
}
