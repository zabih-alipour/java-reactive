package com.alipour.learn;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
@Slf4j
public class RxJava {
    public static void main(String[] args) {
        log.info(Arrays.toString(doSquares().toArray()));
    }

    private static List<Integer> doSquares() {
        List<Integer> squares = new ArrayList<>();
        Flowable.range(1, 64)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(squares::add);
        return squares;
    }
}
