package model
import scala.collection.mutable.ListBuffer


class Library {
    println("\n --------------- Creating a new library ---------------------\n")
    val documents: ListBuffer[Document] = ListBuffer()// list of docs available in the library
    val users: ListBuffer[User] = ListBuffer() // list of users 

    def addDocument(doc: Document): Unit ={
        documents += doc
        println(s" 📚 Doc ${doc.title} is added to the library documents.")
    }
    
    def addUser(user: User): Unit ={ 
        users += user
        println(s" 👥 User ${user.name} is added to the library users.")
    } 

    def listAvailableDocuments(): ListBuffer[Document] ={
        println("\n📄📄📄 List of available docs 📄📄📄\n")
        val availableDocs = ListBuffer[Document]()
        documents.foreach{doc => // filter by available documents (isborrowed=false)
            if (!doc.isBorrowed) {
                availableDocs += doc
                doc.infos
                }
            }
            availableDocs
    }

}