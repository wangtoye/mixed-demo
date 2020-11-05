package com.wangtoye.mixeddemo.controller;

import com.wangtoye.mixeddemo.common.enums.EventEnum;
import com.wangtoye.mixeddemo.dto.statemachine.FlowDto;
import com.wangtoye.mixeddemo.service.statemachine.StateMachineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/3
 * Description:
 */
@RestController
@RequestMapping("/stateMachine")
@AllArgsConstructor
@Api(tags = "状态机")
public class StateMachineController {


    private final StateMachineService stateMachineService;

    @PostMapping("/create")
    @ApiOperation(value = "创建流程")
    public Integer create() {
        return stateMachineService.create();
    }

    @PostMapping("/apply")
    @ApiOperation(value = "提交")
    public Boolean apply(@RequestBody FlowDto flowDto) {
        return stateMachineService.sendEvent(flowDto, EventEnum.APPLY);
    }

    @PostMapping("/sign")
    @ApiOperation(value = "签名")
    public Boolean sign(@RequestBody FlowDto flowDto) {
        return stateMachineService.sendEvent(flowDto, EventEnum.SIGN);
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询当前状态")
    public String query(@RequestParam("id") Integer id) {
        return stateMachineService.queryStateById(id);

    }
}
