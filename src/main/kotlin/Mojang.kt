/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
val INIT_COIN = 1000
var ROUND = 0
var yee = Player("Yee")
var chris = Player("Chris")
var emily = Player("Emily")
var aron = Player("Aron")
var jo = Player("Jossie")
var playerList = mutableListOf<Player>()

class Player(name: String){
    var name = name
    var coin = INIT_COIN
    var winCount = 0
    var loseCount = 0

    fun reset(){
        coin = INIT_COIN
        winCount = 0
        loseCount = 0
    }
}
fun main() {
    playerList.add(yee)
    playerList.add(chris)
    playerList.add(jo)
    playerList.add(emily)

    /** Start **/
    showStatus()
    addOne(chris, yee, 8)
    addTwo(yee, emily, jo, 64)
    addOne(jo, emily, 8)
    showStatus()

    addThree(emily, 2)
    addOne(yee, jo, 16)
    addOne(chris, jo, 16)
    showStatus()

    addThree(jo, 32)
    addOne(chris, yee, 64)
    addOne(yee, emily, 2)
    showStatus()

    addThree(emily, 16)
    addTwo(yee, chris, jo, 2)
    showStatus()

    addOne(chris, jo, 32)
    addTwo(yee, emily, jo, 128)
    addOne(emily, jo, 16)
    showStatus()

    addThree(emily, 2)
    addTwo(yee, chris, jo, 16)
    addOne(chris, jo, 16)
    showStatus()

    addTwo(emily, yee, jo, 8)
    addThree(chris, 8)
    showStatus()

    addOne(chris, yee, 4)
    addThree(jo, 16)
    showStatus()

    addThree(chris, 2)
    addTwo(yee, jo, emily, 16)
    addOne(emily, jo, 2)
    showStatus()

    addOne(chris, jo, 16)
    addOne(jo, emily, 2)
    addOne(emily, yee, 16)
    showStatus()


}

fun addOne(winner: Player, loserOne: Player, amount: Int){
    winner.coin += amount
    loserOne.coin -= amount
    winner.winCount ++
    loserOne.loseCount ++
}

fun addTwo(winner: Player, loserOne: Player, loserTwo:Player, amount: Int){
    winner.coin += amount * 2
    loserOne.coin -= amount
    loserTwo.coin -= amount
    winner.winCount ++
    loserOne.loseCount ++
    loserTwo.loseCount ++
}

fun addThree(winner: Player, amount: Int){
    if (!playerList.contains(winner)) return

    playerList.forEach {
        if (it.name != winner.name){
            it.coin -= amount
            it.loseCount ++
        }else{
            it.coin += amount * 3
            it.winCount += 3
        }
    }
//    winner.coin += amount * 3
//    loserOne.coin -= amount
//    loserTwo.coin -= amount
//    loserThree.coin -= amount
//    winner.winCount ++
//    loserOne.loseCount ++
//    loserTwo.loseCount ++
//    loserThree.loseCount ++
}

fun showStatus(){
    var selectPlayer: Player = playerList[0]
    var winnerForRound = playerList[0]
    var loseForRound = playerList[0]
    for (i in 0 until  playerList.size){
        if (playerList[i].coin > selectPlayer.coin){
            selectPlayer = playerList[i]
        }
    }
    for (i in 0 until playerList.size){
        if (playerList[i].winCount > winnerForRound.winCount){
            winnerForRound = playerList[i]
        }
    }
    for (i in 0 until playerList.size){
        if (playerList[i].winCount > loseForRound.winCount){
            loseForRound = playerList[i]
        }
    }
    println("Round $ROUND status")
    println("************************")
    println("Winner: ${selectPlayer.name} Coin: ${selectPlayer.coin}")
    println("************************")
    println("Most round winners: ${winnerForRound.name} Coin: ${winnerForRound.winCount}")
    println("************************")
    println("Most round losers: ${loseForRound.name} Coin: ${loseForRound.loseCount}")
    println("************************")


    playerList.forEach{
        println("${it.name}: coin - ${it.coin}  win - ${it.winCount} lose - ${it.loseCount}")
    }

    println()
    ROUND ++
}