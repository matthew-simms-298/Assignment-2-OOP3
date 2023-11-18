package exceptions;

public class EmptyQueueException extends Exception {
    
    public EmptyQueueException(String message){
        System.out.println(message);
    }

    public EmptyQueueException(){
        System.out.println("Queue is Empty");
    };

}
