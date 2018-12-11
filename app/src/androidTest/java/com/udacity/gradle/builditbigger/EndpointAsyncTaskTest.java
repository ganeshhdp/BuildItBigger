package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;


import java.util.concurrent.TimeUnit;

public class EndpointAsyncTaskTest extends AndroidTestCase{

    public void testNonEmptyJokeReceived() {
        try {
            EndpointAsyncTask task = new EndpointAsyncTask();
            task.execute();
            String joke = task.get(30, TimeUnit.SECONDS);

            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        } catch (Exception e) {
            fail("Operation timed out");
        }
    }

}
