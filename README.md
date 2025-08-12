# 📚 Scala Library Management System

## Overview
This project is a **mini library management system** written in **Scala**.  
It allows you to manage different document types (**Books**, **Magazines**, **Comics**), register users, and track document borrowing and returns.

This project demonstrates:
- **Object-Oriented Programming** in Scala
- **Traits**, **Abstract Classes**, **Inheritance**, and **Polymorphism**
- **Encapsulation** and **State Management**
- **Collections Manipulation**

---

## Features
### ✅ Document Management
- Supports **Book** (with genre), **Magazine** (with edition number), and **Comic** (with series volume).
- Tracks borrow and return status.
- Displays document-specific details.

### ✅ User Management
- Add and list users.
- Borrow and return documents.
- List borrowed documents per user.

### ✅ Library Management
- Maintain a collection of documents and users.
- Add documents/users dynamically.
- List available (not borrowed) documents.

---

## Project Structure
```
src/
├── main/scala/
│ ├── app/
│ │ ├── Main.scala # Entry point with example usage
│ │
│ ├── model/
│ │ ├── ModelDoc.scala # Document base class & document types
│ │ ├── ModelLibrary.scala # Library class
│ │ ├── ModelUser.scala # User class
│
├── test/scala/example/
```


# Scala Library Management Project

## Example `Main.scala`

```scala
object Main {
  def main(args: Array[String]): Unit = {
    val mylibrary = new Library()
    TestData.allDocs.foreach(mylibrary.addDocument)
    TestUsers.allUsers.foreach(mylibrary.addUser)

    mylibrary.listAvailableDocuments()
    TestData.doc3.infos()

    println("\n\n")
    TestUsers.user1.borrowDocument(TestData.doc3)
    TestUsers.user2.borrowDocument(TestData.doc1)
    TestUsers.user2.borrowDocument(TestData.doc6)
    TestUsers.user4.borrowDocument(TestData.doc3)

    println("\n\n")
    TestUsers.user1.listBorrowedDocuments()

    println("\n\n")
    TestUsers.user1.returnDocument(TestData.doc3)
    println(TestData.doc3.description)
    TestUsers.user4.borrowDocument(TestData.doc3)
    println(TestData.doc3.description)

    println("\n\n")
    TestUsers.user3.borrowDocument(TestData.doc2)

    println("\n\n")
    mylibrary.listAvailableDocuments()
  }
}

```
And here is the output below: 

[info] running app.Main 
```
 --------------- Creating a new library ---------------------

 📚 Doc The Hobbit is added to the library documents.
 📚 Doc 1984 is added to the library documents.
 📚 Doc National Geographic is added to the library documents.
 📚 Doc Science Today is added to the library documents.
 📚 Doc Batman: Year One is added to the library documents.
 📚 Doc One Piece Vol. 1 is added to the library documents.
 👥 User Alice is added to the library users.
 👥 User Bob is added to the library users.
 👥 User Charlie is added to the library users.
 👥 User Diana is added to the library users.

📄📄📄 List of available docs 📄📄📄

 📄 Book title: The Hobbit, Author: J.R.R. Tolkien, Year: 1937, Genre: Fantasy, Current description: No description!
 📄 Book title: 1984, Author: George Orwell, Year: 1949, Genre: Dystopian, Current description: No description!
 📄 Magazine title: National Geographic, Author: NatGeo Society, Year: 2021, Edition Number: 125, Current description: No description!
 📄 Magazine title: Science Today, Author: Science Assoc., Year: 2023, Edition Number: 42, Current description: No description!
 📄 Comic title: Batman: Year One, Author: Frank Miller, Year: 1987, Series Volume: 1, Current description: No description!
 📄 Comic title: One Piece Vol. 1, Author: Eiichiro Oda, Year: 1997, Series Volume: 1, Current description: No description!
 📄 Magazine title: National Geographic, Author: NatGeo Society, Year: 2021, Edition Number: 125, Current description: No description!

The doc titled National Geographic is available.
The doc National Geographic is added to the borrowedDocs list of Alice!
The doc titled The Hobbit is available.
The doc The Hobbit is added to the borrowedDocs list of Bob!
The doc titled One Piece Vol. 1 is available.
The doc One Piece Vol. 1 is added to the borrowedDocs list of Bob!
Sorry! You can't borrow the doc titled National Geographic.
This doc is already borrowed :(

List of documents borrowed by Alice: 

 📄 Magazine title: National Geographic, Author: NatGeo Society, Year: 2021, Edition Number: 125, Current description: The doc titled National Geographic is borrowed by Alice!

You can return the doc titled National Geographic.
The book National Geographic is removed from the borrowedDocs list of Alice!
The doc titled National Geographic is returned by Alice. It's available now!
The doc titled National Geographic is available.
The doc National Geographic is added to the borrowedDocs list of Diana!
The doc titled National Geographic is borrowed by Diana!

The doc titled 1984 is available.
The doc 1984 is added to the borrowedDocs list of Charlie!

📄📄📄 List of available docs 📄📄📄

 📄 Magazine title: Science Today, Author: Science Assoc., Year: 2023, Edition Number: 42, Current description: No description!
 📄 Comic title: Batman: Year One, Author: Frank Miller, Year: 1987, Series Volume: 1, Current description: No description!
```

## Run Instructions

### Prerequisites
- Install [sbt](https://www.scala-sbt.org/download.html)
- Ensure Scala is installed (sbt will install it automatically if not).

### Commands
From the project root:

**Run the project**
```bash
sbt run
```

**Compile without running**
```bash
sbt compile
```

