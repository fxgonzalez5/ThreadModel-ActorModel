package ActorModel.Controller;

import ActorModel.Model.Matriz;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public final class RunActor {

    public static void main(String[] args) {
        ActorSystem akkaSystem = ActorSystem.create("system");
        ActorRef matiz = akkaSystem.actorOf(Matriz.props(), "Matriz");
        matiz.tell(3, ActorRef.noSender());
    }
}
