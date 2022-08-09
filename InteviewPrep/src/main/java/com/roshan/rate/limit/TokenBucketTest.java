package com.roshan.rate.limit;

import org.isomorphism.util.TokenBucket;
import org.isomorphism.util.TokenBuckets;

import java.util.concurrent.TimeUnit;

public class TokenBucketTest {


    public static void main(String[] args) {
        TokenBucket bucket = TokenBuckets.builder()
                .withCapacity(1)
                .withFixedIntervalRefillStrategy(1, 1, TimeUnit.SECONDS)
                .build();

// ...

        while (true) {
            // Consume a token from the token bucket.  If a token is not available this method will block until
            // the refill strategy adds one to the bucket.
            bucket.consume(1);

//            poll();
        }
    }
}
