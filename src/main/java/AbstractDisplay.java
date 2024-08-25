public abstract class AbstractDisplay {
    public int cnt;

    public AbstractDisplay(int cnt) {
        this.cnt = cnt;
    }

    protected abstract void open();

    protected abstract void print();

    protected abstract void close();

    /* 자식 클래스에서 override 방지를 위해 final 사용 */
    public final void display() {
        open();

        for (int i = 0; i < cnt; i++) {
            print();
        }

        close();
    }
}
