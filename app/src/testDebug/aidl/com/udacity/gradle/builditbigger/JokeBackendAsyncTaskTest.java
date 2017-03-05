package com.udacity.gradle.builditbigger;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Justin on 3/4/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class JokeBackendAsyncTaskTest {


    @Mock
    Context mMockContext;

    @Test
    public void testApiResponseIsNotEmpty() {
        JokeBackendAsyncTask asyncTask = new JokeBackendAsyncTask();
        //String response = asyncTask.execute();
    }

}