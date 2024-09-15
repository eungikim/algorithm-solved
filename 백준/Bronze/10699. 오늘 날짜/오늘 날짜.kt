import java.text.SimpleDateFormat
import java.util.*


fun main() {
    val calendar = Calendar.getInstance()

    val sdf = SimpleDateFormat("yyyy-MM-dd").apply {
        timeZone = TimeZone.getTimeZone("Etc/GMT+0")
    }
    println(sdf.format(calendar.time))
}