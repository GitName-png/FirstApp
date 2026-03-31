import models.Note
import service.NoteServiceImpl
import java.security.Provider.Service

fun main() {
    val serviceImpl = NoteServiceImpl()
//    serviceImpl.save(Note(text = "df"))
//    serviceImpl.save(Note(text = "df", id = 1))
//    serviceImpl.save(Note(text = "d"))
    Thread.sleep(1000)

    serviceImpl.save(Note(id = 2, text = "New"))
    println(serviceImpl.getAll())
    println(serviceImpl.getAllUniqueTexts())
    println(serviceImpl.getBefore(0, 3))
}