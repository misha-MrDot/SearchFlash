import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
fun main() {
var pathArray = mutableListOf<String>()
    var word = readln()
    try {
        val dir = "F:"

        Files.walk(Paths.get(dir))
            .filter { Files.isRegularFile(it) }
            .forEach { println(it) }
    } catch (e: Exception){
        val dir = "D:"

        Files.walk(Paths.get(dir))
            .filter { Files.isRegularFile(it) }
            .forEach { pathArray.add(it.toString()) }
    }
    println(pathArray)
    for (i in pathArray){
            if (word in i){
                if ("~$" in i){

                }else{
                    println(i)
                    val dateTime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
                    try {
                        Files.createDirectories(Paths.get("D:\\"+word+"_"+dateTime))
                    }catch (e:Exception){
                        println("Такая папка уже существует")}
                    var f = File(i.toString())

                    Files.copy(Paths.get(i),Paths.get("D:\\"+word+"_"+dateTime+"/"+i.toString().substring(i.indexOfLast {it == '\\'})),StandardCopyOption.REPLACE_EXISTING)
                }
            }
    }

}
