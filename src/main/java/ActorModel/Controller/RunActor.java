package ActorModel.Controller;

import ActorModel.Model.Actor;
import ActorModel.Model.Matriz;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public final class RunActor {

    public static void main(String[] args) {
        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] mat2Values = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Matriz m = new Matriz(mat1Values, mat2Values);

        ActorSystem akkaSystem = ActorSystem.create("system");
        ActorRef matriz = akkaSystem.actorOf(Actor.props(), "Matriz");
        matriz.tell(m, ActorRef.noSender());
        akkaSystem.terminate();
    }
}
