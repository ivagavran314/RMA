import kotlin.random.Random

class Die {
    var value: Int = Random.nextInt(1, 7);

    fun roll(){
        value = Random.nextInt(1, 7);
    }
}