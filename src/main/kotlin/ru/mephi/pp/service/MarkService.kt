package ru.mephi.pp.service

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mephi.pp.model.dto.input.mark.MarkInput
import ru.mephi.pp.model.entity.marks.Mark
import ru.mephi.pp.model.repository.MarkRepo

@Service
class MarkService {

//    @Autowired(required = false)
//    private lateinit var markCrudRepository: MarkRepo
//
//    @Autowired(required = false)
//    private lateinit var modelMapper : ModelMapper
//
//    fun getAll(): MutableIterable<MarkInput> {
//        var marksFromRepo = markCrudRepository.findAll()
//        var mark = mutableListOf<MarkDto>()
//        for(a in marksFromRepo){
//            mark.add(convertEntityToDto(a))
//        }
//        return mark
//    }
//
//    fun findById(id: Long) = convertEntityToDto(markCrudRepository.findById(id).get())
//
//    fun add(mark: Mark) = markCrudRepository.save(mark)
//
//    fun deleteById(id: Long) = markCrudRepository.deleteById(id)
//
//    fun convertEntityToDto(mark: Mark) : MarkDto {
//        modelMapper.configuration.matchingStrategy = MatchingStrategies.LOOSE
//        var markDTO : MarkDto
//        markDTO = modelMapper.map(mark, MarkDto::class.java)
//        return markDTO
//    }
//
//    fun convertDtoToEntity(markDTO: MarkDto) : Mark {
//        modelMapper.configuration.matchingStrategy = MatchingStrategies.LOOSE
//        var mark : Mark
//        mark = modelMapper.map(markDTO, Mark::class.java)
//        return mark
//    }
}