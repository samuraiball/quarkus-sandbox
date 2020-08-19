package dev.hirooka;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class AppStarter {
    public static void main(String[] args) {
        System.out.println("aaaaaa");
        Quarkus.run();
        System.out.println("ran");
    }
}
