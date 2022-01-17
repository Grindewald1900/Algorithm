

fun main(){
    val scoreList = listOf<Float>(89f, 100f, 100f, 90f, 95f, 98f, 92f, 94f, 99f, 86f, 92f, 96f, 94f, 94f, 94f)
    val resultOne = getGpaOne(scoreList)
    val resultTwo = getGpaTwo(scoreList)
    println("Your GPA is $resultOne /100.0")
    println("Your GPA is $resultTwo /4.0")

}

/**
 * 100 scale
 */
fun getGpaOne(score: List<Float>): Double{
    val sum = score.sum().toDouble()
    return sum/score.size
}

/**
 * 4.33 scale
 */
fun getGpaTwo(score: List<Float>): Double{
    var sumGpa = 0.0
    score.forEach {
        sumGpa += transformOne(it)
    }
    return sumGpa / score.size
}



fun transformOne(score: Float): Double{
    var result = 4.0
    if (score < 50) result = 0.0
    if (score > 49 && score < 53) result = 0.7
    if (score > 52 && score < 57) result = 1.0
    if (score > 56 && score < 60) result = 1.3
    if (score > 59 && score < 63) result = 1.7
    if (score > 62 && score < 67) result = 2.0
    if (score > 66 && score < 70) result = 2.3
    if (score > 69 && score < 73) result = 2.7
    if (score > 72 && score < 77) result = 3.0
    if (score > 76 && score < 80) result = 3.3
    if (score > 79 && score < 85) result = 3.7
    if (score > 84 && score < 90) result = 3.9
    if (score > 89 && score < 101) result = 4.0
    return result
}

fun transformTwo(score: Float): Double{
    var result = 4.33
    if (score < 50) result = 0.0
    if (score > 49 && score < 53) result = 0.7
    if (score > 52 && score < 57) result = 1.0
    if (score > 56 && score < 60) result = 1.3
    if (score > 59 && score < 63) result = 1.7
    if (score > 62 && score < 67) result = 2.0
    if (score > 66 && score < 70) result = 2.3
    if (score > 69 && score < 73) result = 2.7
    if (score > 72 && score < 77) result = 3.0
    if (score > 76 && score < 80) result = 3.3
    if (score > 79 && score < 85) result = 3.7
    if (score > 84 && score < 90) result = 4.0
    if (score > 89 && score < 101) result = 4.33
    return result
}