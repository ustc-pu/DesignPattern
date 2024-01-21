public class ChainOfResponsibility {
    public static void main(String[] args) {
        Request request1 = new Request("Type1");
        Request request2 = new Request("Type2");
        Request request3 = new Request("Type3");

        Handler handler1 = new HandlerImpl1();
        Handler handler2 = new HandlerImpl2();

        handler1.setSuccessor(handler2);

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);
    }
}

interface Handler {
    void handleRequest(Request request);
    void setSuccessor(Handler successor);
}

class HandlerImpl1 implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(Request request) {
        if(request.getType().equals("Type1")) {
            System.out.println("HandlerImpl1 processing request type1...");
        } else if(successor != null){
            System.out.printf("HandlerImpl1 can not process request type %s, delegating to successor \n", request.getType());
            successor.handleRequest(request);
        }
    }
}

class HandlerImpl2 implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(Request request) {
        if(request.getType().equals("Type2")) {
            System.out.println("HandlerImpl2 processing request type2...");
        } else if(successor != null){
            System.out.printf("HandlerImpl2 can not process request type %s, delegating to successor\n", request.getType());
            successor.handleRequest(request);
        } else {
            throw new RuntimeException("Unknown request found");
        }
    }
}

class Request {
    private String type;

    public String getType() {
        return type;
    }

    public Request(String type) {
        this.type = type;
    }
}