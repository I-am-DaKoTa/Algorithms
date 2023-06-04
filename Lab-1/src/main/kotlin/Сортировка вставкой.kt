import java.io.File

/*
Используя код процедуры Insertion-sort, напишите программу и проверьте сортировку массива
A = {24, 5, 5, 23, 18, 12, 15, 19, 0, 15}.
• Формат входного файла (input.txt). В первой строке входного файла содержится число n (1 ≤ n ≤ 10^3) —
число элементов в массиве. Во второй строке находятся n различных целых чисел, по модулю не превосходящих 10^9.
• Формат выходного файла (output.txt). Одна строка выходного файла с отсортированным массивом.
Между любыми двумя числами должен стоять ровно один пробел
 */

fun main() {
    val inputFileName = "src/main/resources/Сортировка вставкой/input.txt"
    val outputFileName = "src/main/resources/Сортировка вставкой/output.txt"
    try {
        val (n, a) = readInputFile(inputFileName)

        insertionSort(n, a)

        writeOutputFile(outputFileName, a)
    } catch (e: Exception) {
        println("Ошибка чтения файла: ${e.message}")
    }
}

fun readInputFile(fileName: String): Pair<Int, IntArray> {
    val file = File(fileName)
    val lines = file.readLines()
    val n = lines[0].toInt()
    val numbers = lines[1].split(" ").map { it.toIntOrNull() ?: 0 }.toIntArray()
    return Pair(n, numbers)
}

fun insertionSort(arraySize: Int, array: IntArray) {
    for (i in 1 until arraySize){
        val key = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = key
    }
}

fun writeOutputFile(fileName: String, array: IntArray) {
    val file = File(fileName)
    file.writeText(array.joinToString(separator = " "))
}