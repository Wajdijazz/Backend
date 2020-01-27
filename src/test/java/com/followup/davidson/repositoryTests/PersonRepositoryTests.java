package com.followup.davidson.repositoryTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.followup.davidson.model.Person;
import com.followup.davidson.repositories.PersonRepository;
import com.followup.davidson.services.IPersonService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTests {


}
