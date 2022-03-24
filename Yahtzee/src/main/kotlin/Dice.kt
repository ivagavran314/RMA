class Dice(){
    var listOfDice: MutableList<Die> = mutableListOf()
    var listOfLockedDice: MutableList<Int> = mutableListOf()

    init{
        for(i in 1 .. 6){
            listOfDice.add(Die())
        }
    }

    fun rollAvailable(){
        for(Die in listOfDice){
            val check: (Int) -> Boolean = { it == Die.value }
            if(listOfLockedDice.any(check)) listOfLockedDice.remove(Die.value)
            else Die.roll()
        }
        listOfLockedDice.clear()
    }

    fun lock(){
        listOfLockedDice.clear()
        println("Which dice would you like to lock?")
        val diceToLock = readLine()?.filter{ it.isDigit() }?.toMutableList()
        if (diceToLock != null) {
            for (diceValue in diceToLock) {
                listOfLockedDice.add(diceValue.digitToInt())
            }
        }
    }

    fun nextRoll():Boolean {
        println("Do you want to roll your dice again? (yes/no):")
        return (readLine() == "yes")
    }
}