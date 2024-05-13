package com.spark.worktool.controller;

import com.spark.worktool.command.Result;
import com.spark.worktool.command.TaskCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 17532
 * @description: TODO
 * @date 2024/5/13 23:47
 */

@RestController
public class WorkController {

    static Comparator<TaskCommand> comparator=new Comparator<TaskCommand>() {
        public int compare(TaskCommand o1, TaskCommand o2) {
                return o2.getLevel()-o1.getLevel();
        }
    };

    PriorityQueue<TaskCommand> taskCommands = new PriorityQueue<>(comparator);

    @PostMapping(value = "/api/offer")
    public Result offer(@RequestBody TaskCommand command){
        return new Result(taskCommands.offer(command)) ;
    }

    @GetMapping(value = "/api/poll")
    public Result poll(){
        return new Result(taskCommands.poll()) ;
    }

}
