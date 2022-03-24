class Yahtzee {
    var dice = Dice()
    var result = Result(dice)

    fun play(){
        for(i in 1 .. 3){
            println("*Roll no. $i*")
            result.printDice()
            result.checkForYahtzeePokerOrScale()
            if(i == 3){
                println("This turn is over.")
                break
            }
            if(!dice.nextRoll()) break
            dice.lock()
            dice.rollAvailable()
        }
    }
}