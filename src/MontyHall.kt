//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val totalGames = 100
    var totalWins = 0
    val switchDoor = true

    for (gameNo in 1 .. totalGames) {

        println("=====GAME $gameNo STARTED=====")

        var gameWon = false
//        TODO: Implement multiple doors
        val DOORS_COUNT = 3
        val doorsLeft = mutableListOf('A','B','C')

        val carDoor = ('A'..'C').random()
        println("Car is in door $carDoor")

        var doorChosen = ('A'..'C').random()
        println("Player chose door $doorChosen")

//        for (attemptNo in 1..DOORS_COUNT - 2) {
//            if (isWon(carDoor, attemptNo, doorsLeft)) {
//                gameWon = true
//                break
//            } else {
//                val openedSheepDoor = removeASheepDoor(carDoor, doorsLeft);
//                println(" * opened sheep door $openedSheepDoor")
//            }

//            NEW LOGIC
                doorsLeft.remove(doorChosen)
                val openedSheepDoor = removeASheepDoor(carDoor, doorsLeft)
                println(" * Game master opened sheep door $openedSheepDoor")

                if (switchDoor) {
                    doorChosen = getAnotherDoor(doorChosen, doorsLeft)
                    println(" * Player switched to door $doorChosen")
                }
                println(" * Player opened door $doorChosen")
                if (carDoor.equals(doorChosen)) {
                    gameWon = true
//                    break
                }
//        }

        if (gameWon) {
            totalWins = totalWins + 1;
            println(" * $$$ You found the door withs car $$$")
        } else {
            println(" * You lost :(")
        }
        println("=====GAME $gameNo ENDED=====")
    }

    println("\nSWITCH DOOR ENABLED: $switchDoor")
    println("TOTAL WINS: $totalWins OUT OF $totalGames GAMES")
    val successRate = (totalWins.toDouble()/totalGames.toDouble()) * 100.00
    println("WINNING PERCENTAGE: $successRate%")
}

private fun getAnotherDoor(doorChosen: Char, doorsLeft: MutableList<Char>): Char {
    for (index in 0 .. doorsLeft.size - 1) {
        if (!doorsLeft.get(index).equals(doorChosen)) {
            return doorsLeft.get(index)
        }
    }
    return 'Z'
}

private fun removeASheepDoor(carDoor: Char, doorsLeft: MutableList<Char>): Char {
    for (index in 0 .. doorsLeft.size - 1) {
        if (doorsLeft.get(index).equals(carDoor)) {
            continue
        } else {
            return doorsLeft.removeAt(index)
        }
    }
    return 'Z'
}

private fun isWon(carDoor: Char, attemptNo:Int, doorsLeft: MutableList<Char>, ): Boolean {
    val randomUpperBound = doorsLeft.size - 1
    val current_choice = doorsLeft.removeAt((0..randomUpperBound).random());
    println(" * Attempt $attemptNo searching in door $current_choice")

    if (carDoor.equals(current_choice)) {
        return true
    } else {
        return false
    }
}