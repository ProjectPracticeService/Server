package ru.mephi.pp.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.repository.findByIdOrNull
import ru.mephi.pp.model.dto.info.profile.EduOrgInfo
import ru.mephi.pp.model.entity.profile.EduOrg
import ru.mephi.pp.model.repository.EduOrgRepository
import ru.mephi.pp.model.repository.UserRepository

@ExtendWith(MockitoExtension::class)
internal class EduOrgServiceTest {

    val eduOrgRepository: EduOrgRepository = mockk()
    val userRepository: UserRepository = mockk()
    val eduOrgService = EduOrgService(eduOrgRepository, userRepository);

//    @Mock
//    private lateinit var eduOrgRepository : EduOrgRepository

//    @Mock
//    private lateinit var userRepository : UserRepository
//
//    @InjectMocks
//    private val eduOrgService = EduOrgService(eduOrgRepository, userRepository)

    @Test
    fun getEduOrgs() {
    }

    @Test
    fun getEduOrgById() {
        val eduOrg = EduOrg(1, "Mephi", 5)
        every { eduOrgRepository.getEduOrgById(1) }.returns(eduOrg)
        val result = eduOrgService.getEduOrgById(1)
        verify(exactly = 1) { eduOrgRepository.getEduOrgById(1) };
        assertEquals(eduOrg, result)

    }

    @Test
    fun createEduOrg() {
    }

    @Test
    fun updateEduOrg() {
    }

    @Test
    fun assignEduOrg() {
    }

    @Test
    fun deAssignEduOrg() {
    }

    private fun getEduOrgInfo() : List<EduOrgInfo>{
        val eduOrgInfoFirst = EduOrgInfo(1, "Mephi", 5, listOf(1,5,9))
        val eduOrgInfoSecond = EduOrgInfo(2, "MSU", 5, listOf(3,8,2))
        return listOf(eduOrgInfoFirst, eduOrgInfoSecond)

    }
}