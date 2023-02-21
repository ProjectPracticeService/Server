package ru.mephi.pp.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.core.annotation.Order
import org.springframework.data.repository.findByIdOrNull
import org.springframework.util.Assert
import ru.mephi.pp.model.dto.info.profile.EduOrgInfo
import ru.mephi.pp.model.dto.input.profile.EduOrgInput
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.entity.user.Role
import ru.mephi.pp.model.entity.user.User
import ru.mephi.pp.model.repository.EduOrgRepository
import ru.mephi.pp.model.repository.UserRepository
import java.util.*

internal class EduOrgServiceTest {


    val eduOrgRepository = Mockito.mock(EduOrgRepository::class.java)
    val userRepository = Mockito.mock(UserRepository::class.java)
    val eduOrgService = EduOrgService(eduOrgRepository, userRepository)

    @BeforeEach
    @Test
    fun setupRepo() {
        // data
        val data = mutableListOf(
            EduOrg(1, "Mephi", 1),
            EduOrg(2, "MSU", 2),
            EduOrg(3, "HSE", 2)
        )
        val user = User(1,"test@mail.ru", "qwerty", setOf(Role.Mentor), "Paul", "Conor", "", "", 123, data.get(0))

        // userRepo
        Mockito.`when`(userRepository.getUserById(1)).thenReturn(user)
        Mockito.`when`(userRepository.getUsersByEduOrg(data.get(0))).thenReturn(listOf(user))

        // eduOrgRepo
        Mockito.`when`(eduOrgRepository.findAll()).thenReturn(data)
        Mockito.`when`(eduOrgRepository.getEduOrgById(1)).thenReturn(data.get(0))
    }

    @Test
    fun `educational organization filter in getEduOrgs`(){
        val eduOrgInfoFirstList = eduOrgService.getEduOrgs("H")
        val eduOrgInfoSecondList = eduOrgService.getEduOrgs("M")
        if (eduOrgInfoFirstList.get(0).id != 3.toLong() ||
            eduOrgInfoFirstList.size != 1 ||
            eduOrgInfoSecondList.size != 2
        ){ fail("the filter is not working correctly") }
    }


    @Test
    fun `wrapping an object in getEduOrgById`() {
        val eduOrgInfo = eduOrgService.getEduOrgById(1)
        if(eduOrgInfo.id != 1.toLong() ||
            eduOrgInfo.name != "Mephi" ||
            eduOrgInfo.city != 1.toLong()
        ){ fail("the wrong object was received") }
    }

}
