package ActorModel.Model;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.ActorRef;

public class Matriz extends UntypedActor{
    public enum Mensaje {
        CREA_MATRIZ
    }

    private ActorRef calcElement;

    @Override
    public void preStart() {
        // create the greeter actor
        calcElement = getContext().actorOf(Props.create(CalcElement.class), "calcElement");
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == Mensaje.CREA_MATRIZ) {
            // when the greeter is done, stop this actor and with it the application
            calcElement.tell(CalcElement.Mensaje.DEVOLVER_VALOR,getSelf());
        }
    }
}
