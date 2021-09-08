import kotlin.math.pow
import kotlin.math.sqrt

/** Configuration **/
val alphabet = arrayListOf('a','b','c','d','e','f','g')
val breakPoint3 = arrayListOf(-0.43, 0.43)
val breakPoint4 = arrayListOf(-0.67, 0.0, 0.67)
val breakPoint5 = arrayListOf(-0.84, -0.25, 0.25, 0.84)
val breakPoint6 = arrayListOf(-0.97, -0.43, 0.0, 0.43, 0.97)

/**
 * @ param pieceCount Here set w to pieceCount
 * @ param alphaSize Here set alphabet size to alphaSize
 * @ param array  Given the time series
**/
//const val pieceCount = 3
//const val alphaSize = 3
//val array = arrayListOf(2.0, 3.0, 5.0, 0.0, 1.0, 3.0, 2.0, 0.0, 0.0)

//const val pieceCount = 5
//const val alphaSize = 4
//val array = arrayListOf(2.0, 3.0, 4.5, 7.6, 4.0, 2.0, 2.0, 2.0, 3.0, 1.0)

const val pieceCount = 4
const val alphaSize = 4
val array = arrayListOf(2.0,1.0,3.0,0.0,1.0,3.0,2.0,0.0)

fun main(args: Array<String>) {
    val avg = average(array)
    val variance = variance(array, avg)
    val deviation = deviation(variance)
    val normalise = normalised(array, avg, deviation)
    val paaArray = pieceWise(normalise, array.size/pieceCount)
    val saxArray = symbolic(paaArray)
}

/**
 * Average of the list
 */
fun average(array: List<Double>): Double{
    val sum = array.sum().toDouble()
    val avg = sum/array.size
    println("Average: $avg")
    return avg
}

/**
 * Variance of the list
 */
fun variance(array: List<Double>, avg: Double): ArrayList<Float>{
    val arrayList = arrayListOf<Float>()
    array.forEach{
        arrayList.add((it - avg).toFloat().pow(2))
    }
    println("variance: $arrayList")
    return arrayList
}

/**
 * Deviation of the list
 */
fun deviation(array: List<Float>): Double{
    val deviation = sqrt(array.sum().toDouble()/array.size)
    println("deviation: $deviation")
    return deviation
}

/**
 * Normalised of the list
 */
fun normalised(array: List<Double>, avg: Double, deviation: Double): ArrayList<Double>{
    val normalise = arrayListOf<Double>()
    array.forEach {
        normalise.add((it - avg) / deviation)
    }
    println("normalised: $normalise")
    return normalise
}

/**
 * PAA of the list
 */
fun pieceWise(array: List<Double>, frameSize: Int): ArrayList<Double>{
    val paaArray = arrayListOf<Double>()
    var index = 0
    while (index < array.size){
        paaArray.add(array.subList(index, index + frameSize).average())
        index += frameSize
    }
    println("PAA: $paaArray")
    return paaArray
}


/**
 * SAX of the list
 */
fun symbolic(array: List<Double>): ArrayList<Char>{
    val symbolic = arrayListOf<Char>()
    val breakPoints = when(alphaSize){
        3 -> breakPoint3
        4 -> breakPoint4
        5 -> breakPoint5
        6 -> breakPoint6
        else -> breakPoint3
    }
    array.forEach {
        breakPoints.add(it)
        breakPoints.sort()
        symbolic.add(alphabet[breakPoints.indexOf(it)])
        breakPoints.remove(it)
    }
    println("SAX: $symbolic")
    return symbolic
}


