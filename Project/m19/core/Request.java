package m19.core;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;;

public class Request implements Serializable {
  private int _deadline;
  private User _user;
  private Work _work;
  private Boolean _state;
  private int _dayClosed;
  private int _iDEntregue;
  private static final long serialVersionUID = 201901101348L;

  public Request(User user, Work work, int date) {
    _user = user;
    _work = work;
    _state = true;
    _dayClosed = 0;
    _deadline = makeDeadline(date);
    _iDEntregue=0;
  }

  int getNumEntregue(){
    return _iDEntregue;
  }

  void setNumEntregue(int num){
    _iDEntregue=num;
  }

  User getUser() {
    return _user;
  }

  Work getWork() {
    return _work;
  }

  int getDeadline() {
    return _deadline;
  }

  Boolean getState() {
    return _state;
  }

  void changeState() {
    _state = !_state;
  }

  void setClosed(int day) {
    _dayClosed = day;
  }

  int getDayClosed(){
    return _dayClosed;
  }

  int daysLate() {
    return _dayClosed - _deadline;
  }

  void show(){
    System.out.println(_user.showUser()+"\n"+_work.displayWork()+"\n"+getState());
  }

  int makeDeadline(int day) {
    int copies = _work.getCopies();
    if (copies != 0)
      return day += _user.getDeadline(copies);
    return -1;
  }

  boolean areCopiesAvailable(Work work) {
    return _work.areCopiesAvailable();
  }

}
