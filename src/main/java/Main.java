
public class Main {
    public static void main(String[] args) {
        /* 다형성 으로 사용을 하고 LSP를 준수 하도록 설계 해야함 */
        AbstractDisplay stringDisplay = new StringDisplay("Hello, world");
        AbstractDisplay charDisplay = new CharDisplay('A');

        /* 문자열 7번 출력 */
        stringDisplay.display();
        /* char 5번 출력 1씩 증가 */
        charDisplay.display();
    }
}
