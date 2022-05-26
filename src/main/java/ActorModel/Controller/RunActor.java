package ActorModel.Controller;

import ActorModel.Model.Matriz;

public final class RunActor {
    private RunActor() {}

    public static void main(String[] args) {
        akka.Main.main(new String[]{Matriz.class.getName()});
    }
}
