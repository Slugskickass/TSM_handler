import java.io.*
import java.io.RandomAccessFile

fun readtext_Stream(position:Long, stream: FileInputStream, bytes: ByteArray ): Int? {
    stream.skip(position)
    stream.read(bytes)
    val value = bytes.decodeToString()
    val final: Int? = value.trim().toIntOrNull()
    return final
}

fun readtext_random(position:Long, random_access_file: RandomAccessFile, bytes: ByteArray): Int? {
    random_access_file.seek(position)
    random_access_file.read(bytes)
    val out_data =(bytes.decodeToString().trim().toIntOrNull())
    return(out_data)



}
fun main(){
    val stream = File("/Users/Ashley/Downloads/LED5.tsm").inputStream()
    var bytes = ByteArray(8)
    println("using linear")
    val width = readtext_Stream(266, stream, bytes)
    println(width)
    val height = readtext_Stream(72, stream, bytes)
    println(height)
    val length = readtext_Stream(72, stream, bytes)
    println(length)

    println("using random")
    val  file_data: RandomAccessFile =  RandomAccessFile("/Users/Ashley/Downloads/LED5.tsm", "r")
    var bytes_new = ByteArray(8)
    val width_new = readtext_random(266, file_data, bytes_new)
    println(width_new)

}

