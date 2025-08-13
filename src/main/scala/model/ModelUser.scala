package model
import scala.collection.mutable.ListBuffer

class User(val name: String) { 
    val borrowedDocs: ListBuffer[Document] = ListBuffer()// list of docs borrowed by this user
        def borrowDocument(doc: Document): Boolean  = {  // fct used if a user want to borrow a book, it checks if it's available or not
        if (doc.borrow()) {
            borrowedDocs += doc
            doc.isBorrowed=true // since the user will borrow the doc "doc.isborrowed should be set to true so no one can borrow this doc until it's returned"
            doc.description = s"The doc titled ${doc.title} is borrowed by ${name}!"
            println(s"The doc ${doc.title} is added to the borrowedDocs list of ${name}!")
            true
            }
        else {println("This doc is already borrowed :("); false }
    }
    def returnDocument(doc: Document): Boolean  = {  // fct used if a user want to return a book, it checks if it's already returned or not 
        if (doc.returnItem() && (borrowedDocs.contains(doc))) {
            borrowedDocs -= doc
            doc.isBorrowed=false // set isborrowed to false so sthe others can borrow it since it's available.
            doc.description = s"The doc titled ${doc.title} is returned by ${name}. It's available now!"
            println(s"The book ${doc.title} is removed from the borrowedDocs list of ${name}!")
            true
            }
        else {println(s"There may be a mistake because the book ${doc.title} is not borrowed by anyone or not in your borrowedDocs!!"); false }
    }
    def listBorrowedDocuments(): Unit = { // show lists of docs borrowed by th user
        println(s"List of documents borrowed by ${name}: \n")
        borrowedDocs.foreach { doc =>doc.infos()
        }
    }

}