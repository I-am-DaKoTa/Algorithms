import java.io.File

/*
Напишите код линейного поиска, при работе которого выполняется сканирование последовательности в поисках значения V.
• Формат входного файла. Значение V в первой строке и последовательность из n чисел
A = a_1, a_2, . . . , a_n во второй строке, числа разделены пробелом. Ограничения: 0 ≤ n ≤ 10^3 , −10^3 ≤ ai , V ≤ 10^3
• Формат выходного файла. Одно число - индекс i, такой, что V = A[i], или значение −1, если V в отсутствует.
Если число встречается несколько раз, то выведите, сколько раз встречается число и все индексы i через запятую.
 */

fun main() {
    val inputFileName = "src/main/resources/Линейный поиск/input.txt"
    val outputFileName = "src/main/resources/Линейный поиск/output.txt"
    try {
        val (v, a) = readLinearSearchInputFile(inputFileName)

        val result = linearSearch(v, a)

        writeLinearSearchOutputFile(outputFileName, result)
    } catch (e: Exception) {
        println("Ошибка чтения файла: ${e.message}")
    }
}

fun readLinearSearchInputFile(fileName: String): Pair<Int?, IntArray?> {
    val file = File(fileName)
    val lines = file.readLines()
    val v = lines.getOrNull(0)?.toIntOrNull()
    val numbers = lines.getOrNull(1)?.split(" ")?.map { it.toIntOrNull() ?: 0 }?.toIntArray()
    return Pair(v, numbers)
}

fun linearSearch(v: Int?, array: IntArray?): List<Int> {
    val result = mutableListOf<Int>()
    if (v != null && array != null) {
        for (i in array.indices) {
            if (array[i] == v) {
                result.add(i)
            }
        }
    }
    return result
}

fun writeLinearSearchOutputFile(fileName: String, result: List<Int>) {
    val file = File(fileName)
    if (result.isEmpty()) {
        file.writeText("0\n-1")
    } else {
        file.writeText("${result.size}\n${result.joinToString(" ")}")
    }
}