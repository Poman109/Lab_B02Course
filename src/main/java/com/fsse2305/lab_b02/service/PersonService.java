package com.fsse2305.lab_b02.service;

import com.fsse2305.lab_b02.data.*;
import com.fsse2305.lab_b02.data.entity.PersonEntity;
import com.fsse2305.lab_b02.service.impl.PersonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonServiceImpl {
    private static List<PersonEntity> personEntityList = new ArrayList<>();


    @Override
    public CreatedPersonData createPerson(CreatePersonData createPersonData){
        //Lv1
//        PersonEntity personEntity = new PersonEntity(createPersonData);
//        personEntity.setFirstName(createPersonData.getFirstName());
//        personEntity.setLastName(createPersonData.getLastName());
//        personEntity.setHkid(createPersonData.getHkid());

        //Lv2
        PersonEntity personEntity = new PersonEntity(createPersonData);

        personEntityList.add(personEntity);

//          Lv1
//        CreatedPersonData createdPersonData = new CreatedPersonData();
//        createdPersonData.setFirstName(personEntity.getFirstName());
//        createdPersonData.setLastName(personEntity.getLastName());
//        createdPersonData.setHkid(personEntity.getHkid());

        //Lv2
        CreatedPersonData createdPersonData = new CreatedPersonData(personEntity);

        return createdPersonData;

    }



    @Override
    public UpdatedPersonData updatePerson(UpdatePersonData updatePersonData){
//        for(int i=0; i<personEntityList.size();i++ )

        for(PersonEntity personEntity1 : personEntityList){
            if (!personEntity1.getHkid().equals(updatePersonData.getHkid())){
                continue;
            }
            personEntity1.setLastName(updatePersonData.getLastName());
            personEntity1.setFirstName(updatePersonData.getFirstName());

            UpdatedPersonData updatedPersonData = new UpdatedPersonData(personEntity1);


            return updatedPersonData;

        }
        throw new NotFoundPeopleException();

    }


    @Override
    public DeletedPersonData deletePerson(DeletePersonData deletePersonData){
        for(PersonEntity personEntity1 : personEntityList){
            if(!personEntity1.getHkid().equals(deletePersonData.getHkid())){
                continue;
            }
            personEntityList.remove(personEntity1);
            DeletedPersonData deletedPersonData = new DeletedPersonData(personEntity1);
            return  deletedPersonData;
        }

        throw new NotFoundPeopleException();
    }

    @Override
    public List<GetAllPersonData> getPerson() {
        List<GetAllPersonData> getAllPeopleList = new ArrayList<>();
        for (PersonEntity personEntity : personEntityList){
            GetAllPersonData getAllPersonData = new GetAllPersonData(personEntity);
            getAllPeopleList.add(getAllPersonData);
        }
        return getAllPeopleList;
    }

    public List<GotPersonByLastNameData> getPersonByLastname(GetPersonByLastNameData getPersonByLastNameData){
        List<GotPersonByLastNameData> gotPersonByLastNameDataArrayList = new ArrayList<>();
        for(PersonEntity personEntity2 : personEntityList) {
            if (!personEntity2.getLastName().equals(getPersonByLastNameData.getLastName())) {
                continue;
            }
            GotPersonByLastNameData gotPersonByLastNameData = new GotPersonByLastNameData(personEntity2);
            gotPersonByLastNameDataArrayList.add(gotPersonByLastNameData);
        }
            return gotPersonByLastNameDataArrayList;

    }

    public PersonEntity getCourseTeacher(String teacherHkid){
        for(PersonEntity personEntity:personEntityList){
            if(personEntity.getHkid().equals(teacherHkid)){
                return personEntity;
            }
        }

        return null;
    }


}
