package ru.mephi.pp.repo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.mephi.pp.models.marks.Mark

@Repository
interface MarkRepo: CrudRepository<Mark, Long>