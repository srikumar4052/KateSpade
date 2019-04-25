
package com.ch.retry;

import com.ch.utils.ParallelFactory;


public class Retry
{

    public static final long DEFAULT_WAIT = 1000;
    private int              noOfRetries;
    private int              noOfTriesLeft;
    private long             timeToWait;

    public int getNumberOfTriesLeft()
    {
        return noOfTriesLeft;
    }

    public void setNumberOfTriesLeft(int numberOfTriesLeft)
    {
        this.noOfTriesLeft = numberOfTriesLeft;
    }

    public Retry(int n)
    {
        this(n, DEFAULT_WAIT);
    }

    public Retry(int numberOfRetries, long timeToWait)
    {
        this.noOfRetries = numberOfRetries;
        noOfTriesLeft = numberOfRetries + 1;
        this.timeToWait = timeToWait;
    }

    public boolean retry()
    {
        return noOfTriesLeft > 0;
    }

    public void startRetry() throws Exception
    {
        noOfTriesLeft--;
        boolean b = !retry();
        if (b)
        {
            throw new Exception(noOfRetries + " attempts to retry failed at " + getTimeToWait() + "ms interval");
        } else
        {
            System.out.println("retries left: " + noOfTriesLeft);
            ParallelFactory.resetWebDriver();
        }
        waitUntilNextTry();
    }

    public long getTimeToWait()
    {
        return timeToWait;
    }

    private void waitUntilNextTry()
    {
        try
        {
            Thread.sleep(getTimeToWait());
        } catch (InterruptedException ignored)
        {
        }
    }

    public String retryTimes()
    {
        int n = noOfRetries + 1 - noOfTriesLeft;
        System.out.println(n);
        if (noOfTriesLeft == 0)
        {
            int n1 = n - 1;
            return "No. Retries: " + n1;
        } else
        {
            if (n > 0)
            {
                return "No. Retries:    " + n;
            } else
            {
                return "";
            }
        }
    }
}