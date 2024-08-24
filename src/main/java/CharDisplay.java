public class CharDisplay extends AbstractDisplay{
    private char ch;
    public CharDisplay(char ch) {
        super(5);
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.println("--CharDisplay Open--");
    }

    @Override
    public void print() {
        System.out.println(ch);
        increaseCnt();
    }

    @Override
    public void close() {
        System.out.println("--CharDisplay close--");
    }

    /* CharDisplay 에서 만 사용 되는 private method */
    private void increaseCnt() {
        ch++;
    }
}
