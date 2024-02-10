/**
 * Name: Daniel Bernal
 * Date: 2/9/24
 * Project 01 Part 02/04
 * This class creates a reader and has methods that allows the reader to check out books
 */

package com.daclink;
import com.daclink.Utilities.Code;


import java.util.ArrayList;
import java.util.List;

public class Reader {
  public static int CARD_NUMBER_= 0;
  public static int NAME_ = 1;
  public static int PHONE_ = 2;
  public static int BOOK_COUNT_ = 3;
  public static int BOOK_START_ = 4;

  private int cardNumber;
  private String name;
  private String phone;
  private List<Book> books;

  public Reader(int cardNumber, String name, String phone) {
    this.cardNumber = cardNumber;
    this.name = name;
    this.phone = phone;
    books = new ArrayList<>();
  }

  public Code addBook(Book book){
    if(hasBook(book) ){
      return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
    }
    books.add(book);

    return Code.SUCCESS;
  }

  public Code removeBook(Book book){
    if(!hasBook(book)){
      return Code.READER_DOESNT_HAVE_BOOK_ERROR;
    }
    if(hasBook(book)){
      books.remove(book);
      return Code.SUCCESS;
    }

    return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
  }

  public boolean hasBook(Book book){
    return books.contains(book);
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(name).append(" (#").append(cardNumber).append(") has checked out {");
    for(Book book: books){
      sb.append(book.toString()).append(", ");
    }
    if(!books.isEmpty()){
      sb.setLength(sb.length() - 2);
    }
    sb.append("}");
    return sb.toString();

//    return name + "(#" + cardNumber + ") has checked out " + getBooks();
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Reader reader = (Reader) o;

    if (getCardNumber() != reader.getCardNumber()) {
      return false;
    }
    if (getName() != null ? !getName().equals(reader.getName()) : reader.getName() != null) {
      return false;
    }
    return getPhone() != null ? getPhone().equals(reader.getPhone()) : reader.getPhone() == null;
  }

  @Override
  public int hashCode() {
    int result = getCardNumber();
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
    return result;
  }

  ///This is getters and setters


  public int getBookCount() {
    return books.size();
  }

  public int getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(int cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
  ////End of getters and setters

}
