import java.util.Random;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class CharacterGenerator {
    Random random = new Random();

    public char generateCharacter() {
        return Character.toChars(32 + random.nextInt(127))[0];
    }
}
