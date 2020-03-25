package com.common.plugin.util

import com.google.common.util.concurrent.ThreadFactoryBuilder
import java.util.concurrent.*

/**
 *  Created by hxh on 2020/3/25
 * 线程池管理
 */

object ThreadPoolManager {
    /**
     * 任务性质的线程池
     */
    @JvmStatic
    private val scheduledExecutorService: ScheduledThreadPoolExecutor =
            ScheduledThreadPoolExecutor(10, ThreadFactoryBuilder().setNameFormat("schedule-pool-0").build())
    /**
     * 普通性质的线程池
     */
    @JvmStatic
    private val executorService: ThreadPoolExecutor =
            ThreadPoolExecutor(100, 200,
                    0L, TimeUnit.MILLISECONDS,
                    LinkedBlockingQueue<Runnable>(1024), ThreadFactoryBuilder().setNameFormat("thread-pool-1").build())

    @JvmStatic
    fun scheduledExecutorService(): ScheduledExecutorService {
        return scheduledExecutorService
    }

    @JvmStatic
    fun executorService(): ThreadPoolExecutor {
        return executorService
    }
}