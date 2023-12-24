/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libraryapp;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Libraryapp {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args)throws ParseException {
         


          boolean isSystemWorking=true;
        Scanner sc=new Scanner(System.in);

        while (isSystemWorking){

            System.out.println("Hello This is Library App\n");
            System.out.println("Enter the number of operation you want to preform : \n" +
                    "1. Add Book \n" +
                    "2. Add magaxen \n" +
                    "3. Add Jurnal \n" +
                    "4. Search Book By Title \n" +
                    "5. Search Book By No \n" +
                    "6. Search Book By Author \n" +
                    "7. Get Books on loan \n" +
                    "8. Add student \n" +
                    "9. Loan A Book \n"+
                    "10. exit \n"    );


                int option=sc.nextInt();

            switch (option){
                
                case 1 : {
                   

                    System.out.println("Enter Book Title");
                    String bookTitle =sc.next();

                    System.out.println("Enter Book Genre");
                    String genre=sc.next();

                    System.out.println("Enter Book Version");
                    int version =sc.nextInt();

                    System.out.println("Enter Book Release Date");
                    String date=sc.next();

                    System.out.println("Entere Author Id");
                    int authorID=sc.nextInt();

                    System.out.println("Entere Author Name ");
                    String authorName=sc.next();

                    System.out.println("ENtere Author Address");
                    String authorAddress=sc.next();

                    System.out.println("Enter Author Birth Date");
                    String AuthorBirthDate=sc.next();


                   Book book= Library.addBook(bookTitle, //Book Title
                           genre, // Book genre
                           version, // Book version
                           date, // Book Reelase Date
                           authorID, //Author Id
                           authorName, // Author Name
                           authorAddress, // Author Address
                           AuthorBirthDate);   // Author Birth Date
                    System.out.println("This Book Has Been Added \n"+book+ "\n Has Been Added");
                        break;
                }
                case 2:{
                    System.out.println("Enter Magazen Title");
                    String bookTitle =sc.next();
                    System.out.println("Enter Magazen Genre");
                    String genre=sc.next();
                    System.out.println("Enter Magazen Version");
                    int version =sc.nextInt();
                    System.out.println("Enter Magazen Release Date");
                    String date=sc.next();
                    System.out.println("Enter Magazen IssueNo Date");
                    int issueNo=sc.nextInt();
                    System.out.println("Entere Author Id");
                    int authorID=sc.nextInt();
                    System.out.println("Entere Author Name ");
                    String authorName=sc.next();
                    System.out.println("ENtere Author Address");
                    String authorAddress=sc.next();
                    System.out.println("Enter Author Birth Date");
                    String AuthorBirthDate=sc.next();


                   Book book= Library.addBook(bookTitle, //Book Title
                           genre, // Book genre
                           version, // Book version
                           date, // Book Reelase Date
                           authorID, //Author Id
                           authorName, // Author Name
                           authorAddress, // Author Address
                           AuthorBirthDate);   // Author Birth Date
                    System.out.println("This Book Has Been Added \n"+book+ "\n Has Been Added");
                        break;
                }
                case 4:{
                     System.out.println("Enter Book Title");
                      String bookTitle =sc.next();
                      Book theBook = Library.searchByTitle(bookTitle);
                      if (theBook!=null){
                           System.out.println("Book Found" + theBook.getinfo());
                      }else {
                        System.out.println("No Book with this number");
                    }
                    break;
                }
                case 5:{
                    System.out.println("inter book number");
                    int number = sc.nextInt();
                    Book theBook = Library.SearchBookByNo(number);
                    if (theBook !=null){
                        System.out.println("Book Found" + theBook.getinfo());
                    } else {
                        System.out.println("No Book with this number");
                    }
                    break;
                }
                case 6:{
                     System.out.println("Search Book By Author");
                    String authorName = sc.next();
                    List<Book> foundBooks = Library.searchByAuthor(authorName);
                    if (!foundBooks.isEmpty()){
                        for (Book bk : foundBooks)
                            System.out.println(bk.getinfo());
                    } else {
                        System.out.println("No Book with this number");
                    }
                    break;
                }
                case 7:{
                        Library.getBooksOnLoan();
                    break;
                }
                case 8:{
                    System.out.println("Enter Student Id ");
                    int id=sc.nextInt();
                    System.out.println("Enter Student name ");
                    String studnetName=sc.next();
                    System.out.println("Enter Student address ");
                    String address=sc.next();
                    System.out.println("Enter Student date of birth");
                    String date=sc.next();
                    System.out.println("Enter Student major");
                    String major= sc.next();
                    Library.addStudent(id,studnetName,address,date,major);
                        break;
                } case 9:{
                    int loannum=0;
                    System.out.println("Enter student name");
                    String student=sc.next();
                    System.out.println("Enter book title");
                    String bookName=sc.next();
                    String dueDate=sc.next();
                    System.out.println("Enter Due Date");
                    Library.loanBook(loannum,student,bookName,dueDate);
                    loannum++;
                    System.out.println(" this book "+bookName+" is on loan");
                    break;
                }
                 case 10 :{                    isSystemWorking=false;                 }


            }



        }




    }
  }
