package com.heima.schedule.service.impl;

import com.heima.common.redis.CacheService;
import com.heima.model.schedule.dtos.Task;
import com.heima.schedule.ScheduleApplication;
import com.heima.schedule.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ScheduleApplication.class)
@RunWith(SpringRunner.class)
public class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;
    @Autowired
    private CacheService cacheService;

    @Test
    public void addTask(){

        Task task = new Task();
        task.setTaskType(100);
        task.setPriority(50);
        task.setParameters("task_test".getBytes());
        task.setExecuteTime(new Date().getTime() + 500);

        long taskId = taskService.addTask(task);
        System.out.println(taskId);
    }

    @Test
    public void cancleTask(){
        taskService.cancelTask(1702940958802108418L);
    }

    /**
     * 消费任务
     */
    @Test
    public void testPoll(){
        Task task = taskService.poll(100, 50);
        System.out.println(task);

    }

    /**
     * 获取所有keys，一般不使用keys
     */
    @Test
    public void testkeys(){
        Set<String> keys = cacheService.keys("future_*");
        System.out.println(keys);

        Set<String> scan = cacheService.scan("future_*");
        System.out.println(scan);
    }
}