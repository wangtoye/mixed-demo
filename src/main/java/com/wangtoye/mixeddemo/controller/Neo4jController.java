package com.wangtoye.mixeddemo.controller;

import com.wangtoye.mixeddemo.dto.neo4j.BankCardDto;
import com.wangtoye.mixeddemo.dto.neo4j.PersonBankCardRelationDto;
import com.wangtoye.mixeddemo.dto.neo4j.PersonDto;
import com.wangtoye.mixeddemo.dto.neo4j.PersonRelationDto;
import com.wangtoye.mixeddemo.service.neo4j.Neo4jService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/12
 * Description:
 */
@RestController
@RequestMapping("/neo4j")
@AllArgsConstructor
@Api(tags = "图数据库")
public class Neo4jController {

    private final Neo4jService neo4jService;

    @PostMapping("/addPerson")
    @ApiOperation(value = "添加用户")
    public String addPerson(@RequestBody PersonDto personDto) {
        neo4jService.addPerson(personDto);
        return "OK";
    }

    @DeleteMapping("/deletePerson")
    @ApiOperation(value = "删除用户")
    public String deletePerson(@RequestParam("id") Long id) {
        neo4jService.deletePerson(id);
        return "OK";
    }

    @GetMapping("/queryPerson")
    @ApiOperation(value = "查询用户")
    public List<PersonDto> queryPerson() {
        return neo4jService.queryPerson();
    }

    @PostMapping("/addPersonRelation")
    @ApiOperation(value = "添加用户关系")
    public String addPersonRelation(@RequestBody PersonRelationDto personRelationDto) {
        neo4jService.addPersonRelation(personRelationDto);
        return "OK";
    }

    @PostMapping("/addBankCard")
    @ApiOperation(value = "添加银行卡")
    public String addBankCard(@RequestBody BankCardDto bankCardDto) {
        neo4jService.addBankCard(bankCardDto);
        return "OK";
    }

    @PostMapping("/addPersonBankCardRelation")
    @ApiOperation(value = "添加用户银行卡关系")
    public String addPersonBankCardRelation(@RequestBody PersonBankCardRelationDto personBankCardRelationDto) {
        neo4jService.addPersonBankCardRelation(personBankCardRelationDto);
        return "OK";
    }
}
