package com.wangtoye.mixeddemo.service.neo4j;

import com.google.common.collect.Lists;
import com.wangtoye.mixeddemo.common.converter.BankCardConverter;
import com.wangtoye.mixeddemo.common.converter.PersonConverter;
import com.wangtoye.mixeddemo.dao.neo4j.BankCardDao;
import com.wangtoye.mixeddemo.dao.neo4j.DynamicHaveRelationDao;
import com.wangtoye.mixeddemo.dao.neo4j.DynamicKnowRelationDao;
import com.wangtoye.mixeddemo.dao.neo4j.PersonDao;
import com.wangtoye.mixeddemo.domain.neo4j.entity.BankCard;
import com.wangtoye.mixeddemo.domain.neo4j.entity.Person;
import com.wangtoye.mixeddemo.domain.neo4j.relation.DynamicHaveRelation;
import com.wangtoye.mixeddemo.domain.neo4j.relation.DynamicKnowRelation;
import com.wangtoye.mixeddemo.dto.neo4j.BankCardDto;
import com.wangtoye.mixeddemo.dto.neo4j.PersonBankCardRelationDto;
import com.wangtoye.mixeddemo.dto.neo4j.PersonDto;
import com.wangtoye.mixeddemo.dto.neo4j.PersonRelationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/12
 * Description:
 */
@Service
@AllArgsConstructor
public class Neo4jService {

    private final PersonDao personDao;
    private final BankCardDao bankCardDao;
    private final DynamicKnowRelationDao<Person, Person> dynamicKnowRelationDao;
    private final DynamicHaveRelationDao<Person, BankCard> dynamicHaveRelationDao;

    /**
     * 保存用户信息
     *
     * @param personDto 用户信息
     */
    public void addPerson(PersonDto personDto) {
        Person person = PersonConverter.INSTANCE.dto2Domain(personDto);
        personDao.save(person);
    }

    /**
     * 删除用户
     *
     * @param id id
     */
    public void deletePerson(Long id) {
        personDao.deleteById(id);
    }

    /**
     * 查询person列表
     *
     * @return List<PersonDto>
     */
    public List<PersonDto> queryPerson() {
        List<PersonDto> personDtoList = new ArrayList<>();

        Iterable<Person> personList = personDao.findAll();
        personList.forEach(person -> personDtoList.add(PersonConverter.INSTANCE.domain2Dto(person)));

        return personDtoList;
    }

    /**
     * 添加用户关系
     *
     * @param personRelationDto 关系数据
     */
    public void addPersonRelation(PersonRelationDto personRelationDto) {
        List<Long> ids = personRelationDto.getIds();
        if (ids.size() != 2) {
            return;
        }
        Iterable<Person> personIterable = personDao.findAllById(ids);
        List<Person> personList = Lists.newArrayList(personIterable);

        //构建相互关系
        dynamicKnowRelationDao.save(new DynamicKnowRelation<Person, Person>()
                .setCreateTime(LocalDateTime.now().toString())
                .setStartNode(personList.get(0))
                .setEndNode(personList.get(1)));
        dynamicKnowRelationDao.save(new DynamicKnowRelation<Person, Person>()
                .setCreateTime(LocalDateTime.now().toString())
                .setStartNode(personList.get(1))
                .setEndNode(personList.get(0)));
    }

    /**
     * 添加银行卡
     *
     * @param bankCardDto 银行卡信息
     */
    public void addBankCard(BankCardDto bankCardDto) {
        bankCardDao.save(BankCardConverter.INSTANCE.dto2Domain(bankCardDto));
    }

    /**
     * 添加用户银行卡关系
     *
     * @param personBankCardRelationDto 关系数据
     */
    public void addPersonBankCardRelation(PersonBankCardRelationDto personBankCardRelationDto) {
        Optional<Person> personOptional = personDao.findById(personBankCardRelationDto.getPersonId());
        Person person;
        if (personOptional.isPresent()) {
            person = personOptional.get();
        } else {
            return;
        }

        Iterable<BankCard> bankCardIterable = bankCardDao.findAllById(personBankCardRelationDto.getBankCardIds());
        bankCardIterable.forEach(bankCard -> dynamicHaveRelationDao.save(
                new DynamicHaveRelation<Person, BankCard>()
                        .setCreateTime(LocalDateTime.now().toString())
                        .setStartNode(person)
                        .setEndNode(bankCard)));

    }
}
