package app
import model._

// create some doc examples
object TestData {  
  val doc1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, genre = "Fantasy")
  val doc2 = new Book("1984", "George Orwell", 1949, genre = "Dystopian")
  val doc3 = new Magazine("National Geographic", "NatGeo Society", 2021, EditionNumber = 125)
  val doc4 = new Magazine("Science Today", "Science Assoc.", 2023, EditionNumber = 42)
  val doc5 = new Comic("Batman: Year One", "Frank Miller", 1987, SeriesVolume = 1)
  val doc6 = new Comic("One Piece Vol. 1", "Eiichiro Oda", 1997, SeriesVolume = 1)
  // val doc7 = new Book("Clean Code", "Robert C. Martin", 2008, genre = "Programming")
  // val doc8 = new Magazine("Time", "Time Inc.", 2024, EditionNumber = 100)
  // val doc9 = new Comic("Naruto Vol. 5", "Masashi Kishimoto", 2000, SeriesVolume = 5)
  val allDocs = List(doc1, doc2, doc3, doc4, doc5, doc6)
}

//create some users 
object TestUsers {
  val user1 = new User("Alice")
  val user2 = new User("Bob")
  val user3 = new User("Charlie")
  val user4 = new User("Diana")
  val allUsers = List(user1, user2, user3, user4)
}

object Main {
  def main(args: Array[String]): Unit ={
    // create a new library and add docs/users 
    val mylibrary = new Library()
    TestData.allDocs.foreach{ doc => mylibrary.addDocument(doc)}
    TestUsers.allUsers.foreach{ user => mylibrary.addUser(user)}

    // get list of available docs
    mylibrary.listAvailableDocuments()
    // get infos about doc3
    TestData.doc3.infos()
    // Manipulate a bit the library
    println("\n\n")
    TestUsers.user1.borrowDocument(TestData.doc3) // Alice borrowed doc3
    TestUsers.user2.borrowDocument(TestData.doc1) // Bob borrowed doc1
    TestUsers.user2.borrowDocument(TestData.doc6) // Bob borrowed doc6
    TestUsers.user4.borrowDocument(TestData.doc3) // Diana will try ro borrow doc3: error cuz its already borrowed by Alice and not returned yet 

    println("\n\n")
    // get llists of docs borrowed by Alice
    TestUsers.user1.listBorrowedDocuments()

    println("\n\n")
    TestUsers.user1.returnDocument(TestData.doc3) // Alice returned doc3
    println(TestData.doc3.description) //get description of doc3: returned by Alice
    TestUsers.user4.borrowDocument(TestData.doc3) // Now Diana can borrow doc3
    println(TestData.doc3.description) //get description of doc3: borrowed by Diana

    println("\n\n")
    // Charlie borrowed doc2
    TestUsers.user3.borrowDocument(TestData.doc2) // Alice borrowed doc3
    
    println("\n\n")
    // Now get list of available docs: expected 1-3-2-6 borrowed so 4 "Science Today"  and 5 Batman: Year One available 
    mylibrary.listAvailableDocuments()
  }

}
