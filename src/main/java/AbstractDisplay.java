public abstract class AbstractDisplay {
    public int cnt;

    public AbstractDisplay(int cnt) {
        this.cnt = cnt;
    }

    protected abstract void open();

    protected abstract void print();

    protected abstract void close();

    public void display() {
        open();

        for (int i = 0; i < cnt; i++) {
            print();
        }

        close();
    }
}
