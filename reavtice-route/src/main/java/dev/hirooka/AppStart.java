package dev.hirooka;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class AppStart {
    public static void main(String[] args) {
        Quarkus.run();
    }
}