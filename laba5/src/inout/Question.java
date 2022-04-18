package inout;

import exceptions.WrongDataException;

public class Question<T>{
    private Askable<T> askable;
    private T answer;
    public Question(String msg,Askable<T> askable){
        this.askable = askable;
        while (true){
            try{
                System.out.print(msg + " ");
                T ans = this.askable.ask();
                answer = ans;
                break;
            }
            catch(WrongDataException e){
                System.err.println(e.getMessage());
            }
        }
    }
    public T getAnswer(){
        return answer;
    }
}
