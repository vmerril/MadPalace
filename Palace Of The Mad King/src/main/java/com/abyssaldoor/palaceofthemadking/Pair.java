package com.abyssaldoor.palaceofthemadking;

class Pair<A, B> {
    A a;
    B b;

    Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    static <T,U> Pair<T,U> create(T a, U b) {
        return new Pair<>(a, b);
    }
}
