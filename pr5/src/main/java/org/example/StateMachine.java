package org.example;

public class StateMachine {
    private State currentState;

    public enum State {
        S, ONE, TWO, THREE, F
    }

    public StateMachine() {
        this.currentState = State.S;
    }

    public State processString(String input) {
        for (char c : input.toCharArray()) {
            processChar(c);
        }
        return currentState;
    }

    private void processChar(char c) {
        switch (currentState) {
            case S:
                if (c == 'T') {
                    currentState = State.ONE;
                }
                break;
            case ONE:
                if (c == 'E') {
                    currentState = State.TWO;
                } else if (c == 'T') {
                    currentState = State.ONE;
                } else {
                    currentState = State.S;
                }
                break;
            case TWO:
                if (c == 'S') {
                    currentState = State.THREE;
                } else if (c == 'T') {
                    currentState = State.ONE;
                } else {
                    currentState = State.S;
                }
                break;
            case THREE:
                if (c == 'T') {
                    currentState = State.F;
                } else {
                    currentState = State.S;
                }
                break;
        }
    }
}
