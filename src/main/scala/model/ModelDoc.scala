package model

trait Borrowable { 
    def borrow(): Boolean
    def returnItem(): Boolean
}

abstract class Document(val title: String, val author: String, val year: Integer) extends Borrowable{
    // attributs for the class
    var isBorrowed: Boolean = false
    var description: String = "No description!"

    // def description(): String //return description to descrive the borrowing state of the doc
    // at first i used description as fct but after i wanted to update this based on the user name so its better if it's an attribute
    // also i already explained the status of the doc in borrow and return with println
    // var description: String //return description to descrive the borrowing state of the doc

    def infos(): Unit // get infos about the doc type and the different args
    def borrow() : Boolean = {  // return true if doc is available (isborrowed=false) otherwise return false
        if (!isBorrowed) {println(s"The doc titled ${title} is available."); true}
        else {println(s"Sorry! You can't borrow the doc titled ${title}."); false }
    } 
    def returnItem(): Boolean = {  // return true if doc is borrowed (isborrowed=true) otherwise return false
        if (isBorrowed) {println(s"You can return the doc titled ${title}."); true}
        else {println(s"Sorry! You can't return the doc titled ${title}."); false }
    }  
}

// subclasses inheriting from the document class
class Book(title: String, author: String, year: Integer, genre: String) extends Document(title, author, year) {
    def infos() = println(s"Book title: ${title}, Author: ${author}, Year: ${year}, Genre: ${genre}, Current description: ${description}")
}
class Magazine(title: String, author: String, year: Integer, EditionNumber: Integer) extends Document(title, author, year) {
    def infos() = println(s"Magazine title: ${title}, Author: ${author}, Year: ${year}, Edition Number: ${EditionNumber}, Current description: ${description}")

}

class Comic(title: String, author: String, year: Integer, SeriesVolume: Integer) extends Document(title, author, year) {
    def infos() = println(s"Comic title: ${title}, Author: ${author}, Year: ${year}, Series Volume: ${SeriesVolume}, Current description: ${description}")
}