
public class Main {
    public static void main(String[] args) {
        AbstractDisplay stringDisplay = new StringDisplay("Hello, world");
        AbstractDisplay charDisplay = new CharDisplay('A');

        /* 문자열 7번 출력 */
        stringDisplay.display();
        /* char 5번 출력 1씩 증가 */
        charDisplay.display();
    }
}
