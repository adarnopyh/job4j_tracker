package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder totalString = new StringBuilder();
        int size = evenElements.size() / 2;
        for (int i = 0; i < size; i++) {
            totalString.append(evenElements.poll());
            evenElements.poll();
        }
        return totalString.toString();
    }

    private String getDescendingElements() {
        StringBuilder totalString2 = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            totalString2.append(descendingElements.pollLast());
        }
        return totalString2.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}