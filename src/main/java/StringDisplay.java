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
