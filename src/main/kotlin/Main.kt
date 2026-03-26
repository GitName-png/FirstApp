import service.NoteService

fun main() {
    val service = NoteService()
    println(service.getNote())

    Thread.sleep(500)
    service.updateText("Some text")
    println(service.getNote())
}