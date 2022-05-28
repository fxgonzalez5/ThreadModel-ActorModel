package ActorModel.Model;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class Actor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(Matriz.class, this::multiplyWithActor)
                .build();
    }
    public static Props props(){
        return Props.create(Actor.class);
    }

    private void multiplyWithActor (Matriz m){
        m.multiplyWithActor();
    }
}
