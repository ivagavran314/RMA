class Result(var dice: Dice){
    fun printDice(){
        println("Result:")
        for(Die in dice.listOfDice)
            print("${Die.value} ")
        println()
    }

    fun checkForYahtzeePokerOrScale(){
        val checkForYahtzee = dice.listOfDice.groupingBy { it.value }.eachCount().filter{ it.value >= 5 }
        val checkForPoker = dice.listOfDice.groupingBy { it.value }.eachCount().filter{ it.value == 4 }
        val listOfDiceValues = mutableListOf<Int>()

        for(Die in dice.listOfDice){
            listOfDiceValues.add(Die.value)
        }

        val checkForScale: Boolean = listOfDiceValues.containsAll(listOf(1,2,3,4,5)) || listOfDiceValues.containsAll(listOf(2,3,4,5,6))

        if(checkForYahtzee.isNotEmpty()){
            println("YAHTZEE!")
        } else if(checkForPoker.isNotEmpty()){
            println("POKER!")
        } else if (checkForScale){
            println("SCALE!")
        } else {
            println("You didn't get Yahtzee, Poker nor Scale.")
        }
    }
}