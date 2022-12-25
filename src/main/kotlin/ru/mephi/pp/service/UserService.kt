package ru.mephi.pp.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.request.user.UserDto
import ru.mephi.pp.model.entity.user.User
import ru.mephi.pp.model.repository.UserRepository

@Service
class UserService(
    @Autowired private val userCrudRepository: UserRepository
) {

    fun getAll(): MutableList<UserDto> {
        var userFromRepo = userCrudRepository.findAll()
        var users = mutableListOf<UserDto>()
        for(a in userFromRepo){
//            users.add(convertEntityToDto(a))
        }
        return users
    }

//    fun findById(id: Long) = convertEntityToDto(userCrudRepository.findById(id).get())

    fun add(user: User) = userCrudRepository.save(user)

    fun deleteById(id: Long) = userCrudRepository.deleteById(id)


//    fun convertEntityToDto(user: User) : UserDto {
//        val userDto : UserDto = UserDto(user.name, user.city)
//        return userDto
//    }
//
//    fun convertDtoToEntity(userDTO: UserDto) : User {
//    }
    
}