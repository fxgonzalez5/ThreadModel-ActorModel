package ActorModel.Model;

import akka.actor.UntypedActor;

public class CalcElement extends UntypedActor {
    public enum Mensaje {
        DEVOLVER_VALOR
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == Mensaje.DEVOLVER_VALOR) {
            // when the greeter is done, stop this actor and with it the application
            getContext().stop(getSelf());
        }
    }
}
